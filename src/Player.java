// package players;

// import combinations.Hand;

import java.util.ArrayList;

public class Player {
    private String name;
    private Hand hand;
    private int penaltyPoints;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
        this.penaltyPoints = 0;
    }

    public void receiveCard(Card card) {
        hand.addCard(card);
    }

    public void playCard(ArrayList<Card> cardsToPlay) {
        for (Card card : cardsToPlay) {
            hand.getCardsInHand().remove(card);
        }
    }

    public ArrayList<Card> getCardsInHand() {
        return hand.getCardsInHand();
    }

    public String getName() {
        return name;
    }

    public int getPenaltyPoints() {
        return penaltyPoints;
    }

    public void addPenaltyPoints(int points) {
        penaltyPoints += points;
    }
}
