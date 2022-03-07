package trees;

public class test {

    public static void main(String[] args) {

        Baum<Integer> baum = new Baum<>();

        Node<Integer> n23 = new Node<>(23,
                new Node<Integer>(5, new Node<Integer>(2, new Node<Integer>(1), new Node<Integer>(3)),
                        new Node<Integer>(20, new Node<Integer>(10), new Node<Integer>(21))),
                new Node<Integer>(50, new Node<Integer>(30, new Node<Integer>(25), new Node<Integer>(47)), null));

        baum.root(n23);

    }

}
