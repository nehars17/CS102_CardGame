package gui.components;

import controller.GameControl;
import gui.windows.GameScreen;

import javax.swing.*;
import java.awt.*;

/**
 * MiddleButtonPanel contains the buttons that allow the player to play or pass
 * their turn.
 */
public class MiddleButtonPanel extends JPanel {
    private JButton playButton;
    private JButton passButton;

    private final static Color backgroundColor = new Color(0x085318); // The color of the poker table

    /**
     * Constructs a MiddleButtonPanel, initializing its layout and background color.
     *
     * @param game       The game control logic.
     * @param gameFrame  The main game screen.
     * @param middlePile The panel representing the middle pile area.
     */
    public MiddleButtonPanel(GameControl game, GameScreen gameFrame, JPanel middlePile) {
        this.setLayout(new GridBagLayout());
        this.setBackground(backgroundColor);

        ToPlayArea playArea = (ToPlayArea) gameFrame.getBottomPanel().getToPlayArea();

        playButton = new PlayButton(game, middlePile, playArea, gameFrame);
        passButton = new PassButton(game, gameFrame);

        this.add(playButton);
        this.add(passButton);

    }

}
