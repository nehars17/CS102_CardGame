package utils.combinations;

import model.cards.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Handles the validation and comparison of card combinations for the Big Two
 * card game.
 * Supports various card combinations including single, pair, straight, flush,
 * full house,
 * quads, and straight flush.
 */

public class Combinations {
    private ArrayList<Card> cardList;

    /**
     * Constructs a Combinations object without an initial card list.
     */
    public Combinations() {

    }

    /**
     * Constructs a Combinations object with a specified list of cards.
     *
     * @param cardsToPlay The initial list of cards to play.
     */
    public Combinations(ArrayList<Card> cardsToPlay) {
        this.cardList = cardsToPlay;
    }

    /**
     * Evaluates if the provided card list constitutes a valid combination.
     * This method should be overridden in subclasses specific to each combination
     * type.
     *
     * @param cardList The list of cards to be evaluated.
     * @return Always returns false in the base class. Subclasses define their own
     *         validation logic.
     */
    public boolean isValid(ArrayList<Card> cardList) {
        return false;
    }

    /**
     * Counts the occurrences of each rank within a list of cards.
     *
     * @param cardList The list of cards whose ranks are to be counted.
     * @return A map with card ranks as keys and their occurrences as values.
     */
    public static Map<Character, Integer> getRankCount(ArrayList<Card> cardList) {
        Map<Character, Integer> rankCount = new HashMap<>();
        for (Card card : cardList) {
            char rank = card.getRank();
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        return rankCount;
    }

    /**
     * Validates the card combination against the last played cards.
     *
     * @param cardsToPlay     The cards player intends to play.
     * @param lastPlayedCards The last cards that were played.
     * @return true if the combination is valid to play; otherwise, false.
     */
    public boolean validateCards(ArrayList<Card> cardsToPlay, ArrayList<Card> lastPlayedCards) {
        if (lastPlayedCards == null || lastPlayedCards.isEmpty()) {

            String cardsToPlayType = determineType(cardsToPlay);
            if (cardsToPlayType.equals("Invalid Combination")) {
                return false;
            }
            return true;
        }

        int sizeOfLastPlayedCards = lastPlayedCards.size();
        if (cardsToPlay.size() != sizeOfLastPlayedCards) {
            return false;
        }

        if (determineType(cardsToPlay).equals("Invalid Combination")) {
            return false;
        }

        return true;
    }

    /**
     * Determines the type of card combination from a list of cards.
     *
     * @param cards The list of cards to be evaluated.
     * @return The type of card combination.
     */
    public String determineType(ArrayList<Card> cards) {
        int cardsSize = cards.size();

        if (cardsSize == 1) {
            Single single = new Single();
            if (single.isValid(cards)) {
                return "Single";
            }
        } else if (cardsSize == 2) {
            Pair pair = new Pair();
            if (pair.isValid(cards)) {
                return "Pair";
            }
        } else if (cardsSize == 5) {
            StraightFlush straightFlush = new StraightFlush();
            if (straightFlush.isValid(cards)) {
                return "Straight Flush";
            }
            Quads quads = new Quads();
            if (quads.isValid(cards)) {
                return "Quads";
            }
            FullHouse fullHouse = new FullHouse();
            if (fullHouse.isValid(cards)) {
                return "Full House";
            }
            Flush flush = new Flush();
            if (flush.isValid(cards)) {
                return "Flush";
            }
            Straight straight = new Straight();
            if (straight.isValid(cards)) {
                return "Straight";
            }
        }

        return "Invalid Combination";
    }

    /**
     * Checks if the card combination is greater than the last played cards.
     *
     * @param cardsToPlay     The cards player intends to play.
     * @param lastPlayedCards The last cards that were played.
     * @return true if the combination is greater; otherwise, false.
     */
    public boolean checkCombinationIsGreaterThan(ArrayList<Card> cardsToPlay, ArrayList<Card> lastPlayedCards) {
        if (lastPlayedCards.isEmpty()) {
            return true;
        }

        String lastPlayedCardsType = determineType(lastPlayedCards);
        String cardsToPlayType = determineType(cardsToPlay);

        switch (lastPlayedCardsType) {
            case "Single":
                return compareSingle(cardsToPlay, lastPlayedCards);
            case "Pair":
                return comparePair(cardsToPlay, lastPlayedCards);
            case "Straight":
                if (cardsToPlayType.equals(lastPlayedCardsType)) {
                    return compareStraight(cardsToPlay, lastPlayedCards);
                }
                if (compareCombiStrength(cardsToPlayType, lastPlayedCardsType)) {
                    return true;
                }
            case "Flush":
                if (cardsToPlayType.equals(lastPlayedCardsType)) {
                    return compareFlush(cardsToPlay, lastPlayedCards);
                }
                if (compareCombiStrength(cardsToPlayType, lastPlayedCardsType)) {
                    return true;
                }
            case "Full House":
                if (cardsToPlayType.equals(lastPlayedCardsType)) {
                    return compareFiveCards(cardsToPlay, lastPlayedCards, 3);
                }
                if (compareCombiStrength(cardsToPlayType, lastPlayedCardsType)) {
                    return true;
                }
            case "Quads":
                if (cardsToPlayType.equals(lastPlayedCardsType)) {
                    return compareFiveCards(cardsToPlay, lastPlayedCards, 4);
                }
                if (compareCombiStrength(cardsToPlayType, lastPlayedCardsType)) {
                    return true;
                }
            case "Straight Flush":
                if (cardsToPlayType.equals(lastPlayedCardsType)) {
                    return compareStraightFlush(cardsToPlay, lastPlayedCards);
                }
            default:
                return false;
        }
    }

    /**
     * Compares two single cards.
     *
     * @param cardsToPlay     The cards player intends to play.
     * @param lastPlayedCards The last cards that were played.
     * @return true if the card to play is greater; otherwise, false.
     */
    private boolean compareSingle(ArrayList<Card> cardsToPlay, ArrayList<Card> lastPlayedCards) {
        Card cardToPlay = cardsToPlay.get(0);
        Card lastPlayedCard = lastPlayedCards.get(0);
        return cardToPlay.compareTo(lastPlayedCard) > 0;
    }

    /**
     * Compares two pairs of cards.
     *
     * @param cardsToPlay     The cards player intends to play.
     * @param lastPlayedCards The last cards that were played.
     * @return true if the pair to play is greater; otherwise, false.
     */
    private boolean comparePair(ArrayList<Card> cardsToPlay, ArrayList<Card> lastPlayedCards) {
        Card toPlay = cardsToPlay.get(0);
        Card lastPlayed = lastPlayedCards.get(0);

        // if the pairs have the same digit, compare suit
        if (toPlay.getRank() == lastPlayed.getRank()) {
            if (toPlay.getSuit() == 's' || cardsToPlay.get(1).getSuit() == 's') {
                return true;
            }
            return false;
        }
        // if different digit, compare value
        return toPlay.compareTo(lastPlayed) > 0;
    }

    /**
     * Compares two straight cards.
     *
     * @param cardsToPlay     The cards player intends to play.
     * @param lastPlayedCards The last cards that were played.
     * @return true if the straight to play is greater; otherwise, false.
     */
    private boolean compareStraight(ArrayList<Card> cardsToPlay, ArrayList<Card> lastPlayedCards) {
        Card toPlay = cardsToPlay.get(0);
        Card lastPlayed = lastPlayedCards.get(0);
        return toPlay.compareRank(lastPlayed) > 0;
    }

    /**
     * Compares two flush cards.
     *
     * @param cardsToPlay     The cards player intends to play.
     * @param lastPlayedCards The last cards that were played.
     * @return true if the flush to play is greater; otherwise, false.
     */
    private boolean compareFlush(ArrayList<Card> cardsToPlay, ArrayList<Card> lastPlayedCards) {
        Card toPlay = cardsToPlay.get(4);
        Card lastPlayed = lastPlayedCards.get(4);

        if (toPlay.getSuit() != lastPlayed.getSuit()) {
            return toPlay.compareSuit(lastPlayed) > 0;
        }
        return toPlay.compareTo(lastPlayed) > 0;
    }

    /**
     * Compares two full house cards.
     *
     * @param cardsToPlay     The cards player intends to play.
     * @param lastPlayedCards The last cards that were played.
     * @param n               The number of cards in the full house.
     * @return true if the full house to play is greater; otherwise, false.
     */
    private boolean compareFiveCards(ArrayList<Card> cardsToPlay, ArrayList<Card> lastPlayedCards, int n) {
        char toPlay = 'x';
        char lastPlayed = 'x';

        Map<Character, Integer> lastPlayedRankCount = getRankCount(lastPlayedCards);
        for (Map.Entry<Character, Integer> entry : lastPlayedRankCount.entrySet()) {
            if (entry.getValue() == n) {
                lastPlayed = entry.getKey();
            }
        }

        Map<Character, Integer> toPlayRankCount = getRankCount(cardsToPlay);
        for (Map.Entry<Character, Integer> entry : toPlayRankCount.entrySet()) {
            if (entry.getValue() == n) {
                toPlay = entry.getKey();
            }
        }

        String order = "3456789tjqka2";
        return order.indexOf(toPlay) - order.indexOf(lastPlayed) > 0;
    }

    /**
     * Compares two straight flush cards.
     *
     * @param cardsToPlay     The cards player intends to play.
     * @param lastPlayedCards The last cards that were played.
     * @return true if the straight flush to play is greater; otherwise, false.
     */
    private boolean compareStraightFlush(ArrayList<Card> cardsToPlay, ArrayList<Card> lastPlayedCards) {
        Card toPlay = cardsToPlay.get(0);
        Card lastPlayed = lastPlayedCards.get(0);

        if (toPlay.getRank() == lastPlayed.getRank()) {
            return toPlay.compareSuit(lastPlayed) > 0;
        }
        return toPlay.compareTo(lastPlayed) > 0;
    }

    /**
     * Compares the strength of two card combinations.
     *
     * @param combination         The combination to play.
     * @param previousCombination The last played combination.
     * @return true if the combination to play is stronger; otherwise, false.
     */
    private boolean compareCombiStrength(String combination, String previousCombination) {
        ArrayList<String> order = new ArrayList<>(
                Arrays.asList("Straight", "Flush", "Full House", "Quads", "Straight Flush"));
        return order.indexOf(combination) - order.indexOf(previousCombination) > 0;
    }
}