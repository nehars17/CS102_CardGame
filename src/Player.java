// package players;

// import combinations.Hand;

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

    public boolean playCard(Card card) {
        return hand.removeCard(card);
    }

    public Hand getHand() {
        return hand;
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
