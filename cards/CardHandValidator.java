package cards;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CardHandValidator {

    public static void main(String[] args) {
        String[] hand1 = { "7d", "7c", "qh", "10s", "6h" }; // Example one pair
        String[] hand2 = { "5h", "6c", "7d", "8c", "9h" }; // Example straight
        String[] hand3 = { "ah", "jh", "10h", "4h", "2h" }; // Example flush
        String[] hand4 = { "kc", "kd", "kh", "9d", "9s" }; // Example full house
        String[] hand5 = { "5d", "6d", "7d", "8d", "9d" }; // Example straight flush
        String[] hand6 = { "5h", "5s", "5d", "5c", "qc" }; // Example four of a kind

        System.out.println("Hand 1 is a valid poker hand: " + isValidPokerHand(hand1));
        System.out.println("Hand 2 is a valid poker hand: " + isValidPokerHand(hand2));
        System.out.println("Hand 3 is a valid poker hand: " + isValidPokerHand(hand3));
        System.out.println("Hand 4 is a valid poker hand: " + isValidPokerHand(hand4));
        System.out.println("Hand 5 is a valid poker hand: " + isValidPokerHand(hand5));
        System.out.println("Hand 5 is a valid poker hand: " + isValidPokerHand(hand6));

    }

    private static boolean isValidPokerHand(String[] hand) {
        if (hand.length != 5) {
            System.out.println("Invalid hand: Must have exactly 5 cards.");
            return false;
        }

        Arrays.sort(hand);

        if (isStraightFlush(hand) || isQuads(hand) || isFullHouse(hand) || isFlush(hand) || isStraight(hand)
                || isPair(hand) || isSingles(hand)) {
            return true;
        }

        System.out.println("Invalid hand: Not a valid poker hand.");
        return false;
    }

    // WORK ON THIS
    private static boolean isSingles(String[] hand) {
        if (hand.length == 1) {
            System.out.println("Singles!");
            return true;
        }
        return false;
    }

    private static boolean isPair(String[] hand) {
        Map<Character, Integer> rankCount = getRankCount(hand);

        for (int count : rankCount.values()) {
            if (count == 2) {
                System.out.println("Pair!");
                return true;
            }
        }

        return false;
    }

    private static boolean isFlush(String[] hand) {
        int i = 1;
        if (hand[0].length() > 2) {
            i = 2;
        }
        char suit = hand[0].charAt(i);

        for (String card : hand) {
            if (card.length() == 2) {
                i = 1;
            }

            if (card.charAt(i) != suit) {

                return false;
            }
        }

        System.out.println("Flush!");
        return true;
    }

    private static boolean isQuads(String[] hand) {
        Map<Character, Integer> rankCount = getRankCount(hand);

        for (int count : rankCount.values()) {
            if (count == 4) {
                System.out.println("Quads!");
                return true;
            }
        }

        return false;
    }

    private static boolean isStraightFlush(String[] hand) {
        return isStraight(hand) && isFlush(hand);
    }

    private static boolean isStraight(String[] hand) {
        for (int i = 0; i < hand.length - 1; i++) {
            int rank1 = getRank(hand[i]);
            int rank2 = getRank(hand[i + 1]);

            if (rank2 - rank1 != 1) {
                return false;
            }
        }

        System.out.println("Straight!");
        return true;
    }

    private static boolean isFullHouse(String[] hand) {
        Map<Character, Integer> rankCount = getRankCount(hand);

        boolean hasThreeOfAKind = false;
        boolean hasPair = false;

        for (int count : rankCount.values()) {
            System.out.println(count);
            if (count == 3) {
                hasThreeOfAKind = true;
            } else if (count == 2) {
                hasPair = true;
            }
        }

        if (hasThreeOfAKind && hasPair) {
            System.out.println("Full House!");
            return true;
        }

        return false;
    }

    private static Map<Character, Integer> getRankCount(String[] hand) {
        Map<Character, Integer> rankCount = new HashMap<>();

        for (String card : hand) {
            char rank = getRank(card);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }

        return rankCount;
    }

    private static int getRank(String card) {
        char rankChar = card.charAt(0);

        if (Character.isDigit(rankChar)) {
            return Character.getNumericValue(rankChar);
        } else {
            switch (rankChar) {
                case 'T':
                    return 10;
                case 'J':
                    return 11;
                case 'Q':
                    return 12;
                case 'K':
                    return 13;
                case 'A':
                    return 14;
                default:
                    return -1; // Invalid rank
            }
        }
    }
}
