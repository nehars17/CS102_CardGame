package combinations;

import cards.Card;

import java.util.ArrayList;

public class StraightFlush extends Combinations {
    private ArrayList<Card> CardList;

    public  boolean isValid(ArrayList<Card> CardList) {
        Straight s1 = new Straight();
        Flush f1 = new Flush();
        return s1.isValid(CardList) && f1.isValid(CardList);
    }
//    public String getType()
//    {
//        return this.type;
//    }
}



