// package players;

// import combinations.Hand;

import java.util.ArrayList;

public class Player {
    private int playerId;
    private Hand hand;
    private int penaltyPoints;
    private boolean hasPlayed;

    public Player(int playerId) {
        this.playerId = playerId;
        this.hand = new Hand();
        this.penaltyPoints = 0;
        this.hasPlayed = false;
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

    public boolean hasPlayed() {
        return hasPlayed;
    }

    public void setHasPlayed(boolean hasPlayed) {
        this.hasPlayed = hasPlayed;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getPenaltyPoints() {
        return penaltyPoints;
    }

    public void addPenaltyPoints(int points) {
        penaltyPoints += points;
    }
}