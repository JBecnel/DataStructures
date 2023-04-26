public class StackReferenceBased<E> implements Stackable<E> {

    Node<E> top;

    public StackReferenceBased() {
        this.top = null;
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    public void popAll() {
        this.top = null;
    }

    @Override
    public void push(E newItem) {
        Node<E> currentTop = this.top;
        this.top = new Node<E>(newItem);
        this.top.setNext(currentTop);
    }

    @Override
    public E pop() throws StackException {
        if (this.isEmpty()) {
            throw new StackException("Error: stack empty!");
        } else {
            E topItem = top.getItem();
            top = top.getNext();
            return topItem;
        }
    }

    @Override
    public E peek() throws StackException {
        if (this.isEmpty()) {
            throw new StackException("Error: stack empty!");
        } else {
            return top.getItem();
        }
    }

    @Override
    public String toString() {
        String s = "[";
        Node<E> current = this.top;
        while (current != null) {
            s = s + current.getItem().toString();
            current = current.getNext();
            if (current != null)
                s = s + ", ";
        }
        s += "]";
        return s;
    }
}
