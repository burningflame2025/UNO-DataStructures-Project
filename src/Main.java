import controller.TurnManager;
import model.BotPlayer;
import model.HumanPlayer;

public class Main {

    public static void main(String[] args) {

        TurnManager turnManager = new TurnManager();

        turnManager.addPlayer(new HumanPlayer("Zahra"));
        turnManager.addPlayer(new BotPlayer("Bot 1"));
        turnManager.addPlayer(new BotPlayer("Bot 2"));

        System.out.println("Current player: "
                + turnManager.getCurrentPlayer().getName());

        System.out.println("Next player: "
                + turnManager.nextTurn().getName());

        System.out.println("Next player: "
                + turnManager.nextTurn().getName());

        turnManager.reverseDirection();

        System.out.println("Direction reversed!");

        System.out.println("Next player: "
                + turnManager.nextTurn().getName());
    }
}