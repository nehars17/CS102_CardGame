import javax.swing.JFrame;

public class App {
    
    public static void main(String[] args) {
        GameControl game = new GameControl();
        // game.startGame();
    
        JFrame gameWindow = new StartFrame(game);
    }
}
