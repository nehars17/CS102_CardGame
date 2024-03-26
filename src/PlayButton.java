
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.ArrayList.*;


public class PlayButton extends JButton{

    private JFrame gameFrame;
    private JPanel displayPanel;
    private final Color buttonColor = Color.WHITE;
    private final String assetPath = "./images/playcards.jpg";
    private final int imageHeight = 70;
    private final int imageWidth = 70;


    
    public PlayButton( GameControl game, JPanel displayPanel, ToPlayArea toPlayArea , GameScreen gameFrame ){

        this.gameFrame = gameFrame;
        this.displayPanel = displayPanel;
        this.setBackground(buttonColor);
        this.setIcon( new ImageComponent(assetPath, imageWidth , imageHeight));
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setOpaque(false);
        this.setContentAreaFilled(false);

        

        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // System.out.println(toPlayArea.getCards());
                // System.out.println(game.isPlayable(toPlayArea.getCards()));

                
                if ( game.isPlayable(toPlayArea.getCards()) ){

                    if (game.checkGameOver()){
                        JOptionPane win = new WinningScreen(gameFrame); //generate winning window 
                    }else{
                        new WaitingScreen(gameFrame);
                    }

                    // JOptionPane transitionScreen = new WaitingScreen(gameFrame);

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

    }

    
}
