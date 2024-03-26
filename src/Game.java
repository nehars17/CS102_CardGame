import java.util.List;
import java.util.ArrayList;


public class Game {
    private Player[] players;
    private DeckManager deckManager;
    private Player currentPlayer;
    private int numberOfPasses;
    private ArrayList<Card> lastPlayedCards; 

    public Game(Player[] players, DeckManager deckManager) {
        this.players = players;
        this.deckManager = deckManager;
        this.lastPlayedCards = new ArrayList<Card>();
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setLastPlayedCards(ArrayList<Card> lastPlayedCards) {
        this.lastPlayedCards = lastPlayedCards;
    }

    public ArrayList<Card> getLastPlayedCards() {
        return lastPlayedCards;
    }

    
    public void dealCards() {
        for (Player player : players) {
            for (int i = 0; i < 13; i++) {
                player.receiveCard(deckManager.dealCard());
            }
        }
    }
    
    public Player findStartingPlayer() {
        for (Player player : players) {
            if (hasThreeOfDiamonds(player.getCardsInHand())) {
                return player;
            }
        }
        throw new IllegalStateException("No player has the 3 of Diamonds.");
    }

    public boolean hasThreeOfDiamonds(ArrayList<Card> cardsInHand) {
        if (cardsInHand.stream().anyMatch(card -> card.getRank() == '3' && card.getSuit() == 'd')) {
            return true;
        }
        return false;
    }

    private int getCurrentPlayerIndex() {
        for (int i = 0; i < players.length; i++) {
            if (players[i].equals(currentPlayer)) {
                return i;
            }
        }
        throw new IllegalStateException("Current player is not in the players array.");
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isNewRound() {
        return lastPlayedCards.isEmpty();
    }

    public void nextPlayer(){
        int currentIndex = getCurrentPlayerIndex();
        System.out.println("Current index: " + currentIndex);
        currentPlayer = players[(currentIndex + 1) % players.length];
    }


    public void passTurn() {
        this.numberOfPasses++;
        nextPlayer();
    }

    public void removeCard(ArrayList<Card> cardsToPlay) {
        for (Card card : cardsToPlay) {
            currentPlayer.getCardsInHand().remove(card);
        }
        numberOfPasses = 0;
    }

    public void startNewRound() {
        lastPlayedCards.clear();
        numberOfPasses = 0;
    }

    public void showHand(Player player) {
        List<Card> hand = player.getCardsInHand();
        System.out.println(player.getPlayerId() + "'s hand: " + hand);
    }

    public boolean validateCardsToPlay(ArrayList<Card> cardsToPlay){
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

    public int getNumberOfPasses() {
        return numberOfPasses;
    }

    public boolean isGameOver() {
        return currentPlayer.getCardsInHand().isEmpty();
    }   


    public static void main(String[] args) {
        new Game(null, null);
    }

}