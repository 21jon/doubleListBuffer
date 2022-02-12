
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
 * 1) concat(Liste<T> otherList) => void | Mehrere Elemente gleichzeitig anhängen 
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
 * leiste
 */

public class leiste<T> extends listutils<T> {

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
        int index = 0;
        while (runner != null) {

            System.out.printf("%d: %s; ", index, runner.getData());
            runner = runner.getNext();
            index++;

        }
        System.out.print("\n");

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
