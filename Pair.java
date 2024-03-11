import java.util.ArrayList;
import java.util.Map;

public class Pair extends Combinations{
    private ArrayList<Card> CardList;

    public boolean isPair(ArrayList<Card> CardList) {
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
    public String toString(){
        if(this.isPair(CardList)){
            return "Pair";
        }

        return "Invalid";
    }
}
