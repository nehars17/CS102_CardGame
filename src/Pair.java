// package combinations;

import java.util.ArrayList;
import java.util.Map;

public class Pair extends Combinations {

    public boolean isValid(ArrayList<Card> cardList) {

        Map<Character, Integer> rankCount = super.getRankCount(cardList);

        for (int count : rankCount.values()) {
            if (count == 2) {
                return true;
            }
        }

        return false;
    }
}
