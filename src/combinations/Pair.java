package combinations;
import java.util.ArrayList;
import java.util.Map;

import cards.Card;

public class Pair extends Combinations{
    private ArrayList<Card> CardList;

    public boolean isValid(ArrayList<Card> CardList) {
        this.CardList = CardList;
        Map<Integer, Integer> rankCount = super.getRankCount(CardList);

        for (int count : rankCount.values()) {
            if (count == 2) {
//                System.out.println("Pair!");
                return true;
            }
        }

        return false;

    }
//    public String toString(){
//        if(this.isValid(CardList)){
//            return "Pair";
//        }
//
//        return "Invalid";
//    }
}
