package utils.combinations;

import model.cards.Card;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Represents a Straight combination in the Big Two card game.
 * A Straight is defined as five cards in sequence, not of the same suit.
 */

public class Straight extends Combinations {

    /**
     * Checks if a given list of cards constitutes a valid Straight.
     *
     * @param cardList The list of cards to be evaluated.
     * @return true if the combination is a valid Straight; false otherwise.
     */

    @Override
    public boolean isValid(ArrayList<Card> cardList) {
        String order = "3456789tjqka2";
        cardList.sort(Comparator.comparingInt(card -> order.indexOf(card.getRank())));

        for (int i = 0; i < cardList.size() - 1; i++) {
            if (order.indexOf(cardList.get(i).getRank()) + 1 != order.indexOf(cardList.get(i + 1).getRank())) {
                return false;
            }
        }

        return true;
    }
}