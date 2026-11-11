import controller.RuleManager;
import model.Card;
import model.CardType;
import model.Color;

public class Main {

    public static void main(String[] args) {

        RuleManager ruleManager = new RuleManager();

        Card topCard = new Card(Color.RED, CardType.NUMBER, 5);

        Card sameColor = new Card(Color.RED, CardType.NUMBER, 2);
        Card sameNumber = new Card(Color.BLUE, CardType.NUMBER, 5);
        Card wildCard = new Card(Color.WILD, CardType.WILD, -1);
        Card invalidCard = new Card(Color.GREEN, CardType.NUMBER, 8);

        System.out.println("Same color: "
                + ruleManager.isValidMove(sameColor, topCard));

        System.out.println("Same number: "
                + ruleManager.isValidMove(sameNumber, topCard));

        System.out.println("Wild card: "
                + ruleManager.isValidMove(wildCard, topCard));

        System.out.println("Invalid card: "
                + ruleManager.isValidMove(invalidCard, topCard));
    }
}