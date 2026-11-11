import structures.SinglyLinkedList;

public class Main {

    public static void main(String[] args) {

        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.addFirst("Blue");
        list.addFirst("Red");
        list.addLast("Green");

        System.out.println("Size: " + list.size());
        System.out.println("First item: " + list.get(0));
        System.out.println("Second item: " + list.get(1));
        System.out.println("Removed: " + list.removeFirst());
        System.out.println("New first item: " + list.get(0));
    }
}