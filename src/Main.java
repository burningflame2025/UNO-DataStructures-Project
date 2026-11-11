import controller.Game;
import model.BotPlayer;
import model.HumanPlayer;
import model.Player;

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

        System.out.println("Top card: " + game.getTopCard());

        Player currentPlayer = game.getCurrentPlayer();

        System.out.println("Current player: " + currentPlayer.getName());
        System.out.println("Cards:");

        for (int i = 0; i < currentPlayer.getHandSize(); i++) {
            System.out.println(i + ": " + currentPlayer.getHand().get(i));
        }
        boolean result = game.playCard(0);

        System.out.println("Move successful: " + result);
        System.out.println("New top card: " + game.getTopCard());
        System.out.println("Next player: "
                + game.getCurrentPlayer().getName());
    }
}