

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class PassButton extends JButton{

    private JFrame gameFrame;

    private final Color buttonColor = Color.WHITE;
    private final String assetPath = "./images/pass.png";
    private final int imageHeight = 70;
    private final int imageWidth = 70;

    public PassButton( GameControl gameControl, GameScreen gameScreen){

        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameControl.playerPassTurn();
                // new WaitingScreen(gameScreen);
                gameScreen.updateToNextPlayer();
            }
        });

        this.setBackground(buttonColor);
        this.setIcon( new ImageComponent(assetPath, imageWidth, imageHeight));
        this.setBorder(BorderFactory.createEmptyBorder());
        // this.setOpaque(false);
        // this.setContentAreaFilled(false);

        
    }

}