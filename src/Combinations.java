
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// import players.Hand;

public class Combinations {
    private ArrayList<Card> cardList;

    public Combinations() {

    }

    public Combinations(ArrayList<Card> hand) {
        this.cardList = hand;
    }

    public boolean isValid(ArrayList<Card> cardList) {
        return false;
    }

    public Card getTopCard() {
        return cardList.get(0);
    }

    public int getNumOfCards() {
        return cardList.size();
    }

    public static Map<Character, Integer> getRankCount(ArrayList<Card> cardList) {
        Map<Character, Integer> rankCount = new HashMap<>();
        for (Card card : cardList) {
            char rank = card.getRank();
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }

        return rankCount;
    }

    public boolean isGreaterThan(Hand h1, Hand h2) {
        int cardTotal1 = 0;
        int cardTotal2 = 0;
        if (h1.getCardsToPlay() == null && h2.getCardsToPlay() == null) {
            return true;
        }

        else if (h1.getCardsToPlay().size() != h2.getCardsToPlay().size()) {
            return false;
        }

        else {
            for (int i = 0; i < h1.getCardsToPlay().size(); i++) {
                Card card = h1.getCardsToPlay().get(i);
                Card card2 = h2.getCardsToPlay().get(i);
                cardTotal1 += card.getValue();
                cardTotal2 += card2.getValue();

            }
            System.out.println(cardTotal1 + "  " + cardTotal2);
            if (cardTotal1 < cardTotal2) {
                return true;
            } else {
                return false;
            }
        }
    }

    // @Override
    // public String toString() {
    //     return  + " of " + suit;
    // }
}
