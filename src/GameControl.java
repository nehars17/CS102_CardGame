public class GameControl {
    private Player[] players;
    private DeckManager deckManager;
    private ScoreKeeper scoreKeeper;
    private InputHandler inputHandler;
    private Game game;

    public GameControl() {
        deckManager = new DeckManager();
        scoreKeeper = new ScoreKeeper();
        inputHandler = new InputHandler();
        players = new Player[4];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player("Player " + (i + 1));
        }
        scoreKeeper.initializeScores(players);
        game = new Game(players, deckManager, scoreKeeper);
    }

    public void startGame() {
        game.dealCards();
        Player startingPlayer = game.findStartingPlayer();
        game.startRound(startingPlayer);
    }

    public void play() {
        // Main game loop
        while (!game.isGameOver()) {
            Player currentPlayer = game.getCurrentPlayer();
            game.showHand(currentPlayer);
            String input = inputHandler.getNextLine();
            // Handle input and game logic
            // For now, we just pass the turn to the next player
            game.passTurn();
        }

        game.calculateFinalScores();
    }
}
