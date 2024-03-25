// package combinations;

import java.util.ArrayList;
import java.util.Map;

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
        System.out.println("Full House!");
        return hasThreeOfAKind && hasPair;
    }
}
