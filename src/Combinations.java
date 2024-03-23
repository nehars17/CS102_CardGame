import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

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

    public static boolean isGreaterThan(Hand h1, Hand h2) {
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

    public Combinations determineCombinationType(ArrayList<Card> selectedCards) {
        // First, sort the cards by rank (and by suit if ranks are equal).
        Collections.sort(selectedCards, new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                int rankComparison = Integer.compare(c1.getRank(), c2.getRank());
                if (rankComparison != 0) {
                    return rankComparison;
                }
                return Integer.compare(g etSuitValue(c1.getSuit()), getSuitValue(c2.getSuit()));
            }
        });

        // Now, determine the combination type
        if (StraightFlush.isValid(selectedCards)) {
            return new StraightFlush(selectedCards);
        } else if (Quads.isValid(selectedCards)) {
            return new Quads(selectedCards);
        } else if (FullHouse.isValid(selectedCards)) {
            return new FullHouse(selectedCards);
        } else if (Flush.isValid(selectedCards)) {
            return new Flush(selectedCards);
        } else if (Straight.isValid(selectedCards)) {
            return new Straight(selectedCards);
        } else if (Pair.isValid(selectedCards)) {
            return new Pair(selectedCards);
        } else if (Single.isValid(selectedCards)) {
            return new Single(selectedCards);
        }

        // If no valid combination is found, return null or throw a custom exception
        throw new InvalidCombinationException("No valid combination found.");
    }

    // @Override
    // public String toString() {
    //     return  + " of " + suit;
    // }
}
