package utils.combinations;
// package combinations;

import java.util.ArrayList;
import java.util.Map;

import model.cards.Card;

public class FullHouse extends Combinations {

    public boolean isValid(ArrayList<Card> cardList) {
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
