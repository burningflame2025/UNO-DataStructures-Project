package controller;

import model.Card;
import structures.CustomQueue;

public class Deck {

    private CustomQueue<Card> cards;

    public Deck() {
        cards = new CustomQueue<>();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int size() {
        return cards.size();
    }

    public void addCard(Card card) {
        cards.enqueue(card);
    }

    public Card drawCard() {
        return cards.dequeue();
    }
}