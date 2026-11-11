package controller;

import model.Card;
import model.Player;
import structures.SinglyLinkedList;

public class Game {

    private Deck deck;
    private SinglyLinkedList<Player> players;
    private Round round;

    public Game() {
        deck = new Deck();
        players = new SinglyLinkedList<>();
    }

    public void addPlayer(Player player) {
        players.addLast(player);
    }

    public void setupGame() {
        deck.createStandardDeck();
        deck.shuffle();

        round = new Round(deck);
    }

    public void dealCards(int numberOfCards) {

        for (int i = 0; i < players.size(); i++) {

            Player player = players.get(i);

            for (int j = 0; j < numberOfCards; j++) {
                player.addCard(deck.drawCard());
            }
        }
    }

    public void startRound() {
        round.startRound();
    }
    public Card getTopCard() {
        return round.getTopCard();
    }
}