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

        int wildDrawFourIndex = -1;

        for (int i = 0; i < currentPlayer.getHandSize(); i++) {

            Card card = currentPlayer.getHand().get(i);

            if (card.getType() == CardType.WILD_DRAW_FOUR) {
                wildDrawFourIndex = i;
                break;
            }
        }
        int botCardsBefore = player2.getHandSize();

        if (wildDrawFourIndex != -1) {

            System.out.println("Playing: "
                    + currentPlayer.getHand().get(wildDrawFourIndex));

            boolean result = game.playCard(wildDrawFourIndex);

            System.out.println("Move successful: " + result);
            System.out.println("New top card: " + game.getTopCard());

            System.out.println("Bot 1 cards before: " + botCardsBefore);
            System.out.println("Bot 1 cards after: " + player2.getHandSize());

            game.chooseWildColor(Color.RED);

            System.out.println("Selected color: RED");
            System.out.println("Active color: " + game.getActiveColor());

            System.out.println("Current player: "
                    + game.getCurrentPlayer().getName());

        } else {
            System.out.println("No WILD_DRAW_FOUR card found.");
        }
    }
}