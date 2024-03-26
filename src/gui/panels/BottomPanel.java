package gui.panels;

import gui.components.HandArea;
import gui.components.ToPlayArea;

import java.awt.*;
import javax.swing.*;

/**
 * BottomPanel serves as the container for player's hand and the area where
 * cards are played.
 * It represents the hand and playing area of the current player.
 */

public class BottomPanel extends JPanel {

    private final int colorCode = 0x085318; // color of background
    private final Color emptyPanelColor = new Color(colorCode);
    private final int borderHeight = 200;
    private final int borderWidth = 200;
    private final Dimension emptyPanelDimensions = new Dimension(borderWidth, borderHeight);
    private JPanel toPlayArea;
    private JPanel handArea;

    /**
     * Constructs a BottomPanel, initializing and arranging its child components.
     */
    public BottomPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(emptyPanelColor);
        this.addCardAreas();
        this.setBorder(BorderFactory.createEmptyBorder());
    }

    /**
     * Adds the card areas to the bottom panel.
     */
    private void addCardAreas() {

        toPlayArea = new ToPlayArea();
        handArea = new HandArea();

        JPanel formatCardPanels = new JPanel(new GridLayout(2, 1)); // gridlayout of 2 rows 1 col to stack playArea and
                                                                    // handArea
        formatCardPanels.setBackground(emptyPanelColor);
        formatCardPanels.add(toPlayArea);
        formatCardPanels.add(handArea);

        this.add(formatCardPanels, BorderLayout.CENTER);
    }

    /**
     * Getter method to get the playing area.
     * 
     * @return the playing area.
     */
    public JPanel getToPlayArea() {
        return toPlayArea;
    }

    /**
     * Getter method to get the hand area.
     * 
     * @return the hand area.
     */
    public JPanel getHandArea() {
        return handArea;
    }

    /**
     * Getter method to get the size of the playing area.
     * 
     * @return the size of the playing area.
     */
    public Dimension getPlayingAreaSize() {
        return emptyPanelDimensions;
    }

}
