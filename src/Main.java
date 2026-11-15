import controller.Game;
import model.BotPlayer;
import model.Card;
import model.CardType;
import model.Color;
import model.HumanPlayer;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();

        HumanPlayer zahra = new HumanPlayer("Zahra");
        BotPlayer bot1 = new BotPlayer("Bot 1");
        BotPlayer bot2 = new BotPlayer("Bot 2");

        game.addPlayer(zahra);
        game.addPlayer(bot1);
        game.addPlayer(bot2);

        game.setupGame();
        game.dealCards(7);
        game.startRound();

        System.out.println("===== WINNER TEST =====");
        System.out.println("Top card: " + game.getTopCard());
        System.out.println("Zahra cards before: " + zahra.getHandSize());
        int playableIndex = -1;

        for (int i = 0; i < zahra.getHandSize(); i++) {
            Card card = zahra.getHand().get(i);

            if (game.isCardPlayable(card)) {
                playableIndex = i;
                break;
            }
        }

        if (playableIndex != -1) {
            System.out.println("Playing: "
                    + zahra.getHand().get(playableIndex));

        } else {
            System.out.println("No playable card found.");
        }
    }
}