import java.util.ArrayList;
import java.util.Collections;

public class Hand {
    private ArrayList<Card> cardsInHand;
    // gotta rename the littleHand
    private ArrayList<Card> littleHand;


    public Hand() {
        this.cardsInHand = new ArrayList<>();
    }

    public ArrayList<Card> getCardsInHand() {
        return cardsInHand;
    }

    public void addCard(Card card) {
        cardsInHand.add(card);
    }

    public boolean removeCard(Card card) {
        return cardsInHand.remove(card);
    }

    public boolean hasCard(Card card) {
        return cardsInHand.contains(card);
    }

    public ArrayList<Card> selectCardsToPlay(ArrayList<Card> cards) {
        //To be replaced with GUI later

        System.out.println(cards);
        
        return littleHand;
    }

    public void sortHand() {
        Collections.sort(cardsInHand, (card1, card2) -> Integer.compare(card1.getValue(), card2.getValue()));
    }

}
