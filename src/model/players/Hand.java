package model.players;

import model.cards.Card;

import java.util.ArrayList;

/**
 * Represents a player's hand in the Big Two card game.
 * It holds the cards that a player has and manages the cards that the player intends to play.
 */

public class Hand {
    private ArrayList<Card> cardsInHand;
    private ArrayList<Card> cardsToPlay;

    /**
     * Constructs a Hand instance initializing the list of cards in hand.
     * The list of cards to play is initialized only when needed.
     */
    public Hand() {
        this.cardsInHand = new ArrayList<>();
    }

    /**
     * Retrieves the cards the player intends to play.
     *
     * @return A list of cards to play.
     */
    public ArrayList<Card> getCardsToPlay() {
        return cardsToPlay;
    }

    /**
     * Retrieves the cards currently in the player's hand.
     *
     * @return A list of cards in hand.
     */
    public ArrayList<Card> getCardsInHand() {
        return cardsInHand;
    }

    /**
     * Adds a card to the player's hand.
     *
     * @param card The card to be added to the hand.
     */
    public void addCard(Card card) {
        cardsInHand.add(card);
    }
}