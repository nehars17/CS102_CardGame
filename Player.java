import java.util.ArrayList;

public class Player {
    private Hand playerHand;
    private String name;

    public Player(String name) {
        this.name = name;
        playerHand = new Hand();
    }
    public String getName(){
        return name;
    }

    public boolean hasThreeOfDiamonds(Hand playerHand) {
        for (Card card : playerHand.getHand()) {
            if (card.getValue() == 31) {
                return true;
            }
        }
        return false;
    }



    public void removeFromHand(ArrayList<Card> cards) {
        playerHand.removeCards(cards);
    }

    public Hand getHand() {
        return playerHand;
    }

}