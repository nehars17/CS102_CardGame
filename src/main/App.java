package main;

import controller.GameControl;
import gui.windows.StartFrame;

public class App {
    
    public static void main(String[] args) {
        GameControl game = new GameControl();
    
        new StartFrame(game);
    }
}
