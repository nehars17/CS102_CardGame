package gui.components;

import gui.windows.WaitingScreen;
import gui.windows.WinningScreen;
import gui.windows.GameScreen;
import controller.GameControl;
import model.cards.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Represents the button that allows the player to play their cards.
 */

public class PlayButton extends JButton {

    private final Color buttonColor = Color.WHITE;
    private final String assetPath = "images/playcards.jpg";
    private final int imageHeight = 70;
    private final int imageWidth = 70;
    private ToPlayArea toPlayArea;
    private JPanel displayPanel;

    /**
     * Constructs a PlayButton, initializing its appearance and behavior.
     *
     * @param game        The game control logic.
     * @param displayPanel The panel representing the middle pile area.
     * @param toPlayArea  The panel representing the area where the player's cards are
     *                    displayed.
     * @param gameFrame   The main game screen.
     */

    public PlayButton(GameControl game, JPanel displayPanel, ToPlayArea toPlayArea, GameScreen gameFrame) {

        this.displayPanel = displayPanel;
        this.toPlayArea = toPlayArea;

        this.setText("Play");
        this.setFont(new Font("Roboto", Font.BOLD, 20));
        this.setForeground(Color.RED);
        this.setIcon(new ImageComponent(assetPath, imageWidth, imageHeight));

        this.setHorizontalTextPosition(JButton.LEFT);
        this.setVerticalTextPosition(JButton.CENTER);
        this.setHorizontalAlignment(JButton.RIGHT);
        this.setVerticalAlignment(JButton.CENTER);

        this.setBackground(buttonColor);
        this.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        /* 
         * Actionlistener checks for the state of the play button being pressed
         * Implements the logic of the game and the corresponding necessary GUI updating 
         * 
         */

        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (game.isPlayable(toPlayArea.getCards())) {

                    game.updateHand(toPlayArea.getCards());

                    if (game.checkGameOver()) {
                        new WinningScreen(gameFrame); // generate winning window
                        return;
                    }

                    updateMiddlePile();

                    game.gotoNextPlayer();
                    gameFrame.updateToNextPlayer();

                    gameFrame.revalidate();
                    new WaitingScreen(gameFrame);
                    gameFrame.setVisible(true);

                }

            }
        });
    }

    private void updateMiddlePile(){
        ArrayList<DisplayCard> toadd = new ArrayList<DisplayCard>();

        for (Card card : toPlayArea.getCards()) {
            DisplayCard cardToAdd = new DisplayCard(card);
            toadd.add(cardToAdd);
        }
        displayPanel.removeAll();
        displayPanel.repaint();

        for (DisplayCard cardGraphic : toadd) {
            displayPanel.add(cardGraphic);
        }
    }
}