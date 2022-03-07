package trees;

public class Baum<T> {

    Node<T> root;

    public Baum() {
        super();

    }

    public void addItem(String path, T item) {

        String[] pathparts = path.split("/");

        Node<T> wen = new Node<>(item);

        Node<T> runner = root;
        int index = 0;
        while (runner.getLeft() != null && runner.getRight() != null) {

            if (runner.getLeft().getData() == pathparts[index]) {
                runner = runner.getLeft();
                index = index + 1;
                continue;
            }
            if (runner.getRight().getData() == pathparts[index]) {
                runner = runner.getRight();
                index = index + 1;
                continue;
            }

        }

    }

    public void printTree() {

        printTree(root);
    }

    public void printTree(Node<T> node) {

        if (node == null) {
            return;
        }

        System.out.print(node.getData() + " ");

        printTree(node.getLeft());
        printTree(node.getRight());

    }

    public T findMinValue() {
        if (root == null)
            throw new IllegalStateException("Fuck me ");

        Node<T> runner = root;

        while (runner.getLeft() != null) {

            runner = runner.getLeft();

        }

        return runner.getData();

    }

    public T findMaxValue() {
        if (root == null)
            throw new IllegalStateException("Fuck me ");

        Node<T> runner = root;

        while (runner.getRight() != null) {

            runner = runner.getRight();

        }

        return runner.getData();

    }
}

/**
 * Node
 */
class Node<T> {

    T data;
    Node<T> left;
    Node<T> right;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

}