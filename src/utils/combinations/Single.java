package utils.combinations;

import model.cards.Card;

import java.util.ArrayList;

/**
 * Represents a Single combination in the Big Two card game.
 * A Single is defined as a single card.
 */

public class Single extends Combinations {

    /**
     * Checks if a given list of cards constitutes a valid Single.
     *
     * @param cardList The list of cards to be evaluated.
     * @return true if the combination is a valid Single; false otherwise.
     */

    @Override
    public boolean isValid(ArrayList<Card> cardList) {
        return cardList.size() == 1;
    }
}