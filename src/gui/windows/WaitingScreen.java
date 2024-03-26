package gui.windows;

import gui.components.ImageComponent;
import gui.panels.BottomPanel;

import javax.swing.*;
import java.awt.*;

/**
 * A waiting screen displayed to players after they finished their turn.
 * This screen includes a blurred background panel and a prompt to confirm
 * readiness.
 */
public class WaitingScreen extends JOptionPane {

    // Dimensions of the Frame
    private final static int WINDOW_HEIGHT = 1200;
    private final static int WINDOW_WIDTH = 800;
    private final static int BORDER_WIDTH = 100;
    private final static int BORDER_HEIGHT = 100;
    private final static int HEX_COLOR = 0x085318; // Color of the poker table

    /**
     * Constructs a WaitingScreen object.
     *
     * @param frame The parent JFrame to which the waiting screen is associated.
     */
    public WaitingScreen(JFrame frame) {
        // Create a panel to blur out the parent frame
        JPanel blurPanel = new JPanel();
        blurPanel.setBackground(new Color(HEX_COLOR)); // Set the blur panel's color

        Dimension blurDimension = new BottomPanel().getPlayingAreaSize();
        blurPanel.setPreferredSize(blurDimension);

        // Create a JPanel with border layout to hold the blur panel
        JPanel panel = new JPanel(new BorderLayout());
        // Add the blur panel to the south area
        panel.add(blurPanel, BorderLayout.SOUTH);
        // Set the position and size of the panel
        panel.setBounds(0, frame.getHeight() - blurPanel.getPreferredSize().height, frame.getWidth(),
                blurPanel.getPreferredSize().height);

        // Add the blur panel to the parent frame's layered pane
        frame.getLayeredPane().add(panel, JLayeredPane.PALETTE_LAYER);
        frame.validate();
        frame.repaint();

        // Options for the option pane
        String[] options = { "Ready" };

        // Set the icon for the waiting option pane
        ImageComponent icon = null;
        try {
            icon = new ImageComponent("images/waiting.png", 20, 20);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        // Display option pane and retrieve user choice
        int choice = this.showOptionDialog(frame, "Are you ready to play?", "Waiting for player...",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, 0);

        if (choice == JOptionPane.YES_OPTION) {
            // Continue with the game
            // Remove the layered pane of the blur panel
            frame.getLayeredPane().remove(panel);
            frame.revalidate();
            frame.repaint();
        } else {
            // Exit the game
            System.exit(0);
        }
    }
}
