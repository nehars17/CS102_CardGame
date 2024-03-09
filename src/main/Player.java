import java.util.ArrayList;

public class Player {
    private Hand playerHand;

    public boolean hasThreeOfDiamonds(Hand playerHand) {

        for (Card card : playerHand) {
            if (card.getValue() == 31) {
                return true;
            }
        }
        return false;
    }

    public removeFromHand(ArrayList<Card> cards) {
        playerHand.removeCards(cards);
    }

}
