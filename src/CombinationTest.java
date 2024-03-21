// package combinations;

// import players.Hand;

import java.util.ArrayList;

public class CombinationTest {
    public static void main(String[] args) {

        String[] single = { "ah" };
        String[] pair = { "8h", "8d", "4s", "9c", "qh" };
        String[] quads = { "td", "th", "tc", "ts", "ad" };
        String[] straightflush = { "5d", "6d", "7d", "8d", "9d" };
        String[] straight = { "3d", "4h", "5c", "6s", "7d" };
        String[] fullhouse = { "kc", "kd", "kh", "9d", "9s" };
        String[] flush = { "2h", "5h", "7h", "9h", "kh" };

        ArrayList<Card> CardList = new ArrayList<>();

        String[] handType = fullhouse;

        for (int i = 0; i < handType.length; i++) {
            handType[i] = handType[i].toLowerCase();
            char a = handType[i].substring(0, 1).charAt(0);
            char b = handType[i].substring(1, 2).charAt(0);
            CardList.add(new Card(a, b));
        }
        // Create some sample cards

        Hand h1 = new Hand();
        Hand h2 = new Hand();

        for (Card c : CardList) {
            h1.addCard(c);
            h2.addCard(c);
        }

        // Test Hand class
        System.out.println("\nHand:");
        for (Card card : h1.getCardsInHand()) {
            System.out.println(card);
        }

        Combinations myCombinations = new Combinations(h1.getCardsInHand());
        System.out.println("\nTop Card: " + myCombinations.getTopCard());
        System.out.println("Number of Cards: " + myCombinations.getNumOfCards());
        ArrayList<Combinations> combinations = new ArrayList<>();
        boolean anyMatch = false;

        combinations.add(new Quads());
        combinations.add(new FullHouse());
        combinations.add(new StraightFlush());
        combinations.add(new Pair());
        combinations.add(new Flush());
        combinations.add(new Straight());
        combinations.add(new Single());

        for (Combinations combination : combinations) {
            if (combination.isValid(h1.getCardsInHand()) && combination.isValid(h2.getCardsInHand())) {
                System.out.println("Both hands have " + combination.getClass().getSimpleName());
                anyMatch = true;
                break;
            }
        }
        if (!anyMatch) {
            System.out.println("false:no match");
        }

        System.out.println("Is Greater Than Card1: " + myCombinations.isGreaterThan(h1, h2));
    }
}
