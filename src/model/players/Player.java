package model.players;

import model.cards.Card;

import java.util.ArrayList;

/**
 * Represents a player in the Big Two card game. Each player has a unique
 * identifier
 * and a hand of cards.
 */

public class Player {
    private int playerId;
    private Hand hand;

    /**
     * Constructs a new player with the specified player ID, which will be 1, 2, 3,
     * or 4.
     *
     * @param playerId The unique identifier for this player.
     */
    public Player(int playerId) {
        this.playerId = playerId;
        this.hand = new Hand();
    }

    /**
     * Adds a received card to the player's hand.
     *
     * @param card The card to add to the hand.
     */
    public void receiveCard(Card card) {
        hand.addCard(card);
    }

    /**
     * Plays a list of cards from the player's hand, removing them from the current
     * hand.
     *
     * @param cardsToPlay The list of cards to be played and removed from the hand.
     */
    public void playCard(ArrayList<Card> cardsToPlay) {
        for (Card card : cardsToPlay) {
            hand.getCardsInHand().remove(card);
        }
    }

    /**
     * Retrieves the cards currently in the player's hand.
     *
     * @return An ArrayList of cards in the player's hand.
     */
    public ArrayList<Card> getCardsInHand() {
        return hand.getCardsInHand();
    }

    /**
     * Retrieves the cards currently in the player's hand.
     *
     * @return An ArrayList of cards in the player's hand.
     */
    public int getPlayerId() {
        return playerId;
    }
}