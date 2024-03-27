package gui.panels;

import controller.GameControl;
import gui.components.MiddleButtonPanel;
import gui.windows.GameScreen;

import javax.swing.*;
import java.awt.*;

/**
 * MiddlePanel serves as a container for the central gameplay elements, 
 * including the area where cards are played ("middle pile") and action buttons.
 */
public class MiddlePanel extends JPanel {

    private MiddleButtonPanel buttonPanel;
    private JPanel middlePile;
    private static final Color BACKGROUND_COLOR = new Color(0x085318); // Color of the poker table as the background

    /**
     * Constructs a MiddlePanel, setting up its sub-components and layout.
     *
     * @param game The game control logic.
     * @param gameScreen The main game screen, used for callbacks and updates.
     */
    public MiddlePanel(GameControl game, GameScreen gameScreen) {
        initializeMiddlePile();
        initializeButtonPanel(game, gameScreen);

        this.setLayout(new GridLayout(2, 1)); // Arrange sub-components vertically
        this.add(middlePile);
        this.add(buttonPanel);
    }

    /**
     * Initializes the middle pile area, setting its layout and background.
     */
    private void initializeMiddlePile() {
        middlePile = new JPanel(new GridBagLayout());
        middlePile.setBackground(BACKGROUND_COLOR);
        
        // Placeholder panel for visual consistency when empty
        JPanel whileEmpty = new JPanel();
        whileEmpty.setBackground(BACKGROUND_COLOR);
        middlePile.add(whileEmpty); // Adding an empty panel for initial state
    }

    /**
     * Initializes the panel containing action buttons related to game operations.
     *
     * @param game The game control logic.
     * @param gameScreen The main game screen.
     */
    private void initializeButtonPanel(GameControl game, GameScreen gameScreen) {
        buttonPanel = new MiddleButtonPanel(game, gameScreen, middlePile);
    }


    /*
     *  Used to update panel when new round begins.
     */
    public JPanel getMiddlePile(){
        return middlePile;
    }
}