public class Main {

    public static void main(String[] args) {
        testArrayList();
        testLinkedList();
        testStack();
        testQueue();
        testMinHeap();
    }

    static void testArrayList() {
        System.out.println("===== MyArrayList =====");
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(3); list.add(5); list.addFirst(1); list.addLast(7); list.add(2, 4);
        System.out.println("After adds: " + list);
        System.out.println("get(2): " + list.get(2));
        System.out.println("getFirst: " + list.getFirst());
        System.out.println("getLast: " + list.getLast());
        list.set(2, 99);
        System.out.println("After set(2,99): " + list);
        list.set(2, 4);
        list.add(3);
        System.out.println("indexOf(3): " + list.indexOf(3));
        System.out.println("lastIndexOf(3): " + list.lastIndexOf(3));
        System.out.println("exists(7): " + list.exists(7));
        list.removeLast();
        list.remove(2);
        System.out.println("After remove(2): " + list);
        list.removeFirst();
        System.out.println("After removeFirst: " + list);
        list.removeLast();
        System.out.println("After removeLast: " + list);
        list.add(1); list.add(9); list.add(2);
        list.sort();
        System.out.println("After sort: " + list);
        Object[] arr = list.toArray();
        System.out.print("toArray: ");
        for (Object o : arr) System.out.print(o + " ");
        System.out.println();
        System.out.print("Iterator: ");
        for (int x : list) System.out.print(x + " ");
        System.out.println();
        System.out.println("size: " + list.size());
        list.clear();
        System.out.println("After clear, size: " + list.size());
        System.out.println();
    }

    static void testLinkedList() {
        System.out.println("===== MyLinkedList =====");
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("B"); list.addFirst("A"); list.addLast("C"); list.add(2, "BB");
        System.out.println("After adds: " + list);
        System.out.println("get(1): " + list.get(1));
        System.out.println("getFirst: " + list.getFirst());
        System.out.println("getLast: " + list.getLast());
        list.set(2, "X");
        System.out.println("After set(2,X): " + list);
        list.remove(2);
        System.out.println("After remove(2): " + list);
        list.removeFirst();
        System.out.println("After removeFirst: " + list);
        list.removeLast();
        System.out.println("After removeLast: " + list);
        list.add("Z"); list.add("A"); list.add("M");
        list.sort();
        System.out.println("After sort: " + list);
        System.out.println("indexOf(A): " + list.indexOf("A"));
        System.out.println("exists(Z): " + list.exists("Z"));
        System.out.print("Iterator: ");
        for (String s : list) System.out.print(s + " ");
        System.out.println();
        list.clear();
        System.out.println("After clear, size: " + list.size());
        System.out.println();
    }

    static void testStack() {
        System.out.println("===== MyStack =====");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10); stack.push(20); stack.push(30);
        System.out.println(stack);
        System.out.println("peek: " + stack.peek());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("size: " + stack.size());
        System.out.println("isEmpty: " + stack.isEmpty());
        stack.pop();
        System.out.println("isEmpty after all pops: " + stack.isEmpty());
        System.out.println();
    }

    static void testQueue() {
        System.out.println("===== MyQueue =====");
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("first"); queue.enqueue("second"); queue.enqueue("third");
        System.out.println(queue);
        System.out.println("peek: " + queue.peek());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("size: " + queue.size());
        queue.dequeue();
        System.out.println("isEmpty: " + queue.isEmpty());
        System.out.println();
    }

    static void testMinHeap() {
        System.out.println("===== MyMinHeap =====");
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(40); heap.insert(10); heap.insert(30); heap.insert(5); heap.insert(20);
        System.out.println(heap);
        System.out.println("getMin: " + heap.getMin());
        System.out.print("Sorted extractions: ");
        while (!heap.isEmpty()) System.out.print(heap.extractMin() + " ");
        System.out.println();
        System.out.println("isEmpty: " + heap.isEmpty());
    }
}
