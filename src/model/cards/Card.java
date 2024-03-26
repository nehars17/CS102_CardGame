package model.cards;

/**
 * Represents a card used in the Big Two card game.
 * Each card has a suit and a rank, and a value is assigned to the card
 * that is used for comparing cards according to the game's rules.
 */

public class Card implements Comparable<Card> {
    private final char suit;
    private final char rank;
    private final int value;

    /**
     * Constructs a Card with the specified rank and suit. It also calculates the
     * card's
     * value for game logic.
     *
     * @param rank The rank of the card ('3'-'9', 't' for 10, 'j', 'q', 'k', 'a', or
     *             '2').
     * @param suit The suit of the card ('d' for diamonds, 'c' for clubs, 'h' for
     *             hearts, 's' for spades).
     */
    public Card(char rank, char suit) {
        validateCard(rank, suit); 
        this.suit = suit;
        this.rank = rank;
        this.value = calculateValue(rank, suit);
    }

    /**
     * Returns the value of the card. The value is derived from the card's rank and
     * suit.
     * 
     * @return The value of the card.
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns the rank of the card.
     * 
     * @return The rank character of the card.
     */
    public char getRank() {
        return rank;
    }

    /**
     * Returns the suit of the card.
     * 
     * @return The suit character of the card.
     */
    public char getSuit() {
        return suit;
    }

    /**
     * Provides a string representation of the card, which consists of its rank
     * followed by its suit.
     * 
     * @return A string representation of the card.
     */
    @Override
    public String toString() {
        return "" + rank + suit;
    }

    /**
     * Compares this card with another card for order based on their values.
     * 
     * @param card The card to be compared.
     * @return A negative integer, zero, or a positive integer as this card is less
     *         than,
     *         equal to, or greater than the specified card.
     */
    @Override
    public int compareTo(Card card) {
        return Integer.compare(value, card.calculateValue(card.getRank(), card.getSuit()));
    }

    /**
     * Returns the image path of the card based on its rank and suit.
     * 
     * @return The image path of the card.
     */
    public String getImagePath() {
        return "images/cardassets/" + rank + suit + ".gif";

    }

    /**
     * Validates the rank and suit of a card.
     * 
     * @param rank The rank character to validate.
     * @param suit The suit character to validate.
     * @throws IllegalArgumentException if the rank or suit are invalid.
     */
    private void validateCard(char rank, char suit) {
        String validRanks = "3456789tjqka2";
        String validSuits = "dhcs";
        if (validRanks.indexOf(rank) == -1 || validSuits.indexOf(suit) == -1) {
            throw new IllegalArgumentException("Invalid card rank or suit");
        }
    }

    /**
     * Calculates the value of the card based on its rank and suit.
     * The value is determined by the game rules, where the rank is the primary
     * determinant and the suit is the secondary determinant.
     *
     * @param rank The rank character of the card.
     * @param suit The suit character of the card.
     * @return The calculated value for the card.
     */
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

    /**
     * Compares the rank of this card with another card.
     * 
     * @param anotherCard The card to compare with.
     * @return The difference in ranks between this card and the specified card.
     */
    public int compareRank(Card anotherCard) {
        String order = "3456789tjqka2";
        return order.indexOf(getRank()) - order.indexOf(anotherCard.getRank());
    }

    /**
     * Compares the suit of this card with another card.
     * 
     * @param anotherCard The card to compare with.
     * @return The difference in suits between this card and the specified card.
     */
    public int compareSuit(Card anotherCard) {
        String order = "dhcs";
        return order.indexOf(getSuit()) - order.indexOf(anotherCard.getSuit());
    }

}
