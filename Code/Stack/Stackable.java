public interface Stackable<E> {
    public boolean isEmpty();

    // Determines whether the stack is empty.
    public void popAll();

    // Removes all the items from the stack.
    public E peek() throws StackException;

    // Retrieves the top of a stack.
    public void push(E newItem) throws StackException;

    // Adds an item to the top of a stack.
    public E pop() throws StackException;
    // Removes the top of a stack.
}
