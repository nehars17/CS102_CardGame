package combinations;

import cards.Card;

import java.util.ArrayList;

public class Flush extends Combinations {
    private ArrayList<Card> CardList;

    public boolean isValid(ArrayList<Card> CardList) {
        int numOfCards = CardList.size();
        if (numOfCards == 5) {
            String suit = CardList.get(0).getType();
            for (Card card : CardList) {
                if (!card.getType().equals(suit)) {

                    return false;
                }
            }
            System.out.println("Flush!");
            return true;

        }
        return false;

    }
//    public  String getType(){
//        if(this.isValid(CardList)){
//            return "Flush";
//        }
//
//        return "False";
//    }
}


