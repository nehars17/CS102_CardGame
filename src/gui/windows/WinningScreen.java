package gui.windows;

import controller.GameControl;
import gui.components.ImageComponent;

import javax.swing.*;
import java.awt.*;

/**
 * A dialog window that appears when the player wins the game.
 */

public class WinningScreen extends JOptionPane {
    
    /**
     * Constructor that displays the winning screen dialog.
     * 
     * @param frame The parent JFrame over which the winning screen is to be displayed.
     */
    public WinningScreen(JFrame frame) {
        // Panel to create a semi-transparent effect over the parent frame
        JPanel blurPanel = new JPanel();
        blurPanel.setBackground(new Color(0, 0, 0, 120)); // Semi-transparent black for the blur effect
        blurPanel.setSize(frame.getSize()); // Match the parent frame's size for full coverage
        
        // Add the blur panel to the parent frame's layered pane to appear on top
        frame.getLayeredPane().add(blurPanel, JLayeredPane.PALETTE_LAYER);

        // Options presented to the user in the dialog
        String[] options = {"Play Again", "Quit"};

        // Load the icon to be used in the dialog
        ImageIcon icon = new ImageComponent("images/winning.png",40,40);

        // Show the option dialog and capture the user's choice
        int choice = showOptionDialog(frame, 
                                      "Do you want to play again?", 
                                      "You WIN!", 
                                      JOptionPane.YES_NO_OPTION, 
                                      JOptionPane.QUESTION_MESSAGE, 
                                      icon, 
                                      options, 
                                      options[0]);

        // Cleanup: Remove the blur panel once the dialog is closed
        frame.getLayeredPane().remove(blurPanel);
        
        // Handle the user's choice from the dialog
        if (choice == JOptionPane.YES_OPTION) {
            frame.dispose(); // Close the current game window
            new GameScreen(new GameControl()); // Restart the game
        } else {
            System.exit(0); // Exit the application
        }
    }
}