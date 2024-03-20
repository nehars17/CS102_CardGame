import java.util.ArrayList;
import java.util.Map;

public class Straight extends Combinations{
    private ArrayList<Card> CardList;

    public boolean isValid(ArrayList<Card> CardList) {
            for (int i=0; i<CardList.size()-1;i++) {
                int rank1 = CardList.get(i).getRankVal();
                int rank2 =CardList.get(i+1).getRankVal() ;
                if (rank2 - rank1 != 1){
                    return false;
                }
            }

            return true;
        }

    }
//    public  String getType(){
//        if(this.isValid(ArrayList<Card> CardList)){
//            return "Full House!";
//        }
//
//        return "False";
//    }

