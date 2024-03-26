package utils.combinations;

import model.cards.Card;

import java.util.ArrayList;
import java.util.Map;

/**
 * Represents a Quads combination in the Big Two card game.
 * A Quads is defined as four cards of the same rank.
 */

public class Quads extends Combinations {

    /**
     * Checks if a given list of cards constitutes a valid Quads.
     *
     * @param cardList The list of cards to be evaluated.
     * @return true if the combination is a valid Quads; false otherwise.
     */

    @Override
    public boolean isValid(ArrayList<Card> cardList) {
        Map<Character, Integer> rankCount = super.getRankCount(cardList);

        for (int count : rankCount.values()) {
            if (count == 4) {
                return true;
            }
        }
        return false;
    }
}
