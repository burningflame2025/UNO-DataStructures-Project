package model;

import structures.SinglyLinkedList;

public abstract class Player {

    protected String name;
    protected SinglyLinkedList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new SinglyLinkedList<>();
    }

    public String getName() {
        return name;
    }

    public SinglyLinkedList<Card> getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.addLast(card);
    }

    public int getHandSize() {
        return hand.size();
    }
}