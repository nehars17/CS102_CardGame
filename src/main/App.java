package main;

import controller.GameControl;
import gui.windows.StartFrame;

/**
 * The main class of the application that serves as the entry point.
 * Initializes the game control logic and displays the starting frame of the GUI.
 */

public class App {

    public static void main(String[] args) {
        // Initialize the game control, which manages the game logic.
        GameControl game = new GameControl();

        // Display the starting frame of the game.
        new StartFrame(game);
    }
}
