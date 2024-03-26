package model.players;
import java.util.ArrayList;

import model.cards.Card;

public class Hand {
    private ArrayList<Card> cardsInHand;
    private ArrayList<Card> cardsToPlay;
    private final static int hexColor = 0x085318; // The color of the poker table

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

    public boolean hasCard(Card card) {
        return cardsInHand.contains(card);
    }
}