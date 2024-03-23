import java.util.ArrayList;

// import players.Player;
// import utils.GameControl;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        
        GameControl gameControl = new GameControl();
        
        gameControl.startGame();
        
        // Hardcoded false for now
        boolean playAgain = false;
        if (playAgain) {
            main(args); // Restart the game by calling main again. 
        }
    }
}
