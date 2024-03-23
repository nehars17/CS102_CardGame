import javax.swing.Action;
import javax.swing.SwingUtilities;

public class GameControl {
    private Player[] players;
    private DeckManager deckManager;
    private ScoreKeeper scoreKeeper;
    private Game game;

    private GameScreen gameScreen;

    public GameControl() {
        deckManager = new DeckManager();
        scoreKeeper = new ScoreKeeper();
        players = new Player[4];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player("Player " + (i + 1));
        }
        scoreKeeper.initializeScores(players);
        game = new Game(players, deckManager, scoreKeeper);

    }

    public Player startGame() {
        game.dealCards();

        Player startingPlayer = game.findStartingPlayer();
        game.startRound(startingPlayer);
        return startingPlayer;
    }

    public Player passTurn() {
        game.passTurn();
        updateGUI();
    }

    public void play() {
        boolean gameInProgress = true;

        while (gameInProgress) {
            Player currentPlayer = game.getCurrentPlayer();
            game.showHand(currentPlayer); // This will eventually be replaced by GUI updates

            // Get the player's action. This could be through GUI input in the future.
            Action action = inputHandler.getPlayerAction(currentPlayer);

            if (action.type == ActionType.PLAY) {
                boolean success = game.attemptPlay(currentPlayer, action.cardsToPlay);
                if (success) {
                    // Update game state based on the successful play
                    // For example, clearing the pass counter if needed
                    game.updateStack(action.cardsToPlay);
                } else {
                    // Handle invalid play attempt (notify player, request another action)
                }
            } else if (action.type == ActionType.PASS) {
                game.passTurn();
                // Update GUI to reflect the pass
                // Check if the pass causes control to change, etc.
            }

            // Check if the current player has won
            if (game.isGameOver()) {
                gameInProgress = false;
                game.calculateFinalScores();
                // Handle end of game, such as displaying final scores and determining if a new
                // game starts
            } else {
                // Update the GUI with the new game state, such as the next player's turn
                game.setToNextPlayer();
            }
        }
    }

}
