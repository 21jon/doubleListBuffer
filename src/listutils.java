
/**
 * {@link listutils}
 * listutils
 */

public abstract class listutils<T> {

    Item<T> head;
    Item<T> tail;
    int size = 0;

    public listutils() {
        clear();
    }

    public void clear() {
        size = 0;
        head = null;
        tail = null;

    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    @Deprecated

    public int size() {

        Item<T> runner = head;

        int i = 0;
        while (runner != null) {

            i++;
            runner = runner.getNext();

        }

        return i;

    }

    public Item<T> getPredecessor(int index) {
        index--;

        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Liste ist leer.");
        }

        if (index >= size()) {
            throw new IllegalArgumentException("index too high");
        }

        Item<T> runner = head;

        for (int i = 0; i < index - 1; i++) {
            runner = runner.getNext();
        }

        return runner;
    }

}