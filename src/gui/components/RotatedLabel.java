package gui.components;

import javax.swing.*;
import java.awt.*;

/**
 * Represents a JLabel that can be rotated to a specified angle.
 */

public class RotatedLabel extends JLabel {
    private final double angleDegrees;

    /**
     * Constructs a RotatedLabel with the specified text and rotation angle.
     *
     * @param text The text to display on the label.
     * @param angleDegrees The angle at which the label is to be rotated.
     */
    public RotatedLabel(String text, double angleDegrees) {
        super(text);
        this.angleDegrees = angleDegrees;
    }

    /**
     * Constructs a RotatedLabel with the specified image and rotation angle.
     *
     * @param cardBack The image to display on the label.
     * @param angleDegrees The angle at which the label is to be rotated.
     */
    public RotatedLabel(ImageComponent cardBack, double angleDegrees) {
        super(cardBack);
        setPreferredSize( new Dimension (cardBack.getIconHeight(), cardBack.getIconWidth()));
        this.angleDegrees = angleDegrees;
    
    }

    /**
     * Paints the label with the specified rotation angle.
     *
     * @param g The Graphics object to paint with.
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        // Set the rotation
        g2d.rotate(Math.toRadians(angleDegrees), getWidth() / 2, getHeight() / 2);

        // Paint the label
        super.paintComponent(g2d);

        g2d.dispose();
    }
}