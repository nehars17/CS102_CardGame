package gui.components;

import model.cards.Card;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Represents the area where the player's cards are displayed.
 */

public class ToPlayArea extends JPanel {
    private final static int hexColor = 0x085318; // The color of the poker table
    private final static Color backgroundColor = new Color(hexColor);

    /**
     * Constructs a ToPlayArea, initializing its layout and background color.
     */
    public ToPlayArea() {
        this.setLayout(new GridBagLayout());
        this.setBackground(backgroundColor);
    }

    /**
     * Adds a card to the playing area.
     *
     * @param card The card to be added.
     */
    public ArrayList<Card> getCards() { // get CARD obj from the clickable cards

        ArrayList<Card> cardsInPlayArea = new ArrayList<Card>();

        for (Component cardComp : this.getComponents()) {
            ClickableCard cardButton = (ClickableCard) cardComp;
            cardsInPlayArea.add(cardButton.getCard());
        }

        return cardsInPlayArea;
    }
}
