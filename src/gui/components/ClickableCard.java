package gui.components;

import model.cards.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Represents a clickable card button in a card game.
 * This component allows the card to be moved between panels when clicked.
 */
public class ClickableCard extends JButton {

    private final Card card; // The card associated with this button
    private final JPanel toPanel; // The target panel to move the card to on click

    private ImageIcon originalIcon; // Store the original icon
    private ImageIcon hoverIcon; // Scaled icon for hover effect

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
        setupHoverEffect();
    }

    /**
     * Sets the card face image on the button.
     *
     * @param imagePath The path to the card image file.
     */
    private void setCardFace(String imagePath) {
        originalIcon = new ImageIcon(imagePath);
        this.setIcon(originalIcon);
        // Create a scaled version of the icon for the hover effect
        Image img = originalIcon.getImage().getScaledInstance(
                originalIcon.getIconWidth() + 10, // Scale width by 10 pixels
                originalIcon.getIconHeight() + 10, // Scale height by 10 pixels
                Image.SCALE_SMOOTH);
        hoverIcon = new ImageIcon(img);
    }

    /**
     * Customizes the button's appearance to make it transparent except for the card
     * image.
     */
    private void customizeButtonAppearance() {
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false); // Optional: remove focus border for aesthetics
    }

    /**
     * Sets up the action listener for the card, defining the behavior when the card
     * is clicked.
     *
     * @param curPanel  The current panel containing this button.
     * @param gameFrame The main game frame for UI updates.
     */
    private void setupActionListener(JPanel curPanel, JFrame gameFrame) {
        this.addActionListener(e -> {
            curPanel.remove(this);
            toPanel.add(new ClickableCard(gameFrame, card, toPanel, curPanel));
            curPanel.revalidate();
            curPanel.repaint();
            gameFrame.revalidate();
            gameFrame.repaint();
        });
    }

    /**
     * Sets up a hover effect for the card button.
     */
    private void setupHoverEffect() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setIcon(hoverIcon); // Use the scaled icon
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setIcon(originalIcon); // Revert to the original icon
            }
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
