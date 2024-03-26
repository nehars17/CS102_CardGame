package gui.components;

import model.cards.Card;
import javax.swing.*;

/**
 * Represents a clickable card button in a card game. 
 * This component allows the card to be moved between panels when clicked.
 */
public class ClickableCard extends JButton {

    private final Card card; // The card associated with this button
    private final JPanel toPanel; // The target panel to move the card to on click

    /**
     * Constructs a ClickableCard component.
     *
     * @param gameFrame The main game frame for UI updates.
     * @param card      The card object this button represents.
     * @param curPanel  The current panel containing this button.
     * @param toPanel   The target panel to move this card to when clicked.
     */
    public ClickableCard(JFrame gameFrame, Card card, JPanel curPanel, JPanel toPanel) {
        this.card = card;
        this.toPanel = toPanel;

        setCardFace(card.getImagePath());
        setupActionListener(curPanel, gameFrame);
        customizeButtonAppearance();
    }

    /**
     * Sets the card face image on the button.
     *
     * @param imagePath The path to the card image file.
     */
    private void setCardFace(String imagePath) {
        ImageComponent cardFace = new ImageComponent(imagePath);
        this.setIcon(cardFace);
    }

    /**
     * Customizes the button's appearance to make it transparent except for the card image.
     */
    private void customizeButtonAppearance() {
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setOpaque(false);
        this.setContentAreaFilled(false);
    }

    /**
     * Sets up the action listener for the card, defining the behavior when the card is clicked.
     *
     * @param curPanel  The current panel containing this button.
     * @param gameFrame The main game frame for UI updates.
     */
    private void setupActionListener(JPanel curPanel, JFrame gameFrame) {
        this.addActionListener(e -> {
            // Move the card to the target panel and update the UI accordingly
            curPanel.remove(this);
            toPanel.add(new ClickableCard(gameFrame, card, toPanel, curPanel));

            curPanel.revalidate();
            curPanel.repaint();

            gameFrame.revalidate();
            gameFrame.repaint();
        });
    }

    /**
     * Returns the card associated with this component.
     *
     * @return The card object.
     */
    public Card getCard() {
        return card;
    }
}
