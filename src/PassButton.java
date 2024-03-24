

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class PassButton extends JButton{

    JFrame gameFrame;

    public PassButton( GameControl gameControl, GameScreen gameScreen){

        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameControl.playerPassTurn();
                gameScreen.updateToNextPlayer();
            }
        });

        this.add(new JLabel("Pass"));
    }

}