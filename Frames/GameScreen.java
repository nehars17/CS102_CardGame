import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameScreen extends JFrame {
    // Set the dimensions of the Frame
    private final static  int windowHeight = 1200;  
    private final static int windowWidth = 800;            
    private final static int borderWidth = 100;      
    private final static int borderHeight = 100;
    private final static int hexColor = 0x085318; // The color of the poker table

    // All of the panels and labels that will be in this frame
    private JPanel northHand;
    private JPanel eastHand;
    private JPanel southHand;
    private JPanel westHand;
    private JPanel centerPanel;
    
    // Constructor to create the frame
    public GameScreen() {
        // Create the frame for the application
        this.setTitle("Dai Di"); // Sets the title of the frame
        this.setSize(windowHeight, windowWidth); // Set the size of the frame
        this.setResizable(true); // Set the frame to be resizable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the frame such that it will be closed upon pressing 'x'
        ImageIcon logo = new ImageIcon("logo.jpg"); //Set the image icon for the logo of the frame
        this.setIconImage(logo.getImage()); 
        this.getContentPane().setBackground(new Color(hexColor)); // Set the background color of the frame to the colour of the poker table
        this.setLocationRelativeTo(null); // Set the frame to appear in the middle of the screen
    
        // Add the different components to the panel
        northHand = new TopPanel();
        this.add(northHand, BorderLayout.NORTH);
    
        // Set the frame to be accessible
        this.setVisible(true);
    }

    // To test if the constructor for this frame is working
    public static void main(String[] args) {
        new GameScreen();
    }
}

// public class GameScreen extends JFrame {
//     // Set the dimensions of the Frame
//     private final static  int windowHeight = 1200;  
//     private final static int windowWidth = 800;            
//     private final static int borderWidth = 100;      
//     private final static int borderHeight = 100;    

//     // Constructor
//     public GameScreen() {
//         JFrame gameWindow = gameFrame();
//         addPlayerPanels(gameWindow);
//         gameWindow.setVisible(true);    
//     }

//     // Create the frame for the application
//     public static JFrame gameFrame() {
//         JFrame frame = new JFrame();
//         frame.setTitle("Dai Di"); // Sets the title of the frame
//         frame.setSize(windowHeight, windowWidth); // Set the size of the frame
//         frame.setResizable(true); // Set the frame to be resizable
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the frame such that it will be closed upon pressing 'x'
//         ImageIcon logo = new ImageIcon("logo.jpg"); //Set the image icon for the logo of the frame
//         frame.setIconImage(logo.getImage()); 
//         frame.getContentPane().setBackground(new Color(0x085318)); // Set the background color of the frame to the colour of the poker table
//         frame.setLocationRelativeTo(null); // Set the frame to appear in the middle of the screen
//         // frame.setLayout( new BorderLayout());
//         return frame;
//     }

//     // Add the panels to the frame
//     public static void addPlayerPanels(JFrame frame) {
//         // Set the frame layout
//         frame.setLayout(new BorderLayout(30, 30));

//         // Create the panels for the players
//         JPanel northHand = new JPanel();
//         JPanel eastHand = new JPanel();
//         JPanel southHand = new JPanel();
//         JPanel westHand = new JPanel();
//         JPanel centerPanel = new JPanel();

//         // Set the colour for checking purposes
//         northHand.setBackground(Color.RED);
//         eastHand.setBackground(Color.GREEN);
//         southHand.setBackground(Color.BLUE);
//         westHand.setBackground(Color.YELLOW);
//         centerPanel.setBackground(Color.ORANGE);

//         // Set the size of the panels
//         northHand.setPreferredSize(new Dimension(borderWidth, borderHeight + 50));
//         eastHand.setPreferredSize(new Dimension(borderWidth + 50, borderHeight));
//         southHand.setPreferredSize(new Dimension(borderWidth * 2, borderHeight * 2));
//         westHand.setPreferredSize(new Dimension(borderWidth + 50, borderHeight));
//         centerPanel.setPreferredSize(new Dimension(borderWidth, borderHeight));

