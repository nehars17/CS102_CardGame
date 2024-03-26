package utils.combinations;

import model.cards.Card;

import java.util.ArrayList;
import java.util.Map;

/**
 * Represents a Pair combination in the Big Two card game.
 * A Pair is defined as two cards of the same rank.
 */

public class Pair extends Combinations {

    /**
     * Checks if a given list of cards constitutes a valid Pair.
     *
     * @param cardList The list of cards to be evaluated.
     * @return true if the combination is a valid Pair; false otherwise.
     */

    @Override
    public boolean isValid(ArrayList<Card> cardList) {
        if (cardList == null || cardList.size() != 2) {
            return false;
        }

        Map<Character, Integer> rankCount = super.getRankCount(cardList);

        for (int count : rankCount.values()) {
            if (count == 2) {
                return true;
            }
        }

        return false;
    }
}
