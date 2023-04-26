public class QueueCircular<E> implements Queueable<E> {

    Node<E> last;

    public QueueCircular() {
        this.last = null;
    }

    @Override
    public boolean isEmpty() {
        return (this.last == null);
    }

    public boolean isSingleton() {
        if (this.isEmpty())
            return false;
        else
            return (this.last == this.last.getNext());
    }

    @Override
    public void dequeueAll() {
        this.last = null;
    }

    @Override
    public E peek() throws QueueException {
        if (this.isEmpty())
            throw new QueueException("Queue is empty.");
        else {
            Node<E> first = last.getNext();
            return first.getItem();
        }
    }

    @Override
    public void enqueue(E item) {
        Node<E> node = new Node<E>(item);
        Node<E> first;
        if (isEmpty()) {
            first = node;
            this.last = node;
        } else {
            first = this.last.getNext();
        }
        node.setNext(first);
        this.last.setNext(node);
        this.last = node;
    }

    @Override
    public E dequeue() throws QueueException {
        if (this.isEmpty())
            throw new QueueException("Queue is empty.");

        Node<E> first = this.last.getNext();
        if (this.isSingleton())
            this.last = null;
        else {
            Node<E> next = first.getNext();
            this.last.setNext(next);
        }

        return first.getItem();
    }

    @Override
    public String toString() {
        if (this.isEmpty())
            return "[]";
        else {
            String s = "[";
            Node<E> current = this.last.getNext();

            while (current != this.last) {
                s = s + current.getItem().toString() + ", ";
                current = current.getNext();
            }
            s = s + this.last.getItem(); // add the last item

            return s + "]";
        }
    }

}
