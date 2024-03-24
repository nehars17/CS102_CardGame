import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class GameControl {
    private Player[] players;
    private DeckManager deckManager;
    private ScoreKeeper scoreKeeper;
    private Game game;

    public GameControl() {
        deckManager = new DeckManager();

        scoreKeeper = new ScoreKeeper();
        scoreKeeper.initializeScores(players);

        players = new Player[4];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(i + 1);
        }
        
        game = new Game(players, deckManager, scoreKeeper);
    }

    public void startGame() {
        game.dealCards();
        game.setCurrentPlayer(game.findStartingPlayer());
    }

    public int getCurrentPlayer() {
        return game.getCurrentPlayer().getPlayerId();
    }

    public void playerPassTurn() {
        game.passTurn();
        if (game.getNumberOfPasses() == 3) {
            game.startNewRound();
        }
    }

    public ArrayList<Card> getCurrrentPlayerHand(){
        return game.getCurrentPlayer().getCardsInHand();
    }

    public Map<Integer, Integer> getSizeOfPlayersHand(){
        Map<Integer, Integer> sizeOfPlayersHand = new HashMap<>();
        for (Player player : players) {
            sizeOfPlayersHand.put(player.getPlayerId(), player.getCardsInHand().size());
        }
        return sizeOfPlayersHand;
    }   

    public void updateHand(ArrayList<Card> cardsToRemove) {
        game.removeCard(cardsToRemove);
        game.setLastPlayedCards(cardsToRemove);
    }

    public boolean isPlayable(ArrayList<Card> cardsToPlay) {
        return game.validateCardsToPlay(cardsToPlay);
    }

    public ArrayList<Card> getPreviousPlayedCards(){
        return game.getLastPlayedCards();
    }

    public boolean checkGameOver() {
        return game.isGameOver();
    }

}