//         // Trim the north and south panels
//         JPanel leftEmptyPanel = new JPanel();
//         leftEmptyPanel.setBackground(new Color(0x085318));
//         leftEmptyPanel.setPreferredSize(new Dimension(borderWidth + 80, borderHeight + 80));
//         JPanel rightEmptyPanel = new JPanel();
//         rightEmptyPanel.setBackground(new Color(0x085318));
//         rightEmptyPanel.setPreferredSize(new Dimension(borderWidth + 80, borderHeight + 80));
//         // Create the middle panel that will not be trimmed
//         JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

//         northHand.setLayout(new BorderLayout());
//         middlePanel.setBackground(northHand.getBackground());
//         northHand.add(leftEmptyPanel, BorderLayout.WEST);
//         northHand.add(middlePanel, BorderLayout.CENTER);
//         northHand.add(rightEmptyPanel, BorderLayout.EAST);

//         JPanel leftEmptyPanel2 = new JPanel();
//         leftEmptyPanel2.setBackground(new Color(0x085318));
//         leftEmptyPanel2.setPreferredSize(new Dimension(borderWidth + 80, borderHeight + 80));
//         JPanel rightEmptyPanel2 = new JPanel();
//         rightEmptyPanel2.setBackground(new Color(0x085318));
//         rightEmptyPanel2.setPreferredSize(new Dimension(borderWidth + 80, borderHeight + 80));
//         // Create the middle panel that will not be trimmed
//         JPanel middlePanel2 = new JPanel(new GridBagLayout());

//         southHand.setLayout(new BorderLayout());
//         middlePanel2.setBackground(southHand.getBackground());

//         JPanel testPanel = new JPanel();
//         testPanel.setBackground(Color.BLACK);
//         testPanel.setPreferredSize(new Dimension(50, 50));
//         middlePanel2.add(testPanel);
//         JPanel testPanel1 = new JPanel();
//         testPanel1.setBackground(Color.WHITE);
//         testPanel1.setPreferredSize(new Dimension(50, 50));       
//         middlePanel2.add(testPanel1);


//         southHand.add(leftEmptyPanel2, BorderLayout.WEST);
//         southHand.add(middlePanel2, BorderLayout.CENTER);
//         southHand.add(rightEmptyPanel2, BorderLayout.EAST);
        
//         // Add the panels to the frame
//         frame.add(northHand, BorderLayout.NORTH);
//         frame.add(eastHand, BorderLayout.EAST);
//         frame.add(southHand, BorderLayout.SOUTH);
//         frame.add(westHand, BorderLayout.WEST);
//         frame.add(centerPanel, BorderLayout.CENTER);
//     }

//     // Function to trim the north and south panel
//     private static void trimPanel(JPanel panel) {
//         // Change the layout setting of the panel
//         panel.setLayout(new BorderLayout());

//         JPanel leftEmptyPanel = new JPanel();
//         leftEmptyPanel.setBackground(new Color(0x085318));
//         // Set the dimensions of the left empty panel to be the same size as the original panel
//         leftEmptyPanel.setPreferredSize(panel.getSize());
//         JPanel rightEmptyPanel = new JPanel();
//         rightEmptyPanel.setBackground(new Color(0x085318));
//         rightEmptyPanel.setPreferredSize(panel.getSize());
        
//         // Create the middle panel that will not be trimmed
//         JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//         middlePanel.setBackground(panel.getBackground());
        
//         // Create the nested panels to trim the panel
//         panel.add(leftEmptyPanel, BorderLayout.WEST);
//         panel.add(middlePanel, BorderLayout.CENTER);
//         panel.add(rightEmptyPanel, BorderLayout.EAST);
//     }

//     // To test if the constructor for this frame is working
//     public static void main(String[] args) {
//         new GameScreen();
//     }
// }
