//import java.util.ArrayList;
//import java.util.Map;
//
//public class Quads extends Combinations{
//    private ArrayList<Card> CardList;
//
//    public boolean isValid(ArrayList<Card> CardList) {
//        Map<Integer, Integer> rankCount = super.getRankCount(CardList);
//
//        for (int count : rankCount.values()) {
//            if (count == 4) {
//                System.out.println("Quads!");
//                return true;
//            }
//        }
//
//        return false;
//    }
//    public  String getType(){
//        if(this.isValid(ArrayList<Card> CardList)){
//            return "Quads";
//        }
//
//        return "Invalid";
//    }
//}
