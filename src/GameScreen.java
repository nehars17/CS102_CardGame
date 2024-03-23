import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameScreen extends JFrame {
    // Set the dimensions of the Frame
    private final static  int windowHeight = 1200;  
    private final static int windowWidth = 800;            
    private final static int borderWidth = 50;      
    private final static int borderHeight = 50;    

    // Constructor
    public GameScreen() {
        JFrame gameWindow = gameFrame();
        addPlayerPanels(gameWindow);
        gameWindow.setVisible(true);    
    }

    // Create the frame for the application
    public static JFrame gameFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("Dai Di"); // Sets the title of the frame
        frame.setSize(windowHeight, windowWidth); // Set the size of the frame
        frame.setResizable(true); // Set the frame to be resizable
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the frame such that it will be closed upon pressing 'x'
        ImageIcon logo = new ImageIcon("logo.jpg"); //Set the image icon for the logo of the frame
        frame.setIconImage(logo.getImage()); 
        frame.getContentPane().setBackground(new Color(0x085318)); // Set the background color of the frame to the colour of the poker table
        frame.setLocationRelativeTo(null); // Set the frame to appear in the middle of the screen
        // frame.setLayout( new BorderLayout());
        return frame;
    }

    // Add the panels to the frame
    public static void addPlayerPanels(JFrame frame) {
        // Set the frame layout
        frame.setLayout(new BorderLayout(30, 30));

        // Create the panels for the players
        JPanel northHand = new JPanel();
        JPanel eastHand = new JPanel();
        JPanel southHand = new JPanel();
        JPanel westHand = new JPanel();
        JPanel centerPanel = new JPanel();

        // Set the colour for checking purposes
        northHand.setBackground(Color.RED);
        eastHand.setBackground(Color.GREEN);
        southHand.setBackground(Color.BLUE);
        westHand.setBackground(Color.YELLOW);
        centerPanel.setBackground(Color.ORANGE);

        // Set the size of the panels
        northHand.setPreferredSize(new Dimension(100, 100));
        eastHand.setPreferredSize(new Dimension(100, 100));
        southHand.setPreferredSize(new Dimension(100, 100));
        westHand.setPreferredSize(new Dimension(100, 100));
        centerPanel.setPreferredSize(new Dimension(100, 100));

        // Trim the north and south panels
        JPanel leftEmptyPanel = new JPanel();
        leftEmptyPanel.setBackground(new Color(0x085318));
        leftEmptyPanel.setPreferredSize(new Dimension(130, 130));
        JPanel rightEmptyPanel = new JPanel();
        rightEmptyPanel.setBackground(new Color(0x085318));
        rightEmptyPanel.setPreferredSize(new Dimension(130, 130));
        // Create the middle panel that will not be trimmed
        JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        northHand.setLayout(new BorderLayout());
        middlePanel.setBackground(northHand.getBackground());
        northHand.add(leftEmptyPanel, BorderLayout.WEST);
        northHand.add(middlePanel, BorderLayout.CENTER);
        northHand.add(rightEmptyPanel, BorderLayout.EAST);

        JPanel leftEmptyPanel2 = new JPanel();
        leftEmptyPanel2.setBackground(new Color(0x085318));
        leftEmptyPanel2.setPreferredSize(new Dimension(130, 130));
        JPanel rightEmptyPanel2 = new JPanel();
        rightEmptyPanel2.setBackground(new Color(0x085318));
        rightEmptyPanel2.setPreferredSize(new Dimension(130, 130));
        // Create the middle panel that will not be trimmed
        JPanel middlePanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southHand.setLayout(new BorderLayout());
        middlePanel2.setBackground(southHand.getBackground());
        southHand.add(leftEmptyPanel2, BorderLayout.WEST);
        southHand.add(middlePanel2, BorderLayout.CENTER);
        southHand.add(rightEmptyPanel2, BorderLayout.EAST);
        
        // Add the panels to the frame
        frame.add(northHand, BorderLayout.NORTH);
        frame.add(eastHand, BorderLayout.EAST);
        frame.add(southHand, BorderLayout.SOUTH);
        frame.add(westHand, BorderLayout.WEST);
        frame.add(centerPanel, BorderLayout.CENTER);
    }

    // Function to trim the north and south panel
    private static void trimPanel(JPanel panel) {
        // Change the layout setting of the panel
        panel.setLayout(new BorderLayout());

        JPanel leftEmptyPanel = new JPanel();
        leftEmptyPanel.setBackground(new Color(0x085318));
        // Set the dimensions of the left empty panel to be the same size as the original panel
        leftEmptyPanel.setPreferredSize(panel.getSize());
        JPanel rightEmptyPanel = new JPanel();
        rightEmptyPanel.setBackground(new Color(0x085318));
        rightEmptyPanel.setPreferredSize(panel.getSize());
        
        // Create the middle panel that will not be trimmed
        JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        middlePanel.setBackground(panel.getBackground());
        
        // Create the nested panels to trim the panel
        panel.add(leftEmptyPanel, BorderLayout.WEST);
        panel.add(middlePanel, BorderLayout.CENTER);
        panel.add(rightEmptyPanel, BorderLayout.EAST);
    }

    // To test if the constructor for this frame is working
    // public static void main(String[] args) {
    //     new GameScreen();
    // }
}
