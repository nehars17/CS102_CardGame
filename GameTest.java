import java.util.ArrayList;
import java.util.*;
public class GameTest {
    public static ArrayList<Card> getPlayingHand(Player currentPlayer, ArrayList<Combinations> combinations){
        ArrayList<Card> PlayedCards = new ArrayList<>();
        boolean invalidateFirstHand = false;
        while (invalidateFirstHand==false) {
            System.out.println("Hi," + currentPlayer.getName());
            Hand currentHand = currentPlayer.getHand();
            System.out.println(currentHand.getHand().toString());
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter card choices(separated by comma):");
            String[] cards = sc.nextLine().split(",");
            for (int i = 0; i < cards.length; i++) {
                PlayedCards.add(new Card(cards[i].substring(0, 1), cards[i].substring(1, 2)));
            }
            for (Combinations combination : combinations) {
                if (combination.isValid(PlayedCards)) {
                    System.out.println("Card is " + combination.getClass().getSimpleName());
                    invalidateFirstHand = true;
                    break;
                }

        }

        }
        return PlayedCards;

    }
    public static void main(String[] args) {
        Game g1 = new Game();
        g1.startGame();


        Combinations myCombinations = new Combinations();
        ArrayList<Combinations> combinations = new ArrayList<>();
        boolean anyMatch = false;

        combinations.add(new Quads());
        combinations.add(new FullHouse());
        combinations.add(new StraightFlush());
        combinations.add(new Pair());
        combinations.add(new Flush());
        combinations.add(new Single());
        combinations.add(new Straight());

        ArrayList<Player> playerList = g1.getAllPlayers();
        Player currentPlayer = g1.getActivePlayer();
        ArrayList<Card> currentPlayedCards = getPlayingHand(currentPlayer,combinations);
        String currentPlayerName = currentPlayer.getName();
        for (int i = 0; i < playerList.size(); i++) {
            Hand currentPlayerhand = currentPlayer.getHand();
//            System.out.println("current player hand " + currentPlayerhand.getHand().toString());
            System.out.println("current player hand " + currentPlayedCards.toString());


            if (!playerList.get(i).getName().equals(currentPlayerName)) {

                g1.setActivePlayer(playerList.get(i));
                Player nextPlayer = g1.getActivePlayer();
                currentPlayerName = currentPlayer.getName();
                Hand nextHand = nextPlayer.getHand();
                while (true) {
                    ArrayList<Card> nextPlayedCards = getPlayingHand(nextPlayer, combinations);
//                    System.out.println("next player hand " + nextHand.getHand().toString());
                    System.out.println("next player hand " + nextPlayedCards.toString());


                    for (Combinations combination : combinations) {
                        if (combination.isValid(currentPlayedCards) && combination.isValid(nextPlayedCards)) {
                            System.out.println("Both hands have " + combination.getClass().getSimpleName());
                            anyMatch = true;
                            break;
                        }
                    }
                    if (!anyMatch) {
                        System.out.println("false:no match");

                    }
                    else{
                        if (myCombinations.isGreaterThan(currentPlayedCards, nextPlayedCards)) {
                            break;
                        }
                        else{
                            System.out.println("Card value has to be greater than previous player!");
                        }

                    }


                }
            }
        }

    }
}





//    }



