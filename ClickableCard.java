import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ClickableCard extends JButton{

    private Card card;
    private JPanel curPanel;
    private JPanel toPanel;
    private JFrame gameFrame;

    public ClickableCard(JFrame gameFrame, Card card, JPanel curPanel, JPanel targetPanel){

        this.card = card;
        this.curPanel = curPanel;
        this.toPanel = targetPanel;
        this.gameFrame = gameFrame;

        JButton self = this;
        
        ImageComponent cardface = new ImageComponent(card.getImagePath());

        this.setIcon(cardface);

        this.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {    // adds the card to the other panel and removes itself
                curPanel.remove(self);
                toPanel.add(new ClickableCard(gameFrame, card, toPanel,  curPanel));

                curPanel.repaint();
                curPanel.revalidate();
                
                gameFrame.revalidate();
                gameFrame.setVisible(true);
            }
        });

        //make button invisible where card image is only shown
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setOpaque(false);
        this.setContentAreaFilled(false);
    }

    public Card getCard(){
        return card;
    }

}
