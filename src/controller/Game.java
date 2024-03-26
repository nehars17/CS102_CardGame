package controller;

import model.cards.Card;
import model.players.Player;
import utils.DeckManager;
import utils.combinations.Combinations;

import java.util.ArrayList;

/**
 * Manages the game logic for a Big Two card game. This includes managing
 * players, dealing cards,
 * tracking the current player, handling card plays and passes, and determining
 * the game state.
 */

public class Game {
    private Player[] players;
    private DeckManager deckManager;
    private Player currentPlayer;
    private int numberOfPasses;
    private ArrayList<Card> lastPlayedCards;

    /**
     * Constructs a Game instance with the provided set of players and a deck
     * manager.
     *
     * @param players     The players participating in the game.
     * @param deckManager The deck manager to handle card dealing and shuffling.
     */
    public Game(Player[] players, DeckManager deckManager) {
        this.players = players;
        this.deckManager = deckManager;
        this.lastPlayedCards = new ArrayList<Card>();
    }

    /**
     * Gets the current player.
     *
     * @return The current player.
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Sets the current player for the game.
     *
     * @param currentPlayer The player who is currently taking their turn.
     */
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    /**
     * Gets the cards last played on the table.
     *
     * @return An ArrayList of the cards last played.
     */
    public ArrayList<Card> getLastPlayedCards() {
        return lastPlayedCards;
    }

    /**
     * Sets the cards last played on the table.
     *
     * @param lastPlayedCards The cards last played in the game.
     */
    public void setLastPlayedCards(ArrayList<Card> lastPlayedCards) {
        this.lastPlayedCards = lastPlayedCards;
    }

    /**
     * Retrieves the number of consecutive passes by the players. This can be used
     * to determine
     * if a new round should start.
     *
     * @return The number of consecutive passes.
     */
    public int getNumberOfPasses() {
        return numberOfPasses;
    }

    /**
     * Retrieves the index of the current player in the players array.
     *
     * @return The index of the current player.
     */
    private int getCurrentPlayerIndex() {
        for (int i = 0; i < players.length; i++) {
            if (players[i].equals(currentPlayer)) {
                return i;
            }
        }
        throw new IllegalStateException("Current player is not in the players array.");
    }

    /**
     * Deals 13 cards to each player from the deck.
     */
    public void dealCards() {
        for (Player player : players) {
            for (int i = 0; i < 13; i++) {
                player.receiveCard(deckManager.dealCard());
            }
        }
    }

    /**
     * Sorts the hand of a specified player.
     *
     * @param player The player whose hand is to be sorted.
     */
    public void sortHand(Player player) {
        if (player != null && player.getCardsInHand() != null) {
            player.getCardsInHand().sort(null);
        } else {
            System.err.println("Player or player's hand is null.");
        }
    }

    /**
     * Finds the player who has the three of diamonds.
     *
     * @return The player who starts the game.
     */
    public Player findStartingPlayer() {
        for (Player player : players) {
            if (hasThreeOfDiamonds(player.getCardsInHand())) {
                return player;
            }
        }
        throw new IllegalStateException("No player has the 3 of Diamonds.");
    }

    /**
     * Checks if a hand contains the three of diamonds.
     *
     * @param cardsInHand The hand to check.
     * @return True if the hand contains the three of diamonds, false otherwise.
     */
    public boolean hasThreeOfDiamonds(ArrayList<Card> cardsInHand) {
        if (cardsInHand.stream().anyMatch(card -> card.getRank() == '3' && card.getSuit() == 'd')) {
            return true;
        }
        return false;
    }

    /**
     * Checks if a new round has started.
     *
     * @return True if it is a new round, false otherwise.
     */
    public boolean isNewRound() {
        return lastPlayedCards.isEmpty();
    }

    /**
     * Advances to the next player in the game.
     */
    public void nextPlayer() {
        int currentIndex = getCurrentPlayerIndex();
        currentPlayer = players[(currentIndex + 1) % players.length];
    }

    /**
     * Passes the turn to the next player and increments the pass count.
     */
    public void passTurn() {
        this.numberOfPasses++;
        nextPlayer();
    }

    /**
     * Removes a set of cards from the current player's hand, typically those that
     * have been played.
     * Also resets the pass count and updates the last played cards if the move is
     * valid.
     *
     * @param cardsToPlay The cards that the current player has decided to play.
     */
    public void removeCard(ArrayList<Card> cardsToPlay) {
        for (Card card : cardsToPlay) {
            currentPlayer.getCardsInHand().remove(card);
        }
        numberOfPasses = 0;
    }

    /**
     * Starts a new round in the game. This involves clearing the last played cards
     * and resetting
     * the number of passes to zero.
     */
    public void startNewRound() {
        lastPlayedCards.clear();
        numberOfPasses = 0;
    }

    /**
     * Validates the set of cards the current player wishes to play against the game
     * rules and the
     * last played cards. It checks if the move is legal in the context of the game
     * state.
     *
     * @param cardsToPlay The set of cards the player wishes to play.
     * @return True if the move is valid, false otherwise.
     */
    public boolean validateCardsToPlay(ArrayList<Card> cardsToPlay) {
        if (hasThreeOfDiamonds(currentPlayer.getCardsInHand())) {
            if (!hasThreeOfDiamonds(cardsToPlay)) {
                return false;
            }
        }

        Combinations combinations = new Combinations(cardsToPlay);

        if (!combinations.validateCards(cardsToPlay, lastPlayedCards)) {
            return false;
        }
        return combinations.checkCombinationIsGreaterThan(cardsToPlay, lastPlayedCards);
    }

    /**
     * Checks if the game is over, which occurs when the current player has no more
     * cards in hand.
     *
     * @return True if the game is over, false otherwise.
     */
    public boolean isGameOver() {
        return currentPlayer.getCardsInHand().isEmpty();
    }
}