package controller;

import model.Card;
import model.CardType;
import model.Color;
import structures.SinglyLinkedList;

import java.util.Random;

public class Deck {

    private SinglyLinkedList<Card> cards;
    private Random random;

    public Deck() {
        cards = new SinglyLinkedList<>();
        random = new Random();
    }

    public void addCard(Card card) {
        cards.addLast(card);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }

        return cards.removeFirst();
    }

    public int size() {
        return cards.size();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public void createStandardDeck() {
        Color[] colors = {
                Color.RED,
                Color.BLUE,
                Color.GREEN,
                Color.YELLOW
        };

        for (Color color : colors) {
            addCard(new Card(color, CardType.NUMBER, 0));

            for (int number = 1; number <= 9; number++) {
                addCard(new Card(color, CardType.NUMBER, number));
                addCard(new Card(color, CardType.NUMBER, number));
            }

            for (int i = 0; i < 2; i++) {
                addCard(new Card(color, CardType.SKIP, -1));
                addCard(new Card(color, CardType.REVERSE, -1));
                addCard(new Card(color, CardType.DRAW_TWO, -1));
            }
        }

        for (int i = 0; i < 4; i++) {
            addCard(new Card(Color.WILD, CardType.WILD, -1));
            addCard(new Card(Color.WILD, CardType.WILD_DRAW_FOUR, -1));
        }
    }
    public void shuffle() {

        SinglyLinkedList<Card> shuffledCards = new SinglyLinkedList<>();

        while (!cards.isEmpty()) {

            int randomIndex = random.nextInt(cards.size());

            Card randomCard = cards.remove(randomIndex);

            shuffledCards.addLast(randomCard);
        }

        cards = shuffledCards;
    }
}
