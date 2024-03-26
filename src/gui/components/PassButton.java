package gui.components;

import controller.GameControl;
import gui.windows.WaitingScreen;
import gui.windows.GameScreen;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class PassButton extends JButton {

    private final Color buttonColor = Color.WHITE;
    private final String assetPath = "images/pass.png";
    private final int imageHeight = 70;
    private final int imageWidth = 70;

    public PassButton(GameControl gameControl, GameScreen gameScreen) {

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