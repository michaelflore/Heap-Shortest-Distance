public class HeapDemo {
    public static void main(String[] args) throws HeapOverflowException, HeapUnderflowException {
        //Creating queue
        HeapPriorityQueue heapQueue = new HeapPriorityQueue();

        //Adding items to queue
        heapQueue.enqueue(1);
        heapQueue.enqueue(2);
        heapQueue.enqueue(3);
        heapQueue.enqueue(4);
        heapQueue.enqueue(5);
        heapQueue.enqueue(6);
        heapQueue.enqueue(7);
        heapQueue.enqueue(8);
        heapQueue.enqueue(9);
        heapQueue.enqueue(10);

        //Printing queue
        System.out.println("Heap values with levels:");
        System.out.println(heapQueue);

        //Removing items from front of queue (those with priority)
        heapQueue.dequeue();
        heapQueue.dequeue();

        //Printing queue
        System.out.println("\nHeap after two dequeue:");
        System.out.println(heapQueue);
    }
}
