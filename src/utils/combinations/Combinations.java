package utils.combinations;

import model.cards.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Combinations {
    private ArrayList<Card> cardList;

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

    public static Map<Character, Integer> getRankCount(ArrayList<Card> cardList) {
        Map<Character, Integer> rankCount = new HashMap<>();
        for (Card card : cardList) {
            char rank = card.getRank();
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        return rankCount;
    }

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

        return true;
    }

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

    private boolean compareSingle(ArrayList<Card> cardsToPlay, ArrayList<Card> lastPlayedCards) {
        Card cardToPlay = cardsToPlay.get(0);
        Card lastPlayedCard = lastPlayedCards.get(0);
        return cardToPlay.compareTo(lastPlayedCard) > 0;
    }

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

    private boolean compareStraight(ArrayList<Card> cardsToPlay, ArrayList<Card> lastPlayedCards) {
        // only need to compare lowest card + lists are already sorted in gamecontrol
        Card toPlay = cardsToPlay.get(0);
        Card lastPlayed = lastPlayedCards.get(0);
        return toPlay.compareRank(lastPlayed) > 0;
    }

    private boolean compareFlush(ArrayList<Card> cardsToPlay, ArrayList<Card> lastPlayedCards) {
        Card toPlay = cardsToPlay.get(4);
        Card lastPlayed = lastPlayedCards.get(4);

        if (toPlay.getSuit() != lastPlayed.getSuit()) {
            // all cards in flush have same suit,
            // so make sure that suit of toPlay is larger than suit of lastPlayed
            return toPlay.compareSuit(lastPlayed) > 0;
        }
        // else if they have the same suit, then compare highcard
        return toPlay.compareTo(lastPlayed) > 0;
    }

    private boolean compareFiveCards(ArrayList<Card> cardsToPlay, ArrayList<Card> lastPlayedCards, int n) {
        char toPlay = 'x';
        char lastPlayed = 'x';

        // full house made up of 3x same rank + 1x pair,
        // get the rank of the 3x same rank of lastPlayed
        Map<Character, Integer> lastPlayedRankCount = getRankCount(lastPlayedCards);
        for (Map.Entry<Character, Integer> entry : lastPlayedRankCount.entrySet()) {
            if (entry.getValue() == n) {
                lastPlayed = entry.getKey();
            }
        }

        // get the rank of the 3x same rank of toPlay
        Map<Character, Integer> toPlayRankCount = getRankCount(cardsToPlay);
        for (Map.Entry<Character, Integer> entry : toPlayRankCount.entrySet()) {
            if (entry.getValue() == n) {
                toPlay = entry.getKey();
            }
        }

        // compare rank
        String order = "3456789tjqka2";
        return order.indexOf(toPlay) - order.indexOf(lastPlayed) > 0;
    }

    private boolean compareStraightFlush(ArrayList<Card> cardsToPlay, ArrayList<Card> lastPlayedCards) {
        Card toPlay = cardsToPlay.get(0);
        Card lastPlayed = lastPlayedCards.get(0);

        // if lowest digit is the same, then check suit
        if (toPlay.getRank() == lastPlayed.getRank()) {
            return toPlay.compareSuit(lastPlayed) > 0;
        }
        // else compare lowest cards
        return toPlay.compareTo(lastPlayed) > 0;
    }

    private boolean compareCombiStrength(String combination, String previousCombination) {
        ArrayList<String> order = new ArrayList<>(
                Arrays.asList("Straight", "Flush", "Full House", "Quads", "Straight Flush"));
        return order.indexOf(combination) - order.indexOf(previousCombination) > 0;
    }

}