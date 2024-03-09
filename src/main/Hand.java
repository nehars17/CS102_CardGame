public class Hand {
    
    private ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<>();
    }

    public void removeCards(ArrayList<Card> cards) {
        
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public boolean hasCard(Card card) {
        return hand.contains(card);
    }

    public boolean hasThreeOfDiamonds() {
        for (Card card : hand) {
            if (card.getValue() == 31) {
                return true;
            }
        }
        return false;
    }

}
