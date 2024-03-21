// package players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Hand {
    private ArrayList<Card> cardsInHand;
    private ArrayList<Card> cardsToPlay;

    public Hand() {
        this.cardsInHand = new ArrayList<>();
    }

    public ArrayList<Card> getCardsToPlay() {
        return cardsToPlay;
    }

    public ArrayList<Card> getCardsInHand() {
        return cardsInHand;
    }

    public void addCard(Card card) {
        cardsInHand.add(card);
    }

    public boolean removeCard(Card card) {
        return cardsInHand.remove(card);
    }

    public boolean hasCard(Card card) {
        return cardsInHand.contains(card);
    }

    public ArrayList<Card> selectCardsToPlay(ArrayList<Card> cards) {
        // To be replaced with GUI later

        System.out.println("Your cards: " + cards);

        Scanner scanner = new Scanner(System.in);
        ArrayList<Card> cardsToPlay = new ArrayList<>();

        for (int i = 0; i < cards.size(); i++) {
            System.out.print("Enter the index of the card to play (or 'q' to quit):");
            int input = scanner.nextInt();
        
            if (input >= 0 && input < cards.size()) {
                Card cardToPlay = new Card(cards.get(input).getRank(), cards.get(input).getSuit());
                cards.remove(input);
                cardsToPlay.add(cardToPlay);
                System.out.println(cardsToPlay);
            } else {
                System.out.println("Invalid index entered.");
            }
        }
        return cardsToPlay;
    }

    public void sortHand() {
        Collections.sort(cardsInHand, (card1, card2) -> Integer.compare(card1.getValue(), card2.getValue()));
    }

    // public static void main(String[] args) {
    //     Hand hand = new Hand();
    //     hand.addCard(new Card('a', 'h'));
    //     hand.addCard(new Card('2', 'h'));
    //     hand.addCard(new Card('3', 'h'));
    //     hand.addCard(new Card('4', 'h'));
    //     hand.addCard(new Card('5', 'h'));

    //     ArrayList<Card> cardsToPlay = hand.selectCardsToPlay(hand.getCardsInHand());

    //     System.out.println("Cards to play: " + cardsToPlay);
    // }
}
