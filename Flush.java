//import java.util.ArrayList;
//
//public class Flush extends Combinations {
//    private ArrayList<Card> CardList;
//
//    public boolean isValid(ArrayList<Card> CardList) {
//        int numOfCards = CardList.size();
//        if (numOfCards == 5) {
//            int i = 1;
//            if (CardList.get(0).length() > 2) {
//                i = 2;
//            }
//            char suit = CardList.get(0).charAt(i);
//
//            for (Card card : CardList) {
//                if (card.getCard() == 2) {
//                    i = 1;
//                }
//
//                if (card.getSuite() != suit) {
//
//                    return false;
//                }
//            }
//            System.out.println("Flush!");
//            return true;
//
//        }
//        return false;
//
//    }
//    public  String getType(){
//        if(this.isValid(ArrayList<Card> CardList)){
//            return "Flush";
//        }
//
//        return "False";
//    }
//}
//
//
