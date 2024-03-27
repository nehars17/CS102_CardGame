package gui.panels;

import gui.components.DisplayCard;
import gui.components.RotatedLabel;

import javax.swing.*;
import java.awt.*;

/**
 * Represents a side panel in the game UI that displays player numbers of those 
 * players who are not the current player. It also displays a visual representation
 * of the back of the cards in their hand.
 */

public class SidePanel extends JPanel {
    private static final Color BACKGROUND_COLOR = new Color(0x085318); // The color of the poker table

    private final int rotationAngle;
    private final JPanel backOfCardPanel;
    private final RotatedLabel rotatedLabel;
    private final GridBagConstraints constraints = new GridBagConstraints();

    /**
     * Constructs a SidePanel with a specified rotation angle for its contents.
     *
     * @param rotationAngle The angle at which the contents of the panel are to be rotated.
     */
    public SidePanel(int rotationAngle) {
        this.rotationAngle = rotationAngle;
        this.setLayout(new BorderLayout());
        this.setBackground(BACKGROUND_COLOR);
        
        rotatedLabel = new RotatedLabel("Player", rotationAngle);
        configureRotatedLabel();

        backOfCardPanel = new JPanel(new GridBagLayout()); //backOfCardPanel = new JPanel(new GridBagLayout());
        backOfCardPanel.setBackground(BACKGROUND_COLOR);

        addComponentsToLayout();
    }

    /**
     * Configures the properties of the rotated label used to display player information.
     */
    private void configureRotatedLabel() {
        rotatedLabel.setForeground(Color.WHITE);
        rotatedLabel.setFont(new Font("Roboto", Font.BOLD, 20));
    }

    /**
     * Adds components to the panel based on the rotation angle. If panel is on the left side, put the label on left side of the panel
     */
    private void addComponentsToLayout() {
        if (rotationAngle == 90) {
            this.add(rotatedLabel, BorderLayout.EAST);
        } else {
            this.add(rotatedLabel, BorderLayout.WEST);
        }
        this.add(backOfCardPanel, BorderLayout.CENTER);
    }

    /**
     * Sets the text of the rotated label to include the player number.
     *
     * @param playerNumber The player number to be displayed.
     */
    public void setPlayerLabel(int playerNumber) {
        rotatedLabel.setText("Player " + playerNumber);
    }

    /**
     * Updates the back-of-card panel to reflect the number of cards in a player's hand.
     *
     * @param sizeOfPlayersHand The number of cards in the player's hand.
     */
    public void updateCardBacks(int sizeOfPlayersHand) {
        backOfCardPanel.removeAll();
        constraints.gridx = 0;
        constraints.gridy = 0; 
        constraints.anchor = GridBagConstraints.NORTH;
    
        // Decide the overlap value based on the card size
        int overlapValue = DisplayCard.getCardBackWidth() / 2;

    
        for (int i = 0; i < sizeOfPlayersHand; i++) {
            // Calculate the inset for the current card. Each subsequent card is moved less upwards.
            int insetTop = i * overlapValue;
    
            // Set the insets for each card - we only adjust the top inset.

            constraints.insets = new Insets(insetTop, 0, 0, 0);
            
            RotatedLabel cardBack = new RotatedLabel(DisplayCard.getCardBack(), rotationAngle);
            backOfCardPanel.add(cardBack, constraints);
        }
    
        backOfCardPanel.revalidate();
        backOfCardPanel.repaint();
    }
    
    
}