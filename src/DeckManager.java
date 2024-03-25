// package utils;

// import Card;
// import Deck;

import java.util.Stack;

public class DeckManager {
    private Deck deck;

    public DeckManager() {
        this.deck = new Deck();
        deck.shuffle();
        // printDeck();
    }

    // public void printDeck() {
    //     Stack<Card> cards = deck.getCards();
    //     for (Card card : cards) {
    //         System.out.println(card);
    //     }
    // }

    public Card dealCard() {
        if (deck.isEmpty()) {
            throw new IllegalStateException("No more cards to deal.");
        }
        return deck.deal();
    }
    // public static void main(String[] args) {
    //     DeckManager deckManager = new DeckManager();
    // }
}

