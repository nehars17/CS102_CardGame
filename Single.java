import java.util.ArrayList;
import java.util.Map;

public class Single extends Combinations{
    private ArrayList<Card> CardList;

    public boolean isValid(ArrayList<Card> CardList) {
        if(CardList.size()==1) {
            return true;
        }
        return false;

    }
//    public  String getType(){
//        if(this.isValid( CardList)){
//            return "Singles";
//        }
//
//        return "Invalid";
//    }
}
