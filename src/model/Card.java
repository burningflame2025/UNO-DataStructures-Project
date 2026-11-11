package model;

public class Card {

    private Color color;
    private CardType type;
    private int number;

    public Card(Color color, CardType type, int number) {
        this.color = color;
        this.type = type;
        this.number = number;
    }

    public Color getColor() {
        return color;
    }

    public CardType getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        if (type == CardType.NUMBER) {
            return color + " " + number;
        }

        return color + " " + type;
    }
}