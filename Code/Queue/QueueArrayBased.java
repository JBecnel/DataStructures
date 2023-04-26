public class QueueArrayBased<E> implements Queueable<E> {
    public final int MAX_QUEUE = 50;
    private Object[] queueArray;
    private int size;

    // Create an empty queue
    public QueueArrayBased() {
        this.queueArray = new Object[this.MAX_QUEUE];
        this.size = 0;
    }

    // Determine if queue is empty
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    // Adds new item to the end of the queue.
    @Override
    public void enqueue(E newItem) throws QueueException {
        if (this.size == this.MAX_QUEUE)
            throw new QueueException("Error: Queue is full!");

        this.queueArray[this.size] = newItem;
        this.size++;
    }

    // Retrieves and then removes the item at the front
    // of the queue.
    @Override
    public E dequeue() throws QueueException {
        if (this.isEmpty())
            throw new QueueException("Error: Empty queue!");

        E returnItem = (E) this.queueArray[0];
        for (int i = 1; i < this.size; i++)
            this.queueArray[i - 1] = this.queueArray[i];
        
        this.size--;

        return returnItem;
    }

    // Remove all items from the queue
    @Override
    public void dequeueAll() {
        this.size = 0;
    }

    // Retrieves the item at the front of the queue.
    @Override
    public E peek() throws QueueException {
        if (this.isEmpty())
            throw new QueueException("Error: Empty queue!");

        return (E) this.queueArray[0];
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i =0; i < size; i++) {
            s = s + this.queueArray[i].toString();
            if (i != size-1)
                s = s + ", ";
        }

        return s + "]";
    }
}
