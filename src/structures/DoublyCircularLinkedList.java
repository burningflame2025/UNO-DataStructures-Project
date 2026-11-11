package structures;

public class DoublyCircularLinkedList<T> {

    private Node<T> head;
    private Node<T> current;
    private int size;

    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> previous;

        public Node(T data) {
            this.data = data;
        }
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.previous = head;
            current = head;
        } else {
            Node<T> tail = head.previous;

            newNode.next = head;
            newNode.previous = tail;

            tail.next = newNode;
            head.previous = newNode;
        }

        size++;
    }

    public T getCurrent() {
        if (current == null) {
            throw new IllegalStateException("List is empty");
        }

        return current.data;
    }

    public T moveNext() {
        if (current == null) {
            throw new IllegalStateException("List is empty");
        }

        current = current.next;
        return current.data;
    }

    public T movePrevious() {
        if (current == null) {
            throw new IllegalStateException("List is empty");
        }

        current = current.previous;
        return current.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}