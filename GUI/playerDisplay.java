import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.event.*;


public class playerDisplay {
    
    // public void updatePlayerHand( JFrame gameWindow){
        
    // }

    private static ImageIcon loadCardImage( String cardName){
        ImageIcon cardFace = null;
        try{
            File cardImageFile = new File(cardName);
            BufferedImage loadedImage = ImageIO.read(cardImageFile);
            cardFace = new ImageIcon(loadedImage);
        }catch( Exception e){
            e.printStackTrace();
        }
        return cardFace;
    }

    private static JButton createClickableCard(JFrame gameWindow, String cardName, JPanel toPanel, JPanel curPanel){
        JButton clickableCard = new JButton();
        clickableCard.setIcon(loadCardImage(cardName));

        clickableCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                curPanel.remove(clickableCard);
                toPanel.add(createClickableCard(gameWindow, cardName, toPanel, curPanel));

                if (curPanel.getComponentCount() == 0){
                   curPanel.repaint();
                }

                gameWindow.revalidate();
                gameWindow.setVisible(true);
            }
        });

        //make button invisible where card image is only shown
        clickableCard.setBorder(BorderFactory.createEmptyBorder());
        clickableCard.setOpaque(false);
        clickableCard.setContentAreaFilled(false);

        return clickableCard;
    }

    private static  JButton createSubmitButton (JFrame gameWindow, JPanel centrePanel, JPanel playedCards){

        JButton submitButton = new JButton();

        submitButton.addActionListener(new ActionListener() {  /// copy images from panel, put inside tocopy panel, refresh displaypanel
            public void actionPerformed(ActionEvent e) {

                if (playedCards.getComponentCount() != 0 ){

                    //grab cardface image and display
                    for (Component card : playedCards.getComponents()){
                        JButton button = (JButton)card;
                        ImageIcon cardface = (ImageIcon)button.getIcon();
                        centrePanel.add(new JLabel(cardface));
                    }
                }
    
                gameWindow.revalidate();
                gameWindow.setVisible(true);
            }
        });

        return submitButton;
    }


}
