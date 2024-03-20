import java.util.ArrayList;
public class CombinationTest {
    public static void main(String[] args) {

                String[] single = {"ah"};
                String[] pair = {"8h","8d","4s","9c","qh"};
                String[] quads = {"10d","10h","10c","10s","ad"};
                String[] straightflush = {"5D", "6D", "7D", "8D", "9D"};
                String[] straight = {"3d","4h","5c","6s","7d"};
                String[] fullhouse = {"KC", "KD", "KH", "9D", "9S"};
                String[] flush  = {"2h","5h","7h","9h","kh"};

                ArrayList<Card> CardList = new ArrayList<>();

                String[] handType = fullhouse;

                for(int i=0;i<handType.length;i++){
                    handType[i] = handType[i].toLowerCase();
                    CardList.add(new Card(handType[i].substring(0,1),handType[i].substring(1,2)));
                }
        // Create some sample cards

                Hand h1 = new Hand();
                Hand h2 = new Hand();


                for (Card c:CardList){
                    h1.addCard(c);
                    h2.addCard(c);
                }



                // Test Hand class
                System.out.println("\nHand:");
                for (Card card : h1.getHand()) {
                    System.out.println(card);
                }


                Combinations myCombinations = new Combinations(h1.getHand());
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
                    if (combination.isValid(h1.getHand()) && combination.isValid(h2.getHand())) {
                        System.out.println("Both hands have " + combination.getClass().getSimpleName());
                        anyMatch=true;
                        break;
                    }
                }
                if(!anyMatch){
                    System.out.println("false:no match");
                }




//        System.out.println("Is Greater Than Card1: " + myCombinations.isGreaterThan(h1,h2));
            }
        }



