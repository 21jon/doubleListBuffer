package leiste;

/**
 * {@link listutils}
 * listutils
 */

abstract class listutils<T> {

    private Item<T> head;
    private Item<T> tail;
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
    /**
     * 
     * @return
     */
    public int size() {

        Item<T> runner = head;

        int i = 0;
        while (runner != null) {

            i++;
            runner = runner.getNext();

        }

        return i;

    }

    /**
     * 
     * @param index
     * @return
     */

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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
