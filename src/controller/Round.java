package controller;

import model.Card;
import structures.CustomStack;

public class Round {

    private Deck deck;
    private CustomStack<Card> discardPile;

    public Round(Deck deck) {
        this.deck = deck;
        this.discardPile = new CustomStack<>();
    }

    public void startRound() {
        Card firstCard = deck.drawCard();
        discardPile.push(firstCard);
    }

    public Card getTopCard() {
        return discardPile.peek();
    }

    public void playCard(Card card) {
        discardPile.push(card);
    }
}