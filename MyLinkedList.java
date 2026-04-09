import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {

    private class MyNode {
        T element;
        MyNode next;
        MyNode prev;
        MyNode(T element) { this.element = element; }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private MyNode nodeAt(int index) {
        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    @Override
    public void add(T item) {
        MyNode node = new MyNode(item);
        if (tail == null) { head = tail = node; }
        else { node.prev = tail; tail.next = node; tail = node; }
        size++;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        nodeAt(index).element = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        if (index == 0) { addFirst(item); return; }
        if (index == size) { addLast(item); return; }
        MyNode successor = nodeAt(index);
        MyNode predecessor = successor.prev;
        MyNode node = new MyNode(item);
        node.next = successor; node.prev = predecessor;
        predecessor.next = node; successor.prev = node;
        size++;
    }

    @Override
    public void addFirst(T item) {
        MyNode node = new MyNode(item);
        if (head == null) { head = tail = node; }
        else { node.next = head; head.prev = node; head = node; }
        size++;
    }

    @Override
    public void addLast(T item) { add(item); }

    @Override
    public T get(int index) {
        checkIndex(index);
        return nodeAt(index).element;
    }

    @Override
    public T getFirst() {
        if (head == null) throw new RuntimeException("List is empty");
        return head.element;
    }

    @Override
    public T getLast() {
        if (tail == null) throw new RuntimeException("List is empty");
        return tail.element;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        MyNode node = nodeAt(index);
        if (node.prev != null) node.prev.next = node.next; else head = node.next;
        if (node.next != null) node.next.prev = node.prev; else tail = node.prev;
        node.next = null; node.prev = null;
        size--;
    }

    @Override
    public void removeFirst() { remove(0); }

    @Override
    public void removeLast() { remove(size - 1); }

    @Override
    @SuppressWarnings("unchecked")
    public void sort() {
        if (size <= 1) return;
        boolean swapped;
        do {
            swapped = false;
            MyNode current = head;
            while (current.next != null) {
                Comparable<T> a = (Comparable<T>) current.element;
                if (a.compareTo(current.next.element) > 0) {
                    T tmp = current.element;
                    current.element = current.next.element;
                    current.next.element = tmp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    @Override
    public int indexOf(Object object) {
        MyNode current = head; int index = 0;
        while (current != null) {
            if (current.element.equals(object)) return index;
            current = current.next; index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail; int index = size - 1;
        while (current != null) {
            if (current.element.equals(object)) return index;
            current = current.prev; index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) { return indexOf(object) != -1; }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        MyNode current = head;
        for (int i = 0; i < size; i++) { arr[i] = current.element; current = current.next; }
        return arr;
    }

    @Override
    public void clear() {
        MyNode current = head;
        while (current != null) {
            MyNode next = current.next;
            current.prev = null; current.next = null;
            current = next;
        }
        head = tail = null; size = 0;
    }

    @Override
    public int size() { return size; }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;
            @Override public boolean hasNext() { return current != null; }
            @Override public T next() { T val = current.element; current = current.next; return val; }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        MyNode current = head;
        while (current != null) {
            sb.append(current.element);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        return sb.append("]").toString();
    }
}
