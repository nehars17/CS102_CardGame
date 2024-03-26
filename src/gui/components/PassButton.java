package gui.components;

import controller.GameControl;
import gui.windows.WaitingScreen;
import gui.windows.GameScreen;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * Represents a button allowing the player to pass their turn.
 */

public class PassButton extends JButton {

    private final Color buttonColor = Color.WHITE;
    private final String assetPath = "images/pass.png";
    private final int imageHeight = 70;
    private final int imageWidth = 70;

    /**
     * Constructs a PassButton, initializing its appearance and behavior.
     *
     * @param gameControl The game control logic.
     * @param gameScreen  The main game screen.
     */

    public PassButton(GameControl gameControl, GameScreen gameScreen) {

        /*
         * This action listener is responsible for passing the player's turn when the
         * button is clicked. It also updates the game screen to the next player.
         */

        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (gameControl.playerAllowedToPass() == false) {
                    return;
                }
                gameControl.playerPassTurn();
                new WaitingScreen(gameScreen);
                gameScreen.updateToNextPlayer();

            }
        });

        this.setText("Pass");
        this.setFont(new Font("Roboto", Font.BOLD, 20));
        this.setForeground(Color.RED);
        this.setIcon(new ImageComponent(assetPath, imageWidth, imageHeight));

        this.setHorizontalTextPosition(JButton.LEFT);
        this.setVerticalTextPosition(JButton.CENTER);
        this.setHorizontalAlignment(JButton.RIGHT);
        this.setVerticalAlignment(JButton.CENTER);

        this.setBackground(buttonColor);
        this.setBorder(BorderFactory.createRaisedSoftBevelBorder());
    }

}