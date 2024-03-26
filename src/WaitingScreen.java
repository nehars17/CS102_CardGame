import javax.swing.*;
import java.awt.*;

public class WaitingScreen extends JOptionPane {   
    // Set the dimensions of the Frame
    private final static  int windowHeight = 1200;  
    private final static int windowWidth = 800;            
    private final static int borderWidth = 100;      
    private final static int borderHeight = 100;
    private final static int hexColor = 0x085318; // The color of the poker table  
    
    // Constructor for the winning Screen
    public WaitingScreen(JFrame frame) {
        // Create a panel to blur out the parent frame
        JPanel blurPanel = new JPanel();
        blurPanel.setBackground(new Color(hexColor)); // Make the blur panel the same colour as the main frame

        Dimension blurDimension = new BottomPanel().getPlayingAreaSize();
        blurPanel.setPreferredSize(blurDimension);

        // Create a JPanel with border layout to hold the blur panel
        JPanel panel = new JPanel(new BorderLayout());
        // Add the blur panel to the south area
        panel.add(blurPanel, BorderLayout.SOUTH);
        // The parameters are as such: x, y (position of the panel), width, height (size of the panel)
        panel.setBounds(0, frame.getHeight() - blurPanel.getPreferredSize().height, frame.getWidth(), blurPanel.getPreferredSize().height);

        // frame.add(blurPanel, BorderLayout.SOUTH);

        // Add the blur panel to the parent frame's layered pane such that it appears right on top of the pane
        frame.getLayeredPane().add(panel, JLayeredPane.PALETTE_LAYER);
        frame.validate();
        frame.repaint();

        // String array to store the options for the optionpane
        String[] options = {"Ready"};

        // Set the icon for the waiting opinion pane
        ImageComponent icon = null;
        try {
            icon = new ImageComponent("./images/waiting.png", 20, 20);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        // Create a optionpane with the options and store the output into an int variable so that we can change the logic accordingly
        int choice = this.showOptionDialog(frame, "Are you ready to play?", "Waiting for player...", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, 0);

        if (choice == JOptionPane.YES_OPTION) {
            // Continue with the game
            // Remove the layeredPane of the blur panel
            frame.getLayeredPane().remove(panel);
            frame.revalidate();
            frame.repaint();
        } else {
            // Exit the game
            System.exit(0);
        }
    }
}
