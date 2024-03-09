import java.util.ArrayList;

public class Hand {
    
    private ArrayList<Card> hand;
    private ArrayList<Card> littleHand;

    public Hand() {
        hand = new ArrayList<Card>();
    }
    
    public ArrayList<Card> getHand() {
        return hand;
    }
    
    public void addCard(Card card) {
        hand.add(card);
    }

    public void removeCards(ArrayList<Card> cards) {
        
    }


    public boolean hasCard(Card card) {
        return hand.contains(card);
    }
    

    public ArrayList<Card> selectCardsToPlay(ArrayList<Card> cards) {
        //To be replaced with GUI later

        System.out.println(cards);
        
        return littleHand;
    }
    public static void main(String[] args) {

        System.out.println(hand);
    }

}
