package model.cards;

import java.util.Collections;
import java.util.Stack;

/**
 * Represents a deck of playing cards used in the Big Two game.
 * It supports operations like initializing, shuffling, dealing, and checking if
 * the deck is empty.
 */

public class Deck {
    private Stack<Card> cards;

    /**
     * Constructs a new deck and initializes it with cards.
     */
    public Deck() {
        this.cards = new Stack<>();
        initializeDeck();
    }

    /**
     * Initializes the deck with a standard set of Big Two cards.
     */
    private void initializeDeck() {
        char[] suits = { 'd', 'c', 'h', 's' };
        char[] ranks = { '3', '4', '5', '6', '7', '8', '9', 't', 'j', 'q', 'k', 'a', '2' };
        for (char suit : suits) {
            for (char rank : ranks) {
                cards.push(new Card(rank, suit));
            }
        }
    }

    /**
     * Returns the cards in the deck.
     *
     * @return The cards in the deck.
     */
    public Stack<Card> getCards() {
        return cards;
    }

    /**
     * Shuffles the deck, randomizing the order of the cards.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Deals the top card from the deck.
     *
     * @return The card dealt from the top of the deck.
     */
    public Card deal() {
        return cards.pop();
    }

    /**
     * Checks if the deck is empty.
     *
     * @return True if the deck has no more cards to deal, false otherwise.
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
