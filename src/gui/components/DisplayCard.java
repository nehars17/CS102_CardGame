package gui.components;

import model.cards.Card;

import javax.swing.*;

/**
 * Represents a card image displayed in the game.
 */

public class DisplayCard extends JLabel {
    private static final String cardBackPath = "images/cardassets/cardback.png";
    private static final int cardBackWidth = 71;
    private static final int cardBackHeight = 103;
    private static final int sideCardBackWidth = 50;
    private static final int sideCardBackHeight = 73;

    /**
     * Constructs a DisplayCard component with the specified card.
     *
     * @param card The card object to display.
     */
    public DisplayCard(Card card) {
        super(new ImageComponent(card.getImagePath()));
    }

    /**
     * Constructs a DisplayCard component with the back of a card.
     */
    public DisplayCard() {
        super(new ImageComponent(cardBackPath, cardBackWidth, cardBackHeight));
    }

    /**
     * Returns a  ImageComponent with the specified card. Used specifically to add to rotated panels
     *
     * @param card The card object to display.
     * @return A ImageComponent with the specified card.
     */
    public static ImageComponent getCardBack() {
        return new ImageComponent(cardBackPath, sideCardBackWidth, sideCardBackHeight);
    }

}
