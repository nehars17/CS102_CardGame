package utils;

import model.cards.Card;
import model.cards.Deck;

/**
 * Manages the deck operations for a game of Big Two, including shuffling and dealing cards.
 */

public class DeckManager {
    private Deck deck;

    /**
     * Constructs a DeckManager and initializes the deck with cards.
     * The deck is shuffled upon creation.
     */
    public DeckManager() {
        this.deck = new Deck();
        deck.shuffle();
    }

    /**
     * Deals a single card from the deck.
     *
     * @return The card dealt from the deck.
     * @throws IllegalStateException if there are no more cards to deal.
     */
    public Card dealCard() {
        if (deck.isEmpty()) {
            System.out.println("No more cards to deal.");
        }
        return deck.deal();
    }
}
