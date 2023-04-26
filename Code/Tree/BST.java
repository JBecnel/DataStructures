public class BST<T extends Comparable<T>> {
    private T root;
    private BST<T> left;
    private BST<T> right;

    public BST() {
        this.root = null;
    }

    public BST(T root) {
        this.root = root;
        this.left = new BST<T>();
        this.right = new BST<T>();
    }

    
    public boolean isEmpty() {
        return (this.root == null);
    }

    public void removeAll() {
        this.root = null;
        this.left = null;
        this.right = null;
    }

    public int numElements() {
        if (this.isEmpty())
            return 0;
        else 
            return 1 + this.left.numElements() + this.right.numElements();
    }

    public int height() {
        if (this.isEmpty())
            return 0;
        else
            return 1 + Math.max(this.left.height(), this.right.height());
    }

    public void add(T item) {
        if (this.isEmpty()) {
            this.root = item;
            this.left = new BST<T>();
            this.right = new BST<T>();
        } else {
            int compare = item.compareTo(this.root);
            if (compare < 0) 
                this.left.add(item);
            else
                this.right.add(item);
        }
    }

    public T max() {
        if (this.isEmpty())
            throw new TreeException("Tree is empty!");

        if (this.right.isEmpty())
            return this.root;
        else
            return this.right.max();
    }


    public T min() {
        if (this.isEmpty())
            throw new TreeException("Tree is empty!");

        if (this.left.isEmpty())
            return this.root;
        else
            return this.left.max();
    }

    public String inOrder() {
        String s = "";
        if (!this.isEmpty()) {
            s += this.left.inOrder();
            s += " " + this.root.toString() + " ";
            s += this.right.inOrder();
        }
        return s;
    }

    public String postOrder() {
        String s = "";
        if (!this.isEmpty()) {
            s += this.left.postOrder();            
            s += this.right.postOrder();
            s += " " + this.root.toString() + " ";
        }
        return s;
    }

    public String preOrder() {
        String s = "";
        if (!this.isEmpty()) {
            s += " " + this.root.toString() + " ";
            s += this.left.postOrder();            
            s += this.right.postOrder();     
        }
        return s;
    }

    public void remove(T item) {
        if (this.isEmpty())
            throw new TreeException("Tree is empty.");

        int compare = item.compareTo(this.root);
        if (compare < 0)
            this.left.remove(item);
        else if (compare > 0)
            this.right.remove(item);
        else {
            if (this.left.isEmpty() && this.right.isEmpty()) {
                this.root = null;
                this.left = null;
                this.right = null;
            } else if (this.left.isEmpty()) {
                this.root = this.right.root;
                this.left = this.right.left;
                this.right = this.right.right;
            } else if (this.right.isEmpty()) {
                this.root = this.left.root;
                this.right = this.left.right;
                this.left = this.left.left;                
            } else {
                T newRoot = this.right.min();
                this.root = newRoot;
                this.right.remove(newRoot);
            }
                
        }
    }
    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        if (!this.isEmpty())
            buildTreeString(buffer, "", "");
        return buffer.toString();
    }
    
    private void buildTreeString(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(this.root.toString());
        buffer.append('\n');
        if (!this.left.isEmpty()) 
            if (!this.right.isEmpty())
                left.buildTreeString(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            else
                left.buildTreeString(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
        
        if (!this.right.isEmpty())
            right.buildTreeString(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
    }


}
