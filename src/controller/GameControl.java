package controller;

import model.cards.Card;
import model.players.Player;
import utils.DeckManager;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Controls the flow and rules of the Big Two card game.
 * This class initializes the game, deals cards, and manages player turns.
 */

public class GameControl {
    private Player[] players;
    private DeckManager deckManager;
    private Game game;

    /**
     * Initializes a new game control, setting up the deck manager, players,
     * and the game instance.
     */
    public GameControl() {
        deckManager = new DeckManager();
        players = new Player[4];

        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(i + 1);
        }

        game = new Game(players, deckManager);
    }

    /**
     * Starts the game by dealing cards to players, sorting their hands,
     * and determining the starting player.
     */
    public void startGame() {
        game.dealCards();
        for (Player player : players) {
            game.sortHand(player);
        }
        game.setCurrentPlayer(game.findStartingPlayer());
    }

    /**
     * Gets the ID of the current player.
     *
     * @return The current player's ID.
     */
    public int getCurrentPlayer() {
        return game.getCurrentPlayer().getPlayerId();
    }

    /**
     * Checks if the current player is allowed to pass their turn.
     *
     * @return True if passing is allowed, false otherwise.
     */
    public boolean playerAllowedToPass() {
        return game.getNumberOfPasses() < 3 && !game.isNewRound();
    }

    /**
     * Handles the action of the current player passing their turn.
     */
    public void playerPassTurn() {
        if (playerAllowedToPass()) {
            game.passTurn();
        }
        if (game.getNumberOfPasses() == 3) {
            game.startNewRound();
        }

    }

    /**
     * Retrieves the hand of the current player.
     *
     * @return The current player's hand as an ArrayList of Cards.
     */
    public ArrayList<Card> getCurrentPlayerHand() {
        return game.getCurrentPlayer().getCardsInHand();
    }

    /**
     * Gets the size of each player's hand.
     *
     * @return A HashMap with player IDs as keys and the size of their hand as
     *         values.
     */
    public HashMap<Integer, Integer> getSizeOfPlayersHand() {
        HashMap<Integer, Integer> sizeOfPlayersHand = new HashMap<>();
        for (Player player : players) {
            sizeOfPlayersHand.put(player.getPlayerId(), player.getCardsInHand().size());
        }
        return sizeOfPlayersHand;
    }

    /**
     * Updates the hand of the current player by removing played cards and setting
     * the last played cards.
     *
     * @param cardsToRemove The cards to be removed from the current player's hand.
     */
    public void updateHand(ArrayList<Card> cardsToRemove) {
        game.removeCard(cardsToRemove);
        game.setLastPlayedCards(cardsToRemove);
    }

    /**
     * Validates whether the cards selected by the current player can be legally
     * played.
     *
     * @param cardsToPlay The cards the current player wishes to play.
     * @return True if the play is legal, false otherwise.
     */
    public boolean isPlayable(ArrayList<Card> cardsToPlay) {
        return game.validateCardsToPlay(cardsToPlay);
    }

    /**
     * Retrieves the cards played in the previous turn.
     *
     * @return An ArrayList of Cards that were last played.
     */
    public ArrayList<Card> getPreviousPlayedCards() {
        return game.getLastPlayedCards();
    }

    /**
     * Checks if the game has ended.
     *
     * @return True if the game is over, false otherwise.
     */
    public boolean checkGameOver() {
        return game.isGameOver();
    }

    /**
     * Advances the game to the next player's turn.
     */
    public void gotoNextPlayer() {
        game.nextPlayer();
    }

}