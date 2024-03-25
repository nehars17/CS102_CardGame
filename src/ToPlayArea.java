
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.ArrayList.*;


public class ToPlayArea extends JPanel{
    private final static int hexColor = 0x085318; // The color of the poker table
    private final static Color backgroundColor = new Color(hexColor);
    
    public ToPlayArea(){
        this.setLayout(new GridBagLayout());
        this.setBackground(backgroundColor);
    }

    public ArrayList<Card> getCards(){ //get CARD obj from the clickable cards

        ArrayList<Card> cardsInPlayArea = new ArrayList<Card>();

        for (Component cardComp : this.getComponents()){

            ClickableCard cardButton = (ClickableCard)cardComp;
            cardsInPlayArea.add(cardButton.getCard());

        }

        return cardsInPlayArea;
    }
}
