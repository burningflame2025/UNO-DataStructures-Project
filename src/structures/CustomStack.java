package structures;

public class CustomStack<T> {

    private SinglyLinkedList<T> list;

    public CustomStack() {
        list = new SinglyLinkedList<>();
    }

    public void push(T data) {
        list.addFirst(data);
    }

    public T pop() {
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return list.get(0);
    }
}