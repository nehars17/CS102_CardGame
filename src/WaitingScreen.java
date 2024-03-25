import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WaitingScreen extends JOptionPane {    
    // Constructor for the winning Screen
    public WaitingScreen(JFrame frame) {
        // Create a panel to blur out the parent frame
        JPanel blurPanel = new JPanel();
        blurPanel.setBackground(new Color(0, 0, 0, 120)); // Semi-transparent black
        // Set the size of the blur panel to be the same size as the parent frame
        blurPanel.setSize(frame.getSize());

        // Add the blur panel to the parent frame's layered pane such that it appears right on top of the pane
        frame.getLayeredPane().add(blurPanel, JLayeredPane.PALETTE_LAYER);

        // String array to store the options for the optionpane
        String[] options = {"Ready", "Quit"};

        // Set the icon for the waiting opinion pane
        ImageComponent icon = null;
        try {
            icon = new ImageComponent("./images/waiting.png", 20, 20);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        // Create a optionpane with the options and store the output into an int variable so that we can change the logic accordingly
        int choice = this.showOptionDialog(frame, "Are you ready to play?", "Waiting for player...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, 0);

        if (choice == JOptionPane.YES_OPTION) {
            // Continue with the game
            frame.getLayeredPane().remove(blurPanel);
            frame.revalidate();
            frame.repaint();
        } else {
            // Exit the game
            frame.dispose();
        }
    }
}
