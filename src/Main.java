import controller.Game;
import model.BotPlayer;
import model.Card;
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
        System.out.println("Cards before drawing: "
                + currentPlayer.getHandSize());

        Card drawnCard = game.drawCardForCurrentPlayer();

        System.out.println("Drawn card: " + drawnCard);
        System.out.println("Cards after drawing: "
                + currentPlayer.getHandSize());

        boolean playable = game.isCardPlayable(drawnCard);

        System.out.println("Is drawn card playable: " + playable);

        if (playable) {
            int drawnCardIndex = currentPlayer.getHandSize() - 1;

            boolean result = game.playCard(drawnCardIndex);

            System.out.println("Drawn card played: " + result);
            System.out.println("New top card: " + game.getTopCard());
            System.out.println("Next player: "
                    + game.getCurrentPlayer().getName());

        } else {
            System.out.println("Drawn card cannot be played.");

            game.endTurn();

            System.out.println("Next player: "
                    + game.getCurrentPlayer().getName());
        }
    }
}