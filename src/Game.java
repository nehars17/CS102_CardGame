
import java.util.List;
import java.util.ArrayList;


public class Game {
    private Player[] players;
    private DeckManager deckManager;
    private ScoreKeeper scoreKeeper;
    private Player currentPlayer;
    private int numberOfPasses;
    private ArrayList<Card> combinationsStack; // Something to keep track of the last played combination

    public Game(Player[] players, DeckManager deckManager, ScoreKeeper scoreKeeper) {
        this.players = players;
        this.deckManager = deckManager;
        this.scoreKeeper = scoreKeeper;
        this.combinationsStack = new ArrayList<Card>();
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

    public void startRound(Player startingPlayer) {
        currentPlayer = startingPlayer;
    }

    public void showHand(Player player) {
        List<Card> hand = player.getCardsInHand();
        System.out.println(player.getName() + "'s hand: " + hand);
    }

    private int getCurrentPlayerIndex() {
        for (int i = 0; i < players.length; i++) {
            if (players[i].equals(currentPlayer)) {
                return i;
            }
        }
        throw new IllegalStateException("Current player is not in the players array.");
    }

    public void passTurn() {
        int currentIndex = getCurrentPlayerIndex();
        currentPlayer = players[(currentIndex + 1) % players.length];
        this.numberOfPasses++;
    }

    public int getNumberOfPasses() {
        return numberOfPasses;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
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

}
