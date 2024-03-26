package utils.combinations;

import model.cards.Card;

import java.util.ArrayList;
import java.util.Map;

/**
 * Represents a Full House combination in the Big Two card game.
 * A Full House is defined as three cards of one rank and two cards of another.
 */

public class FullHouse extends Combinations {

    /**
     * Checks if a given list of cards constitutes a valid Full House.
     *
     * @param cardList The list of cards to be evaluated.
     * @return true if the combination is a valid Full House; false otherwise.
     */

    @Override
    public boolean isValid(ArrayList<Card> cardList) {
        if (cardList == null || cardList.size() != 5) {
            return false;
        }

        Map<Character, Integer> rankCount = super.getRankCount(cardList);
        boolean hasThreeOfAKind = false;
        boolean hasPair = false;

        for (int count : rankCount.values()) {
            if (count == 3) {
                hasThreeOfAKind = true;
            }
            if (count == 2) {
                hasPair = true;
            }
        }
        return hasThreeOfAKind && hasPair;
    }
}
