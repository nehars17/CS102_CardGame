package utils.combinations;

import model.cards.Card;

import java.util.ArrayList;

/**
 * Represents a StraightFlush combination in the Big Two card game.
 * A StraightFlush is defined as five cards of the same suit in sequence.
 */

public class StraightFlush extends Combinations {

    /**
     * Checks if a given list of cards constitutes a valid StraightFlush.
     *
     * @param CardList The list of cards to be evaluated.
     * @return true if the combination is a valid StraightFlush; false otherwise.
     */

    @Override
    public boolean isValid(ArrayList<Card> CardList) {
        Straight s1 = new Straight();
        Flush f1 = new Flush();
        return s1.isValid(CardList) && f1.isValid(CardList);
    }
}
