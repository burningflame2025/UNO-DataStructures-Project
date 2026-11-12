package controller;

import model.Card;
import model.CardType;
import model.Color;

public class RuleManager {
    public boolean isValidMove(Card playedCard, Card topCard, Color activeColor) {

        if (playedCard.getType() == CardType.WILD || playedCard.getType() == CardType.WILD_DRAW_FOUR) {
            return true;
        }

        if (playedCard.getColor() == activeColor) {
            return true;
        }

        if (playedCard.getType() == CardType.NUMBER && topCard.getType() == CardType.NUMBER && playedCard.getNumber() == topCard.getNumber()) {
            return true;
        }

        if (playedCard.getType() != CardType.NUMBER && playedCard.getType() == topCard.getType()) {
            return true;
        }

        return false;
    }
}