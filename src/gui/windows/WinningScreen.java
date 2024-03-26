package gui.windows;
import javax.swing.*;

import controller.GameControl;
import gui.components.ImageComponent;

import java.awt.*;
import java.awt.event.*;

public class WinningScreen extends JOptionPane {
    // Constructor for the winning screen
    public WinningScreen(JFrame frame) {
        // Create a panel to blur out the parent frame
        JPanel blurPanel = new JPanel();
        blurPanel.setBackground(new Color(0, 0, 0, 120)); // Semi-transparent black
        // Set the size of the blur panel to be the same size as the parent frame
        blurPanel.setSize(frame.getSize());

        // Add the blur panel to the parent frame's layered pane such that it appears right above the parent frame
        frame.getLayeredPane().add(blurPanel, JLayeredPane.PALETTE_LAYER);

        // String array to store the options for the optionpane
        String[] options = {"Play Again", "Quit"};

        // Create the icon for the winning option 
        ImageComponent icon = null;
        try {
            icon = new ImageComponent("images/winning.png", 40, 40);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        // Create a optionpane with the options and store the output into an int variable so that we can change the logic accordingly
        int choice = this.showOptionDialog(frame, "Do you want to play again?", "You WIN!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, 0);

        // Remove the semi-transparent panel after the option dialog is closed
        frame.getLayeredPane().remove(blurPanel);

        // Implement the logic of the options
        if (choice == JOptionPane.YES_OPTION) {
            // Restart the game
            frame.dispose();
            new GameScreen(new GameControl());
        } else {
            System.exit(0);
        }
    }
}
