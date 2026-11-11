import controller.Game;
import model.BotPlayer;
import model.HumanPlayer;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();

        HumanPlayer player1 = new HumanPlayer("Zahra");
        BotPlayer player2 = new BotPlayer("Bot 1");
        BotPlayer player3 = new BotPlayer("Bot 2");

        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);

        game.setupGame();
        game.dealCards(7);
        game.startRound();

        System.out.println("Round started!");
        System.out.println("First card on table: " + game.getTopCard());
    }
}