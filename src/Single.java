// package combinations;

import java.util.ArrayList;

public class Single extends Combinations {

    public boolean isValid(ArrayList<Card> cardList) {
        return cardList.size() == 1;
    }
}
