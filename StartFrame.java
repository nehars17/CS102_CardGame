import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartFrame extends JFrame {
    // Dimensions of the frame
    private final static  int windowHeight = 1200;  
    private final static int windowWidth = 800;  
    private final static int borderWidth = 100;      
    private final static int borderHeight = 100;
    private final static int hexColor = 0x085318; // The color of the poker table   
    
    // Create all of the panels and labels outside of the method so that it is assesssible thorughout the class
    private JPanel startScreen;
    private JLabel startlabel;
    private JButton startButton;
    private JButton exitButton;

    private GameControl gameControl;

    // Create the constructor of StartFrame
    public StartFrame( GameControl gameControl) { 
        // Create the frame for the application
        this.setTitle("Dai Di"); // Sets the title of the frame
        this.setSize(windowHeight, windowWidth); // Set the size of the frame
        this.setResizable(true); // Set the frame to be resizable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the frame such that it will be closed upon pressing 'x'
        ImageIcon logo = new ImageIcon("logo.jpg"); //Set the image icon for the logo of the frame
        this.setIconImage(logo.getImage()); 
        this.getContentPane().setBackground(new Color(hexColor)); // Set the background color of the frame to the colour of the poker table
        this.setLocationRelativeTo(null); // Set the frame to appear in the middle of the screen
        
        this.gameControl = gameControl; 
        // Add the different components to the panel
        createStartScreen();

        

        this.add(startScreen);
    
        // Set the frame to be accessible
        this.setVisible(true);
    }

    // Create the label
    private void createStartlabel() {
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
    }

    // Create the start button
    private void createStartButton() {
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
                dispose();
                // Add the game panel
        
                new GameScreen(gameControl);
                // gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // StartFrame.this.getContentPane().add(gameFrame);
            }
        });
    }

    // Create the exit button
    private void createExitButton() {
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
        // Add a mouse listener to the exit button
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Close the frame
                dispose();
            }
        });
    }

    // Create the panel for the start screen
    private void createStartScreen() {
        // Create a new panel for the start screen
        // Using GridBagLayout to allow for more flexibility in the layout, allow us to determine where exactly we want what to go
        startScreen = new JPanel(new GridBagLayout());
        // Change the background of the frame
        startScreen.setBackground(new Color(hexColor));

        // Create the grid bag contraints
        GridBagConstraints gbc = new GridBagConstraints();
        // Top, Left, Bottom, Right
        // The insets represents the space that a container should leave at each of its edges
        gbc.insets = new Insets(10, 0, 10, 0);

        createStartlabel();
        createStartButton();
        createStartlabel();
        // gridx and gridy determines in which cell your component will be placed
        // 0, 0 is the top left
        // The gridx and gridy is relative to the other components in the panel
        gbc.gridx= 0;
        gbc.gridy = 0;
        // Add the label to the panel
        startScreen.add(startlabel, gbc);
        
        // Create the buttons
        createStartButton();
        createExitButton();
        // Add the start button to the panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        startScreen.add(startButton, gbc);

        // Add the exit button to the panel
        gbc.gridx = 0;
        gbc.gridy = 2;
        startScreen.add(exitButton, gbc);
    }



}