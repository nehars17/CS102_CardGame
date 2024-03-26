package gui.components;

import java.awt.*;
import javax.swing.*;

/**
 * Represents the area where the player's hand is displayed.
 */

public class HandArea extends JPanel {
    private final static int hexColor = 0x085318; // The color of the poker table
    private final static Color backgroundColor = new Color(hexColor);

    /**
     * Constructs a HandArea, initializing its layout and background color.
     */
    public HandArea() {
        this.setLayout(new GridBagLayout());
        this.setBackground(backgroundColor);
    }

}
