package utils.combinations;

import model.cards.Card;

import java.util.ArrayList;
import java.util.Map;

public class Quads extends Combinations {

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