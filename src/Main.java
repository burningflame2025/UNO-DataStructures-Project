import controller.Game;
import model.BotPlayer;
import model.Card;
import model.CardType;
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

        System.out.println("===== GAME START =====");
        System.out.println("Top card: " + game.getTopCard());

        Player currentPlayer = game.getCurrentPlayer();

        System.out.println("Current player: "
                + currentPlayer.getName());

        System.out.println("\nCards:");

        for (int i = 0; i < currentPlayer.getHandSize(); i++) {
            System.out.println(i + ": "
                    + currentPlayer.getHand().get(i));
        }

        int drawTwoIndex = -1;

        for (int i = 0; i < currentPlayer.getHandSize(); i++) {

            Card card = currentPlayer.getHand().get(i);

            if (card.getType() == CardType.DRAW_TWO
                    && game.isCardPlayable(card)) {

                drawTwoIndex = i;
                break;
            }
        }
        int botCardsBefore = player2.getHandSize();

        if (drawTwoIndex != -1) {

            System.out.println("Playing: "
                    + currentPlayer.getHand().get(drawTwoIndex));

            boolean result = game.playCard(drawTwoIndex);


            System.out.println("Move successful: " + result);
            System.out.println("Bot 1 cards before: " + botCardsBefore);
            System.out.println("Bot 1 cards after: " + player2.getHandSize());
            System.out.println("Current player: "
                    + game.getCurrentPlayer().getName());

        } else {
            System.out.println("No playable DRAW_TWO card found.");
        }
    }
}