public interface Queueable<E> {
    public boolean isEmpty();
    public void dequeueAll();
    public E peek() throws QueueException;
    public void enqueue(E item);
    public E dequeue() throws QueueException;    
}
