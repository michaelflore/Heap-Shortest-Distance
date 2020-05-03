public class HeapPriorityQueue implements HeapInterface {
    //Fields
    private Comparable[] heapArray;
    private int current;
    private int last;

    //Default Constructor
    public HeapPriorityQueue() {
        heapArray = new Comparable[250];
        current = -1;
        last = 250 - 1;
    }

    //Checks if queue is empty
    public boolean isEmpty() {
        return (current == -1);
    }

    //Checks if queue is full
    public boolean isFull() {
        return (current == last);
    }

    //Adds item to back of queue
    public void enqueue(Comparable value) throws HeapOverflowException {
        if(current == last) {
            throw new HeapOverflowException("Heap overflow");
        }

        current++;
        reheapUpward(value);
    }

    //Removes item from front of queue
    public Comparable dequeue() throws HeapUnderflowException {
        if(current == -1) {
            throw new HeapUnderflowException("Heap underflow");
        }

        Comparable toRemove = heapArray[0];
        Comparable temp = heapArray[current];
        current--;
        reheapDownward(temp);

        return toRemove;
    }

    //Raise item upward until it has a parent with higher priority
    public void reheapUpward(Comparable val) {
        int position = current;

        while(position > 0 && val.compareTo(heapArray[(position - 1) / 2]) > 0) {
            heapArray[position] = heapArray[(position - 1) / 2];
            position = (position - 1) / 2;
        }

        heapArray[position] = val;
    }

    //Sink item downward until it no longer has a child with higher priority
    public void reheapDownward(Comparable val) {
        int position = 0;
        int move = reposition(position, val);
        while(move != position) {
            heapArray[position] = heapArray[move];
            position = move;
            move = reposition(position, val);
        }

        heapArray[position] = val;
    }

    //Reposition the items as needed by reheap methods
    public int reposition(int pos, Comparable val) {
        int leftPosition = (pos * 2) + 1;
        int rightPosition = (pos * 2) + 2;

        if(leftPosition > current) {
            return pos;
        }
        else if(leftPosition == current) {
            if(val.compareTo(heapArray[leftPosition]) < 0) {
                return leftPosition;
            }
            else {
                return current;
            }
        }
        else if(heapArray[leftPosition].compareTo(heapArray[rightPosition]) < 0) {
            if(heapArray[rightPosition].compareTo(val) <= 0) {
                return current;
            }
            else {
                return rightPosition;
            }
        }
        else {
            if(heapArray[leftPosition].compareTo(val) <= 0) {
                return current;
            }
            else {
                return leftPosition;
            }
        }
    }

    //Overridden toString method
    public String toString() {
        StringBuilder strBuild = new StringBuilder();
        int level = 1;
        int count = 1;
        int i = 0;

        while(i <= current) {
            for(int j = 0; j < count && i <= current; j++) {
                strBuild.append(heapArray[i]).append(" at level ").append(level).append("\n");
                i++;
            }

            level++;
            count *= 2;
        }

        return strBuild.toString();
    }
}
