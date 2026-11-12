package controller;

import model.Card;
import model.CardType;
import model.Player;
import structures.SinglyLinkedList;

public class Game {

    private Deck deck;
    private SinglyLinkedList<Player> players;
    private Round round;
    private TurnManager turnManager;
    private RuleManager ruleManager;

    public Game() {
        deck = new Deck();
        players = new SinglyLinkedList<>();
        turnManager = new TurnManager();
        ruleManager = new RuleManager();
    }

    public void addPlayer(Player player) {
        players.addLast(player);
        turnManager.addPlayer(player);
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

    public Player getCurrentPlayer() {
        return turnManager.getCurrentPlayer();
    }

    public boolean playCard(int cardIndex) {

        Player currentPlayer = turnManager.getCurrentPlayer();

        if (cardIndex < 0 || cardIndex >= currentPlayer.getHandSize()) {
            return false;
        }

        Card selectedCard = currentPlayer.getHand().get(cardIndex);

        if (!ruleManager.isValidMove(selectedCard, round.getTopCard())) {
            return false;
        }

        currentPlayer.removeCard(cardIndex);
        round.playCard(selectedCard);

        applyCardEffect(selectedCard);

        turnManager.nextTurn();

        return true;
    }

    public Card drawCardForCurrentPlayer() {

        Player currentPlayer = turnManager.getCurrentPlayer();

        Card drawnCard = deck.drawCard();

        currentPlayer.addCard(drawnCard);

        return drawnCard;
    }
    public boolean isCardPlayable(Card card) {
        return ruleManager.isValidMove(card, round.getTopCard());
    }

    public void endTurn() {
        turnManager.nextTurn();
    }

    private void applyCardEffect(Card card) {

        if (card.getType() == CardType.SKIP) {
            turnManager.nextTurn();

        } else if (card.getType() == CardType.REVERSE) {
            turnManager.reverseDirection();

        } else if (card.getType() == CardType.DRAW_TWO) {
            turnManager.nextTurn();
            drawCardsForCurrentPlayer(2);
        }
    }

    private void drawCardsForCurrentPlayer(int count) {

        Player currentPlayer = turnManager.getCurrentPlayer();

        for (int i = 0; i < count; i++) {
            currentPlayer.addCard(deck.drawCard());
        }
    }
}