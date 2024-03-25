import javax.swing.*;
import java.awt.*;

public class RotatedLabel extends JLabel {
    private final double angleDegrees;

    public RotatedLabel(String text, double angleDegrees) {
        super(text);
        this.angleDegrees = angleDegrees;
    }

    public RotatedLabel(ImageComponent cardBack, double angleDegrees) {
        super(cardBack);
        this.angleDegrees = angleDegrees;
    
    }

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