package cards;

import java.util.Collections;
import java.util.Stack;

import Card;

public class Deck {
    private Stack<Card> cards;

    public Deck() {
        this.cards = new Stack<>();
        initializeDeck();
    }

    private void initializeDeck() {
        char[] suits = {'d', 'c', 'h', 's'};
        char[] ranks = {'3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A', '2'};
        for (char suit : suits) {
            for (char rank : ranks) {
                cards.push(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card deal() {
        return cards.pop();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}

