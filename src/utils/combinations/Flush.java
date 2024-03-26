package utils.combinations;

import model.cards.Card;

import java.util.ArrayList;

/**
 * Represents a Flush combination in the Big Two card game. 
 * A Flush is defined as five cards of the same suit, not in sequence.
 */
public class Flush extends Combinations {

    /**
     * Checks if a given list of cards constitutes a valid Flush.
     *
     * @param cardList The list of cards to be evaluated.
     * @return true if the combination is a valid Flush; false otherwise.
     */

    @Override
    public boolean isValid(ArrayList<Card> cardList) {
        if (cardList == null || cardList.size() != 5) {
            return false;
        }

        char suit = cardList.get(0).getSuit();
        for (Card card : cardList) {
            if (card.getSuit() != suit) {
                return false;
            }
        }

        return true;
    }
}
