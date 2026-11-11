import model.Card;
import model.CardType;
import model.Color;

public class Main {

    public static void main(String[] args) {

        Card card1 = new Card(Color.RED, CardType.NUMBER, 5);
        Card card2 = new Card(Color.BLUE, CardType.SKIP, -1);
        Card card3 = new Card(Color.WILD, CardType.WILD, -1);

        System.out.println(card1);
        System.out.println(card2);
        System.out.println(card3);
    }
}