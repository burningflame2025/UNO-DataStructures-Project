import model.BotPlayer;
import model.HumanPlayer;
import model.Player;
import structures.DoublyCircularLinkedList;

public class Main {

    public static void main(String[] args) {

        DoublyCircularLinkedList<Player> players =
                new DoublyCircularLinkedList<>();

        players.add(new HumanPlayer("Zahra"));
        players.add(new BotPlayer("Bot 1"));
        players.add(new BotPlayer("Bot 2"));

        System.out.println("Current: " + players.getCurrent().getName());

        System.out.println("Next: " + players.moveNext().getName());
        System.out.println("Next: " + players.moveNext().getName());
        System.out.println("Next: " + players.moveNext().getName());

        System.out.println("Previous: "
                + players.movePrevious().getName());
    }
}