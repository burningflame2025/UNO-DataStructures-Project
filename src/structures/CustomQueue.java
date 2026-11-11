package structures;

public class CustomQueue<T> {

    private SinglyLinkedList<T> list;

    public CustomQueue() {
        list = new SinglyLinkedList<>();
    }

    public void enqueue(T data) {
        list.addLast(data);
    }

    public T dequeue() {
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}