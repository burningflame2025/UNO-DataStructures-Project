import controller.Game;
import model.BotPlayer;
import model.Card;
import model.CardType;
import model.Color;
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

        Player currentPlayer = game.getCurrentPlayer();

        System.out.println("===== WILD TEST =====");
        System.out.println("Top card: " + game.getTopCard());
        System.out.println("Active color before: "
                + game.getActiveColor());

        System.out.println("\nCards:");

        for (int i = 0; i < currentPlayer.getHandSize(); i++) {
            System.out.println(i + ": "
                    + currentPlayer.getHand().get(i));
        }

        int wildIndex = -1;

        for (int i = 0; i < currentPlayer.getHandSize(); i++) {

            Card card = currentPlayer.getHand().get(i);

            if (card.getType() == CardType.WILD) {
                wildIndex = i;
                break;
            }
        }

        if (wildIndex != -1) {

            System.out.println("\nPlaying: "
                    + currentPlayer.getHand().get(wildIndex));

            boolean result = game.playCard(wildIndex);

            System.out.println("Move successful: " + result);
            System.out.println("New top card: "
                    + game.getTopCard());

            game.chooseWildColor(Color.RED);

            System.out.println("Selected color: RED");
            System.out.println("Active color after: "
                    + game.getActiveColor());

            System.out.println("Next player: "
                    + game.getCurrentPlayer().getName());

        } else {
            System.out.println("No WILD card found for testing.");
        }
    }
}