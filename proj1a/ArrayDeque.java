public class ArrayDeque<T> {
    private T[] array;
    private int size;
    private int length;
    private int front;
    private int rear;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
        length = 8;
        front = 4;
        rear = 4;
    }

    private void grow() {
        int newLength = length * 2;
        T[] newArray = (T[]) new Object[newLength];
        int ptr1 = front;
        int ptr2 = length;
        while (ptr1 != rear) {
            newArray[ptr2] = array[ptr1];
            ptr1 = (ptr1 + 1) % length;
            ptr2 = (ptr2 + 1) % newLength;
        }
        front = length;
        rear = ptr2;
        array = newArray;
        length = newLength;
    }

    private void shrink() {
        int newLength = length / 2;
        T[] newArray = (T[]) new Object[newLength];
        int ptr1 = front;
        int ptr2 = newLength / 2;
        while (ptr1 != rear) {
            newArray[ptr2] = array[ptr1];
            ptr1 = (ptr1 + 1) % length;
            ptr2 = (ptr2 + 1) % newLength;
        }
        front = newLength / 2;
        rear = ptr2;
        array = newArray;
        length = newLength;
    }

    public void addFirst(T item) {
        if (size == length - 1) {
            grow();
        }
        front = (front - 1) % length;
        array[front] = item;
        size++;
    }

    public void addLast(T item) {
        if (size == length - 1) {
            grow();
        }
        array[rear] = item;
        rear = (rear + 1) % length;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int index = front;
        while (index != rear) {
            System.out.print(array[index] + " ");
            index = (index + 1) % length;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (length >= 16 && length / size >= 4) {
            shrink();
        }
        T ret = array[front];
        front = (front + 1) % length;
        size--;
        return ret;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (length >= 16 && length / size >= 4) {
            shrink();
        }
        rear = (rear - 1 + length) % length;
        size--;
        return array[rear];
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return array[(front + index) % length];
    }
}
