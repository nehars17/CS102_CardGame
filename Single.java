// package combinations;

import java.util.ArrayList;

public class Single extends Combinations {

    public boolean isValid(ArrayList<Card> cardList) {
        System.out.println("Single!");
        return cardList.size() == 1;
    }

}