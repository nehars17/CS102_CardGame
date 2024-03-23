import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartFrame extends JFrame{
    // Dimensions of the frame
    private final static  int windowHeight = 1200;  
    private final static int windowWidth = 800;  
    private final static int borderWidth = 50;      
    private final static int borderHeight = 50;   
    
    // Create all of the panels and labels outside of the method so that it is assesssible thorughout the class
    protected static JFrame frame;
    protected static JPanel startScreen;
    protected static JLabel startlabel;
    protected static JButton startButton;
    protected static JButton exitButton;

    // Create the frame for the application
    public static JFrame gameFrame() {
        frame = new JFrame();
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

    public static JPanel startScreen() {
        // Create a new panel for the start screen
        // Using GridBagLayout to allow for more flexibility in the layout, allow us to determine where exactly we want what to go
        startScreen = new JPanel(new GridBagLayout());
        // Change the background of the frame
        startScreen.setBackground(new Color(0x085318));

        // Create the grid bag contraints
        GridBagConstraints gbc = new GridBagConstraints();
        // Top, Left, Bottom, Right
        // The insets represents the space that a container should leave at each of its edges
        gbc.insets = new Insets(10, 0, 10, 0);

        // Create the label that contains the starting screen image and text
        ImageIcon startImage = new ImageIcon("startscreen.png");
        startlabel = new JLabel();
        startlabel.setIcon(startImage);
        // Use html tags to allow for text manipulation
        startlabel.setText("<html><div style='text-align: center;'>Welcome to Dai Di!!!<br>A 4 player game of luck and skill</div></html>");
        // Change the font size and style of the text
        startlabel.setFont(new Font("Roboto", Font.BOLD, 30));
        // Change the color and the font of the text
        startlabel.setForeground(Color.BLACK);
        startlabel.setHorizontalTextPosition(JLabel.CENTER);
        startlabel.setVerticalTextPosition(JLabel.BOTTOM);
        // gridx and gridy determines in which cell your component will be placed
        // 0, 0 is the top left
        // The gridx and gridy is relative to the other components in the panel
        gbc.gridx= 0;
        gbc.gridy = 0;
        // Add the label to the panel
        startScreen.add(startlabel, gbc);
        
        // Create the buttons
        // Create the start game button
        startButton = new JButton("Start Game");
        // Set the dimensions of the button
        startButton.setPreferredSize(new Dimension(200, 80));
        // Set the fontsize and color of the textt in the button
        startButton.setFont(new Font("Roboto", Font.BOLD, 20));
        startButton.setForeground(Color.RED);
        Image originalIcon = new ImageIcon("play.jpg").getImage();
        // Scale the image to fit the button
        Image resizedIcon = originalIcon.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        startButton.setIcon(new ImageIcon(resizedIcon));
        // Set the position of the text in the button, relative to the icon in the button
        startButton.setHorizontalTextPosition(JButton.LEFT);
        startButton.setVerticalTextPosition(JButton.CENTER);
        // Change the background of the button
        startButton.setBackground(Color.WHITE);
        startButton.setFocusable(false);
        // Change the borders of the button
        startButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        
        // Add the mouse listener to the button
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                // Add the game panel
                JFrame gameFrame = new GameScreen();
                gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(gameFrame);
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 1;
        startScreen.add(startButton, gbc);

        // Create the exit game button
        exitButton = new JButton("Exit Game");
        exitButton.setPreferredSize(new Dimension(200, 80));
        exitButton.setFont(new Font("Roboto", Font.BOLD, 20));
        exitButton.setForeground(Color.RED);
        Image originalIcon2 = new ImageIcon("exit.png").getImage();
        Image resizedIcon2 = originalIcon2.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        exitButton.setIcon(new ImageIcon(resizedIcon2));
        exitButton.setHorizontalTextPosition(JButton.LEFT);
        exitButton.setVerticalTextPosition(JButton.CENTER);
        // Change the background of the button
        exitButton.setBackground(Color.WHITE);
        exitButton.setFocusable(false);
        // Change the borders of the button
        exitButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        // Add the mouse listener to the button
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Close the frame
                frame.dispose();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 2;
        startScreen.add(exitButton, gbc);

        return startScreen;
    }

    public StartFrame() {
        JFrame frame = gameFrame();
        frame.add(startScreen(), BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // To test if the constructor is working
    // public static void main(String[] args) {
    //     new StartFrame();
    // }
}