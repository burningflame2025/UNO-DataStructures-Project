package controller;

import model.Card;
import structures.CustomStack;
import model.Color;

public class Round {

    private Deck deck;
    private CustomStack<Card> discardPile;
    private Color activeColor;

    public Round(Deck deck) {
        this.deck = deck;
        this.discardPile = new CustomStack<>();
    }

    public void startRound() {
        Card firstCard = deck.drawCard();
        discardPile.push(firstCard);
        activeColor = firstCard.getColor();
    }

    public Card getTopCard() {
        return discardPile.peek();
    }

    public void playCard(Card card) {
        discardPile.push(card);

        if (card.getColor() != null) {
            activeColor = card.getColor();
        }
    }

    public Color getActiveColor() {
        return activeColor;
    }

    public void setActiveColor(Color color) {
        activeColor = color;
    }
}