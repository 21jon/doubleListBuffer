
/*
 * Challenge 1: Abstrakte Datentypen => Nur Schnittstelle (die öffentlichen Methoden, die er bietet) muss bekannt sein,
 * nicht die
 * Implementation (wie es programmiert
 * ist)
 *    (Verkettete Liste vs. Array)
 *
 * Challenge 2: Haben Sie eine Idee, wie Sie auf die Überprüfungen auf head == null verzichten können?
 *
 * Challenge 3: DVK
 */

/*
 * Desiderata:
 * ) concat(Liste<T> otherList) => void | Mehrere Elemente gleichzeitig anhängen 
 * 2) get(int index) => T | Element an einer bestimmten Stelle zurückgeben
 * 3) deleteAt(int index) => T | void
 *    // T data = list.deleteAt(5)
 *    // list.deleteAt(5) => Rückgabewert wird verworfen
 * 4) move(int from, int to)
 * 5) set(int index, T data) überschreiben
 * 6) insert(int index, T data)
 * 7) size() => Größe der Liste
 * 8) filter() => Auswählen nach Kriterien
 * 9) get(T data) => Suche nach Daten
 * 10) indexOf(T data) => Suche nach Index von Daten
 *
 * Nice to have:
 * 1) maxSize()
 */

/**
 * 
 * leiste
 */

public class leiste<T> extends listutils<T> {
    private Item<T> head;
    private Item<T> tail;
    int size = 0;

    /**
     * 
     * @param data
     */
    public void enque(T data) {
        Item<T> neu = new Item<>(data);

        if (isEmpty()) {

            head = neu;
            tail = neu;
            return;
        }

        head.setNext(neu);
        neu.setPrev(head);
        head = neu;

        size++;

    }

    /**
     * 
     * @return
     */
    public T deque() {

        if (isEmpty())
            throw new RuntimeException("List is empty");

        if (head == tail) {

            T data = tail.getData();

            clear();

            return data;

        }

        Item<T> temp = tail;

        tail = tail.getNext();
        tail.setNext(tail.getNext());
        tail.setPrev(null);

        size--;
        return temp.getData();

    }

    /**
     * 
     * @return
     */
    public T top() {
        return head.getData();
    }

    public T get(int index) {

        if (index < 0)
            throw new RuntimeException("Jaja");

        return getPredecessor(index + 1).getData();

    }

    /**
     * 
     * @param index
     * @return
     */
    public T deleteAt(int index) {

        Item<T> prev = getPredecessor(index);

        T torem = prev.getNext().getData();
        Item<T> next = prev.getNext().getNext();

        prev.setNext(next);
        next.setPrev(prev);

        size--;
        return torem;
    }

    public void move(int from, int to) {

        if (from == to)
            return;

        if (to > from)
            to++;

        Item<T> frmtemp = getPredecessor(from++);

        frmtemp.getPrev().setNext(frmtemp.getNext());
        frmtemp.getNext().setPrev(frmtemp.getPrev());

        Item<T> motor = getPredecessor(to);

        frmtemp.setNext(motor.getNext());
        frmtemp.setPrev(motor.getPrev());

        motor.setNext(frmtemp);
        frmtemp.getNext().setPrev(frmtemp);

    }

    public void swap(int from, int to) {

        Item<T> frm = getPredecessor(from++);
        Item<T> temp = getPredecessor(to++);

        T d1 = frm.getData();
        T d2 = temp.getData();

        frm.setData(d2);
        temp.setData(d1);

    }

    public void set(int index, T data) {

        getPredecessor(index++).setData(data);

    }

    public void insert(int index, T data) {

        Item<T> toin = new Item<>(data);
        Item<T> prev = getPredecessor(index);

        if (index - 1 == size()) {
            enque(data);
        }

        prev.getNext().setPrev(toin);
        toin.setNext(prev.getNext());
        prev.setNext(toin);
        toin.setPrev(prev);

        size++;

    }

    public void insertmany(leiste<T> data) {

    }

    public void debug() {

        Item<T> runner = head;
        if (runner == null) {
            System.out.println("Leer");
        }
        int index = 0;
        while (runner != null) {

            System.out.printf("%d: %s; ", index, runner.getData());
            runner = runner.getNext();
            index++;

        }
        System.out.print("\n");

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
    // bsw09a
}

/**
 * Item
 */
class Item<T> {

    private Item<T> prev;
    private Item<T> next;
    private T data;

    /**
     * 
     * @param data
     */
    public Item(T data) {
        this.data = data;
    }

    /**
     * 
     * @return
     */
    public Item<T> getPrev() {
        return prev;
    }

    /**
     * 
     * @param prev
     */
    public void setPrev(Item<T> prev) {
        this.prev = prev;
    }

    /**
     * 
     * @return
     */
    public Item<T> getNext() {
        return next;
    }

    /**
     *
     * @param next
     */
    public void setNext(Item<T> next) {
        this.next = next;
    }

    /**
     * 
     * @return
     */
    public T getData() {
        return data;
    }

    /**
     * 
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

}
