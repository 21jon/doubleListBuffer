
/**
 * leiste
 */

public class leiste<T> {

    Item<T> head;
    Item<T> tail;

    public leiste() {

    }

    public void enque(T data) {

        Item<T> neu = new Item<>(data);

        tail.setPrev(neu);
        neu.setNext(tail);
        tail = neu;

    }

    public T deque() {

        Item<T> temp = head;

        head = head.getPrev();
        head.setNext(null);
        head.setPrev(head.getPrev());

        return temp.getData();

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
