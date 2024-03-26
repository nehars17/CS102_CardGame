package gui.components;

import controller.GameControl;
import gui.windows.GameScreen;

import javax.swing.*;
import java.awt.*;

public class MiddleButtonPanel extends JPanel {

    private JButton playButton;
    private JButton passButton;

    private final static int hexColor = 0x085318; // The color of the poker table
    private final static Color backgroundColor = new Color(hexColor);

    public MiddleButtonPanel(GameControl game, GameScreen gameFrame, JPanel middlePile) {
        this.setLayout(new GridBagLayout());
        this.setBackground(backgroundColor);

        ToPlayArea playArea = (ToPlayArea) gameFrame.getBottomPanel().getToPlayArea();

        playButton = new PlayButton(game, middlePile, playArea, gameFrame);
        passButton = new PassButton(game, gameFrame);

        this.add(playButton);
        this.add(passButton);

    }

    // public static void main(String[] args) {
    // GameControl gc = new GameControl();
    // new MiddleButtonPanel(gc, new GameScreen(gc), new JPanel());
    // }

}
