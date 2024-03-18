import java.util.ArrayList;
import java.util.Map;

public class FullHouse extends Combinations {
    private ArrayList<Card> CardList;

    public boolean isValid(ArrayList<Card> CardList) {
        Map<Integer, Integer> rankCount = super.getRankCount(CardList);
        boolean hasThreeOfAKind = false;
        boolean hasPair = false;

        for (int count : rankCount.values()) {
            if (count == 3) {
                hasThreeOfAKind = true;
            } else if (count == 2) {
                hasPair = true;
            }
        }

        if (hasThreeOfAKind && hasPair) {
            return true;
        }

        return false;

    }
//    public  String getType(){
//        if(this.isValid(ArrayList<Card> CardList)){
//            return "Full House!";
//        }
//
//        return "Invalid";
//    }
}
