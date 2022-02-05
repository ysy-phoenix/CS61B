public class LinkedListDeque<T> {
    private Node sentinel;
    private int size;

    public class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node(T item, Node prev, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }

        public Node(Node prev, Node next) {
            this.prev = prev;
            this.next = next;
        }
    }

    public LinkedListDeque() {
        sentinel = new Node(null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        Node first = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = first;
        sentinel.next = first;
        size++;
    }

    public void addLast(T item) {
        Node last = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node ptr = sentinel.next;
        while (ptr != sentinel) {
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
    }

    public T removeFirst() {
        if (size == 0) return null;
        T ret = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return ret;
    }

    public T removeLast() {
        if (size == 0) return null;
        T ret = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return ret;
    }

    public T get(int index) {
        if (index >= size) return null;
        Node ptr = sentinel.next;
        for (int i = 0; i < index; i++)
            ptr = ptr.next;
        return ptr.item;
    }

    private T getRecursiveHelp(Node node, int index) {
        if (index == 0) return node.item;
        else return getRecursiveHelp(node.next, index - 1);
    }

    public T getRecursive(int index) {
        if (index >= size) return null;
        return getRecursiveHelp(sentinel.next, index - 1);
    }

}
