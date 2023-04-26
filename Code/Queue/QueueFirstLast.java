public class QueueFirstLast<E> implements Queueable<E> {
    Node<E> first;
    Node<E> last;

    public QueueFirstLast() {
        this.first = null;
        this.last = null;
    }

    @Override
    public boolean isEmpty() {
        return (this.first == null);
    }

    @Override
    public void dequeueAll() {
        this.first = null;
        this.last = null;
    }

    @Override
    public E peek() throws QueueException {
        if (this.isEmpty())
            throw new QueueException("Queue is empty.");
        else
            return this.first.getItem();
    }

    @Override
    public void enqueue(E item) {
        Node<E> node = new Node<E>(item);
        if (this.isEmpty()) 
            this.first = node;            
        else 
            this.last.setNext(node);
                
        this.last = node;
    }

    @Override
    public E dequeue() throws QueueException {
        if (this.isEmpty())
            throw new QueueException("Queue is empty.");
        else {
            Node<E> next = this.first.getNext();
            E front = this.first.getItem();
            this.first = next;
            return front;
        }
    }

    @Override
    public String toString() {
        String s = "[";
        Node<E> current = this.first;
        while (current != null) {
            s = s + current.getItem().toString();
            if (current.getNext() != null)
                s += ", ";

            current = current.getNext();
        }
        return s + "]";
    }
}