// package combinations;

import java.util.ArrayList;
import java.util.Comparator;

public class Straight extends Combinations {

    public boolean isValid(ArrayList<Card> cardList) {
        String order = "3456789tjqka2";
        cardList.sort(Comparator.comparingInt(card -> order.indexOf(card.getRank())));

        for (int i = 0; i < cardList.size() - 1; i++) {
            if (order.indexOf(cardList.get(i).getRank()) + 1 
                != order.indexOf(cardList.get(i + 1).getRank())) {
                return false;
            }
        }

        return true;
    }
}