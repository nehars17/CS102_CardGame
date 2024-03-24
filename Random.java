import java.util.ArrayList;

public class GameControl {
    private Player[] players;
    private DeckManager deckManager;
    private ScoreKeeper scoreKeeper;
    private Game game;
    private IGameView gameView; // Interface for the GUI

    public GameControl(IGameView gameView) {
        this.gameView = gameView;
        this.deckManager = new DeckManager();
        this.players = new Player[4];
        // You should initialize players before passing them to ScoreKeeper.
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player("Player " + (i + 1));
        }

        this.scoreKeeper = new ScoreKeeper();
        this.scoreKeeper.initializeScores(players);
        this.game = new Game(players, deckManager, scoreKeeper);
    }

    public void startGame() {
        game.dealCards();
        for (Player player : players) {
            // Update the GUI with the hands for each player.
            gameView.updatePlayerHand(player.getName(), player.getCardsInHand());
        }

        Player startingPlayer = game.findStartingPlayer();
        game.setCurrentPlayer(startingPlayer); // You need to set the starting player as the current player.
        gameView.setActivePlayer(startingPlayer.getName());
        // The game view can now allow the starting player to play their cards.
    }

    public void playerPlaysCards(Player player, ArrayList<Card> cardsToPlay) {
        if (isPlayable(cardsToPlay)) {
            game.playCards(player, cardsToPlay);
            gameView.updatePlayerHand(player.getName(), player.getCardsInHand());
            gameView.displayPlayedCards(cardsToPlay);

            // Check if the game is over
            if (game.isGameOver()) {
                game.calculateFinalScores();
                gameView.displayWinner(player.getName());
                gameView.updateScores(scoreKeeper.getScores()); // Assumes a method to get all scores.
                return;
            }

            // If game not over, pass turn to the next player
            passTurn();
        } else {
            gameView.displayMessage("Invalid move. Try again.");
        }
    }

    public void passTurn() {
        Player nextPlayer = game.passTurn();
        gameView.setActivePlayer(nextPlayer.getName());
        // The game view can now allow the next player to play their cards.
    }

    private boolean isPlayable(ArrayList<Card> cardsToPlay) {
        Combinations combinations = new Combinations(cardsToPlay);
        return combinations.isValid(cardsToPlay) && combinations.isGreaterThan(game.getLastPlayedCards());
    }
}
 ÷≥