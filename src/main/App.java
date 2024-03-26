package main;
import javax.swing.JFrame;

import controller.GameControl;
import gui.windows.StartFrame;

public class App {
    
    public static void main(String[] args) {
        GameControl game = new GameControl();
        // game.startGame();
    
        JFrame gameWindow = new StartFrame(game);
    }
}
