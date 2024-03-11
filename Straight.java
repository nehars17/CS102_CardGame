//import java.util.ArrayList;
//import java.util.Map;
//
//public class Straight extends Combinations{
//    private ArrayList<Card> CardList;
//
//    public boolean isValid(ArrayList<Card> CardList) {
//        Map<Integer, Integer> rankCount = super.getRankCount(CardList);
//
//        boolean hasThreeOfAKind = false;
//        boolean hasPair = false;
//
//        for (int count : rankCount.values()) {
//            if (count == 3) {
//                hasThreeOfAKind = true;
//            } else if (count == 2) {
//                hasPair = true;
//            }
//        }
//
//        if (hasThreeOfAKind && hasPair) {
//            System.out.println("Full House!");
//            return true;
//        }
//
//        return false;
//
//    }
//    public  String getType(){
//        if(this.isValid(ArrayList<Card> CardList)){
//            return "Full House!";
//        }
//
//        return "False";
//    }
//}
