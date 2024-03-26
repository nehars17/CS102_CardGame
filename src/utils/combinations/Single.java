package utils.combinations;
// package combinations;

import java.util.ArrayList;

import model.cards.Card;

public class Single extends Combinations {

    public boolean isValid(ArrayList<Card> cardList) {
        return cardList.size() == 1;
    }

}