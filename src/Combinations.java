import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Combinations {
    private ArrayList<Card> cardList;
    private String cardsToPlayType;

    public Combinations() {

    }

    public Combinations(ArrayList<Card> cardsToPlay) {
        this.cardList = cardsToPlay;
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

    public String getCardsToPlayType() {
        return cardsToPlayType;
    }

    public void setCardsToPlayType(String cardsToPlayType) {
        this.cardsToPlayType = cardsToPlayType;
    }

    public static Map<Character, Integer> getRankCount(ArrayList<Card> cardList) {
        Map<Character, Integer> rankCount = new HashMap<>();
        for (Card card : cardList) {
            char rank = card.getRank();
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }

        return rankCount;
    }

    public boolean validateCards(ArrayList<Card> cardsToPlay, ArrayList<Card> lastPlayedCards) {
        int sizeOfLastPlayedCards = lastPlayedCards.size();
        if (cardsToPlay.size() != sizeOfLastPlayedCards) {
            return false;
        }

        if (sizeOfLastPlayedCards == 1) {
            Single single = new Single();
            if (single.isValid(cardsToPlay)) {
                cardsToPlayType = "Single";
                return true;
            }
        } else if (sizeOfLastPlayedCards == 2) {
            Pair pair = new Pair();
            if (pair.isValid(cardsToPlay)) {
                cardsToPlayType = "Pair";
                return true;
            }
        } else if (sizeOfLastPlayedCards == 5) {
            Straight straight = new Straight();
            if (straight.isValid(cardsToPlay)) {
                cardsToPlayType = "Straight";
                return true;
            }
            Flush flush = new Flush();
            if (flush.isValid(cardsToPlay)) {
                cardsToPlayType = "Flush";
                return true;
            }
            FullHouse fullHouse = new FullHouse();
            if (fullHouse.isValid(cardsToPlay)) {
                cardsToPlayType = "Full House";
                return true;
            }
            Quads quads = new Quads();
            if (quads.isValid(cardsToPlay)) {
                cardsToPlayType = "Quads";
                return true;
            }
            StraightFlush straightFlush = new StraightFlush();
            if (straightFlush.isValid(cardsToPlay)) {
                cardsToPlayType = "Straight Flush";
                return true;
            }
        }
        return false;
    }

    // public boolean checkCombinationIsGreaterThan(ArrayList<Card> cardsToPlay, ArrayList<Card> lastPlayedCards) {
    //     if (lastPlayedCards.isEmpty()) {
    //         return true;
    //     }
        
        

    //     // Check combination type of previous
        

        
    //     if (cardsToPlayType.equals("Straight")){

    //     }
    //     return false;
    // }

    public boolean checkCombinationIsGreaterThan(ArrayList<Card> cardsToPlay, ArrayList<Card> lastPlayedCards) {
        if (lastPlayedCards.isEmpty()) {
            return true; 
        }

        switch (cardsToPlayType) {
            case "Single":
                return compareSingle(cardsToPlay, lastPlayedCards);
            case "Pair":
                return comparePair(cardsToPlay, lastPlayedCards);
            case "Straight":
                return compareStraight(cardsToPlay, lastPlayedCards);
            // Add cases for Flush, Full House, Quads, and Straight Flush
            default:
                return false;
        }
    }
    
    private boolean compareSingle(ArrayList<Card> cardsToPlay, ArrayList<Card> lastPlayedCards) {
        Card topCardToPlay = cardsToPlay.get(0);
        Card lastPlayedTopCard = lastPlayedCards.get(0);
        return topCardToPlay.compareTo(lastPlayedTopCard) > 0;
    }
    
    private boolean comparePair(ArrayList<Card> cardsToPlay, ArrayList<Card> lastPlayedCards) {
        // Pair comparison logic
        // Assuming you have a way to compare the rank and then the suit if ranks are equal.
        return compareByRankAndSuit(cardsToPlay, lastPlayedCards);
    }
    
    private boolean compareStraight(ArrayList<Card> cardsToPlay, ArrayList<Card> lastPlayedCards) {
        // Straight comparison logic, comparing the smallest card in each straight.
        Collections.sort(cardsToPlay); // Assuming Card implements Comparable and sorts by rank then suit.
        Collections.sort(lastPlayedCards);
        Card smallestCardToPlay = cardsToPlay.get(0);
        Card lastPlayedSmallestCard = lastPlayedCards.get(0);
        return smallestCardToPlay.compareTo(lastPlayedSmallestCard) > 0;
    }
    
    // You'll need to implement methods for Flush, Full House, Quads, and Straight Flush comparisons.
    

    // public Combinations determineCombinationType(ArrayList<Card> selectedCards, int sizeOfLastPlayedCombinations) {
    //     // First, sort the cards by rank (and by suit if ranks are equal).
    //     Collections.sort(selectedCards);

    //     if (sizeOfLastPlayedCombinations == 1) {
    //         Single single = new Single();
    //         return single.isValid(selectedCards);
    //     } else if (sizeOfLastPlayedCombinations == 2) {
    //         return new Pair(selectedCards);
    //     } else if (sizeOfLastPlayedCombinations == 3) {
    //         return new ThreeOfAKind(selectedCards);
    //     } else if (sizeOfLastPlayedCombinations == 4) {
    //         return new FourOfAKind(selectedCards);
    //     }

    //     // Now, determine the combination type
    //     if (StraightFlush.isValid(selectedCards)) {
    //         return new StraightFlush(selectedCards);
    //     } else if (Quads.isValid(selectedCards)) {
    //         return new Quads(selectedCards);
    //     } else if (FullHouse.isValid(selectedCards)) {
    //         return new FullHouse(selectedCards);
    //     } else if (Flush.isValid(selectedCards)) {
    //         return new Flush(selectedCards);
    //     } else if (Straight.isValid(selectedCards)) {
    //         return new Straight(selectedCards);
    //     } else if (Pair.isValid(selectedCards)) {
    //         return new Pair(selectedCards);
    //     } else if (Single.isValid(selectedCards)) {
    //         return new Single(selectedCards);
    //     }

    //     // If no valid combination is found, return null or throw a custom exception
    //     throw new InvalidCombinationException("No valid combination found.");
    // }

    // @Override
    // public String toString() {
    //     return  + " of " + suit;
    // }
}
