package utils.combinations;

import model.cards.Card;

import java.util.ArrayList;

public class StraightFlush extends Combinations {

    public boolean isValid(ArrayList<Card> CardList) {
        Straight s1 = new Straight();
        Flush f1 = new Flush();
        return s1.isValid(CardList) && f1.isValid(CardList);
    }
}
