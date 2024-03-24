import java.util.List;
import java.util.ArrayList;


public class Game {
    private Player[] players;
    private DeckManager deckManager;
    private ScoreKeeper scoreKeeper;
    private Player currentPlayer;
    private int numberOfPasses;
    private ArrayList<Card> lastPlayedCards; 

    public Game(Player[] players, DeckManager deckManager, ScoreKeeper scoreKeeper) {
        this.players = players;
        this.deckManager = deckManager;
        this.scoreKeeper = scoreKeeper;
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
            if (player.getCardsInHand().stream()
            .anyMatch(card -> card.getRank() == '3' && card.getSuit() == 'd')) {
                return player;
            }
        }
        throw new IllegalStateException("No player has the 3 of Diamonds.");
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

    // public void startRound(Player startingPlayer) {
    //     currentPlayer = startingPlayer;
    // }

    public void nextPlayer(){
        int currentIndex = getCurrentPlayerIndex();
        currentPlayer = players[(currentIndex + 1) % players.length];
    }


    public void passTurn() {
        this.numberOfPasses++;
        int currentIndex = getCurrentPlayerIndex();
        currentPlayer = players[(currentIndex + 1) % players.length];
    }

    public void removeCard(ArrayList<Card> cardsToPlay) {
        for (Card card : cardsToPlay) {
            currentPlayer.getCardsInHand().remove(card);
        }
    }

    public void startNewRound() {
        lastPlayedCards.clear();
    }

    public void showHand(Player player) {
        List<Card> hand = player.getCardsInHand();
        System.out.println(player.getPlayerId() + "'s hand: " + hand);
    }

    public boolean validateCardsToPlay(ArrayList<Card> cardsToPlay){
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

    public void calculateFinalScores() {
        for (Player player : players) {
            int penalty = calculatePenalty(player);
            player.addPenaltyPoints(penalty);
            scoreKeeper.updateScore(player, penalty);
        }
    }

    private int calculatePenalty(Player player) {
        int cardCount = player.getCardsInHand().size();
        if (cardCount == 13) {
            return 39; // Did not play at all
        }
        if (cardCount > 9) {
            return cardCount * 2;
        }
        return cardCount;
    }

    public static void main(String[] args) {
        new Game(null, null, null);
    }

}