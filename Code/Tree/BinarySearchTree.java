public  class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void removeAll() {
        this.root = null;
    }

    public T getRoot() {
        if (this.isEmpty()) 
            throw new TreeException("Tree is empty.");
        else
            return this.root.getItem();
    }

    public void add(T item) {
        TreeNode<T> node = new TreeNode<T>(item);
        if (this.isEmpty())
            this.root = node;
        else {
            TreeNode<T> current = this.root;
            while (current != null) {
                if (item.compareTo(current.getItem()) < 0) {
                    if (current.getLeft() == null) {
                        current.setLeft(node);
                        current = null; // break the loo;
                    }
                    else 
                        current = current.getLeft();
                }                    
                else {
                    if (current.getRight() == null) {
                        current.setRight(node);
                        current = null; // break the loo;
                    }
                    else 
                        current = current.getRight();
                }
            }
            
        } // end else
    }  // end add

    public boolean contains(T item) {
        return this.contains(this.root, item);
    }

    public boolean contains(TreeNode<T> current, T item) {
        if (current == null)
            return false;
        else {
            T currentItem = current.getItem();
            int compare = item.compareTo(currentItem);

            if (compare == 0)
                return true;
            else if (compare < 0)
                return contains(current.getLeft(), item);
            else
                return contains(current.getRight(), item);
        }
    }
    





    @Override
    public String toString() {        
        return convertToString(root);
    }


    




    private String convertToString(TreeNode<T> node) {
        if (node == null)
            return "";
        else {
            String s = convertToString(node.getLeft());
            s += " " + node.getItem().toString() + " ";
            s += convertToString(node.getRight());
            return s;            
        }
    }

    public String prettyPrint() {
        return this.root.toString();
    }

    
}
