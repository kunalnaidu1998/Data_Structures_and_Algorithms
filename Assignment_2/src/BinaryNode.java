public class BinaryNode<T> {
    private T data;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public BinaryNode(T theData, BinaryNode<T> theLeft, BinaryNode<T> theRight) {
        data = theData;
        left = theLeft;
        right = theRight;
    }
    public BinaryNode(T theData) {
        data = theData;
        left = null;
        right = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryNode<T> right) {
        if(this == right)
            throw new IllegalArgumentException("A node cannot be its parent!");

        this.right = right;
    }

    public boolean hasLeft(){
        if(left == null)
            return false;
        return true;
    }

    public boolean hasRight(){
        if(right == null)
            return false;
        return true;
    }

    /**
     * counts the number of leaves in a binary tree
     * @param root root of the binary tree
     * @return number of leaves
     * @param <T>
     */
    public static <T> int numLeaves(BinaryNode<T> root) {
        // check if root is empty
        if (root == null) {
            return 0;
            // check if left node and right node of tree is empty
        } else if (root.getLeft() == null && root.getRight() == null) {
            return 1;
            // look at left child and add to stuff in right child recursively
        } else {
            return numLeaves(root.getLeft()) + numLeaves(root.getRight());
        }
    }

}