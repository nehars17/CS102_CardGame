import java.util.ArrayList;
public class CombinationTest {
    public static void main(String[] args) {
                // Create some sample cards
                //7D", "7C", "QH", "10S", "6H --> this is a pair
                Card card1 = new Card("7", 'D');
                Card card2 = new Card("7", 'C');
                Card card3 = new Card("Q", 'H');
                Card card4 = new Card("10", 'S');
                Card card5 = new Card("6", 'H');

                // Create a sample hand
                ArrayList<Card> cards = new ArrayList<>();
                ArrayList<Card> cards2 = new ArrayList<>();

                cards.add(card1);
                cards.add(card2);
                cards.add(card3);
                cards.add(card4);
                cards.add(card5);


                cards2.add(new Card("10",'H'));
                cards2.add(new Card("10",'S'));
                cards2.add(new Card("Q",'C'));
                cards2.add(new Card("8",'D'));
                cards2.add(new Card("5",'H'));


                Hand h1 = new Hand(cards);
                Hand h2 = new Hand(cards2);

                // Test Card class
                System.out.println("Card 1: Rank = " + card1.getRank() + ", Suit = " + card1.getSuit());

                // Test Hand class
                System.out.println("\nHand:");
                for (Card card : h1.getHand()) {
                    System.out.println("Rank = " + card.getRank() + ", Suit = " + card.getSuit());
                }

                // Test Combinations class (assuming you have a concrete implementation)
                // Example: Replace MyCombinations with your actual implementation
                Combinations myCombinations = new Combinations(h1.getHand());
                System.out.println("\nTop Card: " + myCombinations.getTopCard());
                System.out.println("Number of Cards: " + myCombinations.getNumOfCards());
                Pair pair = new Pair();
                //first determine what is the first card type then use that to pass in next card
                if(pair.isPair(h1.getHand()) == pair.isPair(h2.getHand())) {
                    System.out.println("Card1 is pair?: " + pair.isPair(h1.getHand()));
                    System.out.println("Card2 is pair?: " + pair.isPair(h2.getHand()));
                }



        System.out.println("Is Greater Than Card1: " + myCombinations.isGreaterThan(h1,h2));
            }
        }



