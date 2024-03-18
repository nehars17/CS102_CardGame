

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Alice"));
        players.add(new Player("Bob"));
        players.add(new Player("Charlie"));
        players.add(new Player("Dana"));
        
        GameControl gameControl = new GameControl();
        
        gameControl.startGame();
        
        // Hardcoded false for now
        boolean playAgain = false;
        if (playAgain) {
            main(args); // Restart the game by calling main again. 
        }
    }
}
