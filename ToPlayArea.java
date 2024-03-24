
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.ArrayList.*;


public class ToPlayArea extends JPanel{
    
    public ToPlayArea(){
        this.setLayout(new GridBagLayout());
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
