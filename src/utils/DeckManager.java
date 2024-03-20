package utils;

import cards.Card;
import cards.Deck;

public class DeckManager {
    private Deck deck;

    public DeckManager() {
        this.deck = new Deck();
        deck.shuffle();
    }

    public Card dealCard() {
        if (deck.isEmpty()) {
            throw new IllegalStateException("No more cards to deal.");
        }
        return deck.deal();
    }
}

