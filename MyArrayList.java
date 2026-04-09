import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {

    private Object[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    private void grow() {
        Object[] newData = new Object[data.length * 2];
        for (int i = 0; i < size; i++) newData[i] = data[i];
        data = newData;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    @Override
    public void add(T item) {
        if (size == data.length) grow();
        data[size++] = item;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        data[index] = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        if (size == data.length) grow();
        for (int i = size; i > index; i--) data[i] = data[i - 1];
        data[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) { add(0, item); }

    @Override
    public void addLast(T item) { add(item); }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    @Override
    public T getFirst() { return get(0); }

    @Override
    public T getLast() { return get(size - 1); }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) data[i] = data[i + 1];
        data[--size] = null;
    }

    @Override
    public void removeFirst() { remove(0); }

    @Override
    public void removeLast() { remove(size - 1); }

    @Override
    @SuppressWarnings("unchecked")
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                Comparable<T> a = (Comparable<T>) data[j];
                if (a.compareTo((T) data[j + 1]) > 0) {
                    Object tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++)
            if (data[i].equals(object)) return i;
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--)
            if (data[i].equals(object)) return i;
        return -1;
    }

    @Override
    public boolean exists(Object object) { return indexOf(object) != -1; }

    @Override
    public Object[] toArray() {
        Object[] copy = new Object[size];
        for (int i = 0; i < size; i++) copy[i] = data[i];
        return copy;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) data[i] = null;
        size = 0;
    }

    @Override
    public int size() { return size; }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;
            @Override public boolean hasNext() { return cursor < size; }
            @Override @SuppressWarnings("unchecked") public T next() { return (T) data[cursor++]; }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        return sb.append("]").toString();
    }
}
