
/**
 * leiste
 */

public class leiste<T> {

    Item<T> head;
    Item<T> tail;

    public leiste() {
        clear();
    }

    public void clear() {

        head = null;
        tail = null;

    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public int size() {

        Item<T> runner = head;

        int i = 0;
        while (runner != null) {

            i++;
            runner = runner.getNext();

        }

        return i;

    }

    public void enque(T data) {
        Item<T> neu = new Item<>(data);

        if (isEmpty()) {

            head = neu;
            tail = neu;
            return;
        }

        head.setPrev(neu);
        tail.setNext(neu);
        tail = neu;

    }

    public T deque() {

        if (isEmpty())
            throw new RuntimeException("List is empty");

        if (head == tail) {

            T data = head.getData();

            clear();

            return data;

        }

        Item<T> temp = head;

        head = head.getPrev();
        head.setNext(null);
        head.setPrev(head.getPrev());

        return temp.getData();

    }

    public T top() {
        return head.getData();
    }

    public T get(int index) {

        if (index < 0)
            throw new RuntimeException("Jaja");

        return getPredecessor(index + 1).getData();

    }

    private Item<T> getPredecessor(int index) {
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

    public T deleteAt(int index) {

        Item<T> prev = getPredecessor(index);

        T torem = prev.getNext().getData();
        Item<T> next = prev.getNext().getNext();

        prev.setNext(next);
        next.setPrev(prev);

        return torem;

    }

    public void debug() {

        Item<T> runner = head;
        if (runner == null) {
            System.out.println("Leer");
        }
        while (runner != null) {

            System.out.println(runner.getData());
            runner = runner.getNext();

        }

    }

}

/**
 * Item
 */
class Item<T> {

    private Item<T> prev;
    private Item<T> next;
    private T data;

    public Item(T data) {
        this.data = data;
    }

    public Item<T> getPrev() {
        return prev;
    }

    public void setPrev(Item<T> prev) {
        this.prev = prev;
    }

    public Item<T> getNext() {
        return next;
    }

    public void setNext(Item<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
