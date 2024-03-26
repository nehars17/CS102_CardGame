package model.cards;

public class Card implements Comparable<Card> {
    private final char suit;
    private final char rank;
    private final int value;

    public Card(char rank, char suit) {
        this.suit = suit;
        this.rank = rank;
        this.value = calculateValue(rank, suit);
    }

    @Override
    public String toString() {
        return "" + rank + suit;
    }

    @Override
    public int compareTo(Card card) {
        return Integer.compare(value, card.calculateValue(card.getRank(), card.getSuit()));
    }

    public String getImagePath() {
        return "images/cardassets/" + rank + suit + ".gif";

    }

    private int calculateValue(char rank, char suit) {
        int rankValue;
        switch (rank) {
            case '3':
                rankValue = 3;
                break;
            case '4':
                rankValue = 4;
                break;
            case '5':
                rankValue = 5;
                break;
            case '6':
                rankValue = 6;
                break;
            case '7':
                rankValue = 7;
                break;
            case '8':
                rankValue = 8;
                break;
            case '9':
                rankValue = 9;
                break;
            case 't':
                rankValue = 10;
                break;
            case 'j':
                rankValue = 11;
                break;
            case 'q':
                rankValue = 12;
                break;
            case 'k':
                rankValue = 13;
                break;
            case 'a':
                rankValue = 14;
                break;
            case '2':
                rankValue = 15;
                break;
            default:
                throw new IllegalArgumentException("Invalid card rank");
        }
        int suitValue;
        switch (suit) {
            case 'd':
                suitValue = 1;
                break;
            case 'c':
                suitValue = 2;
                break;
            case 'h':
                suitValue = 3;
                break;
            case 's':
                suitValue = 4;
                break;
            default:
                throw new IllegalArgumentException("Invalid card suit");
        }
        return rankValue * 10 + suitValue;
    }

    public int getValue() {
        return value;
    }

    public char getRank() {
        return rank;
    }

    public char getSuit() {
        return suit;
    }

    public int compareRank(Card anotherCard) {
        String order = "3456789tjqka2";
        return order.indexOf(getRank()) - order.indexOf(anotherCard.getRank());
    }

    public int compareSuit(Card anotherCard) {
        String order = "dhcs";
        return order.indexOf(getSuit()) - order.indexOf(anotherCard.getSuit());
    }

}