// package combinations;

import java.util.ArrayList;

public class Flush extends Combinations {

    public boolean isValid(ArrayList<Card> cardList) {
        if (cardList.size() != 5) {
            return false;
        }

        char suit = cardList.get(0).getSuit();
        for (Card card : cardList) {
            if (card.getSuit() != suit) {
                return false;
            }
        }

        return true;
    }
}
