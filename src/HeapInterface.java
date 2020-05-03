public interface HeapInterface {

    boolean isEmpty(); //Checks if queue is empty
    boolean isFull(); //Checks if queue is full
    
    //Adds item to back of queue
    void enqueue(Comparable item) throws HeapOverflowException;
    //Removes item from front of queue
    Comparable dequeue() throws HeapUnderflowException;
    //Raise item upward until it has a parent with higher priority
    void reheapUpward(Comparable val);
    //Sink item downward until it no longer has a child with higher priority
    void reheapDownward(Comparable val);
    //Reposition the items as needed by reheap methods
    int reposition(int pos, Comparable val);
}