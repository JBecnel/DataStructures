public class TreeNode<T> {

    private T item; // item stored in this node
    private TreeNode<T> leftChild; // reference to left subtree
    private TreeNode<T> rightChild; // reterence to right subtree

    // Initialized tree node with item and no children
    public TreeNode(T newItem) {
        item = newItem;
        leftChild = null;
        rightChild = null;
    } // end constructor

    // Initializes tree node with item and
    // the left and right children references.
    public TreeNode(T newItem, TreeNode<T> left, TreeNode<T> right) {
        item = newItem;
        leftChild = left;
        rightChild = right;
    } // end constructor

    public T getItem() {
        return item;
    }

    public void setItem(T newItem) {
        item = newItem;
    }

    public TreeNode<T> getLeft() {
        return leftChild;
    }

    public void setLeft(TreeNode<T> newLeftChild) {
        leftChild = newLeftChild;
    }

    public TreeNode<T> getRight() {
        return rightChild;
    }

    public void setRight(TreeNode<T> newRightChild) {
        rightChild = newRightChild;
    }


    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        buildTreeString(buffer, "", "");
        return buffer.toString();
    }

    private void buildTreeString(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(this.item.toString());
        buffer.append('\n');
        if (this.leftChild != null) 
            if (this.rightChild != null)
                leftChild.buildTreeString(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            else
                leftChild.buildTreeString(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
        
        if (this.rightChild != null)
            rightChild.buildTreeString(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
    }
/*         next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");

        for (Iterator<TreeNode> it = children.iterator(); it.hasNext();) {
            TreeNode next = it.next();
            if (it.hasNext()) {
                next.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    */
    
} // end TreeNode
