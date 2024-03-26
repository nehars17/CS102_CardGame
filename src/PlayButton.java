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
        this.setText("Play");
        this.setFont(new Font("Roboto", Font.BOLD, 20));
        this.setForeground(Color.RED);
        this.setIcon( new ImageComponent(assetPath, imageWidth , imageHeight));

        this.setHorizontalTextPosition(JButton.LEFT);
        this.setVerticalTextPosition(JButton.CENTER);
        this.setHorizontalAlignment(JButton.RIGHT);
        this.setVerticalAlignment(JButton.CENTER);

        this.setBackground(buttonColor);
        this.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        

        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // System.out.println(toPlayArea.getCards());
                // System.out.println(game.isPlayable(toPlayArea.getCards()));

                
                if ( game.isPlayable(toPlayArea.getCards()) ){

                    game.updateHand(toPlayArea.getCards());

                    if (game.checkGameOver()){
                        JOptionPane win = new WinningScreen(gameFrame); //generate winning window 
                    }

                    // JOptionPane transitionScreen = new WaitingScreen(gameFrame);
                    
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
                    new WaitingScreen(gameFrame);
                    gameFrame.setVisible(true);

                    
                }
                
            }
        });

    }

    
}