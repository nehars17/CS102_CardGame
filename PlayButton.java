
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.ArrayList.*;


public class PlayButton extends JButton{

    JFrame gameFrame;
    JPanel displayPanel;
    
    public PlayButton( GameControl game, JPanel displayPanel, ToPlayArea toPlayArea , GameScreen gameFrame ){

        this.gameFrame = gameFrame;
        this.displayPanel = displayPanel;

        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // System.out.println(toPlayArea.getCards());
                // System.out.println(game.isPlayable(toPlayArea.getCards()));

                if ( game.isPlayable(toPlayArea.getCards()) ){

                    if (game.checkGameOver()){
                        
                    }

                    game.updateHand(toPlayArea.getCards());
                    
                    ArrayList<DisplayCard> toadd = new ArrayList<DisplayCard>();
                    
                    for (Card card : toPlayArea.getCards()){
                        DisplayCard cardToAdd = new DisplayCard(card);
                        toadd.add(cardToAdd);
                    }
                    displayPanel.removeAll();
                    displayPanel.repaint();
                    
                    //grab cardface image and display
                    for (DisplayCard cardGraphic : toadd){
                        displayPanel.add(cardGraphic);
                    }

                    game.gotoNextPlayer();
                    gameFrame.updateToNextPlayer();

                    gameFrame.revalidate();
                    gameFrame.setVisible(true);

                    
                }
                
            }
        });

        this.add(new JLabel("Play"));

    }

    
}
