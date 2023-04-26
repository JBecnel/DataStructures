public class StackArrayBased<E> implements Stackable<E> {

    private final int MAX_STACK = 50;
    private Object[] items; // cannot use generic arrays in Java
    private int top; // index of the top

    public StackArrayBased() {
        this.items = new Object[MAX_STACK];
        this.top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top < 0;
    }

    // added due to restrictive nature of implementation
    public boolean isFull() {
        return top == (MAX_STACK - 1);
    }

    @Override
    public void popAll() {
        this.items = new Object[MAX_STACK]; // garbage collect references
        top = -1;

    }

    @Override
    public void push(E newItem) throws StackException {
        if (isFull())
            throw new StackException("Stack maximum is at maximum capacity.");
        else {
            top++;
            this.items[top] = newItem;
        }

    }

    @Override
    public E pop() throws StackException {
        if (isEmpty())
            throw new StackException("Stack is empty.");
        else {
            E item = (E) this.items[top];
            top--;
            return item;
        }
    }

    @Override
    public E peek() throws StackException {
        if (isEmpty())
            throw new StackException("Stack is empty.");
        else {
            return (E) this.items[top];
        }
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = top; i >= 0; i--) {
            s = s + this.items[i].toString();
            if (i != 0)
                s = s + ", ";
        }
        s = s + "]";
        return s;
    }

}
