// Hand.java
import java.util.ArrayList;
import java.util.Collections;

public class Hand {
    public ArrayList<Card> hand;

    public Hand(){

    }

    public Hand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void sort() {
        Collections.sort(hand);
    }

    public int size() {
        return hand.size();
    }

    public Card getCard(int index) {
        return hand.get(index);
    }
}