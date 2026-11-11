package controller;

import model.Player;
import structures.DoublyCircularLinkedList;

public class TurnManager {

    private DoublyCircularLinkedList<Player> players;
    private boolean clockwise;

    public TurnManager() {
        players = new DoublyCircularLinkedList<>();
        clockwise = true;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player getCurrentPlayer() {
        return players.getCurrent();
    }

    public Player nextTurn() {
        if (clockwise) {
            return players.moveNext();
        } else {
            return players.movePrevious();
        }
    }

    public void reverseDirection() {
        clockwise = !clockwise;
    }

    public boolean isClockwise() {
        return clockwise;
    }
}