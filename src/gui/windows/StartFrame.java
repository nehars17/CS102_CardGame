package gui.windows;

import controller.GameControl;
import gui.components.ImageComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class StartFrame extends JFrame {
    // Dimensions of the frame
    private final static int windowHeight = 1200;
    private final static int windowWidth = 800;
    private final static int borderWidth = 100;
    private final static int borderHeight = 100;
    private final static int buttonWidth = 200;
    private final static int buttonHeight = 80;
    private final static int hexColor = 0x085318; // The color of the poker table

    // Create all of the panels and labels outside of the method so that it is
    // assesssible thorughout the class
    private JPanel startScreen;
    private JLabel startlabel;
    private JButton startButton;
    private JButton helpButton;
    private JButton exitButton;

    private GameControl gameControl;

    // Create the constructor of StartFrame
    public StartFrame(GameControl gameControl) {

        this.gameControl = gameControl;
        // Try catch to catch the IllegalArgumentException that will be thrown incase an
        // invalid file is passed into the ImageComponent constructor
        try {
            // Create the frame for the application
            this.setTitle("Dai Di"); // Sets the title of the frame
            this.setSize(windowHeight, windowWidth); // Set the size of the frame
            this.setResizable(true); // Set the frame to be resizable
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the frame such that it will be closed upon
                                                                 // pressing 'x'
            ImageComponent logo = new ImageComponent("images/logo.jpg"); // Set the image icon for the logo of the frame
            this.setIconImage(logo.getImage());
            this.getContentPane().setBackground(new Color(hexColor)); // Set the background color of the frame to the
                                                                      // colour of the poker table
            this.setLocationRelativeTo(null); // Set the frame to appear in the middle of the screen

            // Add the different components to the panel
            createStartScreen();

            this.add(startScreen);

            // Set the frame to be accessible
            this.setVisible(true);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    // Create the label
    private void createStartlabel() {
        // Try catch to catch the IllegalArgumentException that will be thrown incase an
        // invalid file is passed into the ImageComponent constructor
        try {
            ImageComponent startImage = new ImageComponent("images/startscreen.png", 330, 280);
            startlabel = new JLabel();
            startlabel.setIcon(startImage);
            // Use html tags to allow for text manipulation
            startlabel.setText(
                    "<html><div style='text-align: center;'>Welcome to Dai Di!!!<br>A 4 player game of luck and skill</div></html>");
            // Change the font size and style of the text
            startlabel.setFont(new Font("Roboto", Font.BOLD, 30));
            // Change the color and the font of the text
            startlabel.setForeground(Color.WHITE);
            startlabel.setHorizontalTextPosition(JLabel.CENTER);
            startlabel.setVerticalTextPosition(JLabel.BOTTOM);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    // Create the start button
    private void createStartButton() {
        // Try catch to catch the IllegalArgumentException that will be thrown incase an
        // invalid file is passed into the ImageComponent constructor
        try {
            startButton = new JButton("Start Game");
            // Set the dimensions of the button
            startButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
            // Set the fontsize and color of the textt in the button
            startButton.setFont(new Font("Roboto", Font.BOLD, 20));
            startButton.setForeground(Color.RED);
            ImageComponent resizedIcon = new ImageComponent("images/play.jpg", 50, 50);
            startButton.setIcon(resizedIcon);

            // Set the position of the text and the icon in the button
            startButton.setHorizontalTextPosition(JButton.LEFT);
            startButton.setVerticalTextPosition(JButton.CENTER);
            startButton.setHorizontalAlignment(JButton.RIGHT);
            startButton.setVerticalAlignment(JButton.CENTER);

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
                    // Start the game
                    // gameControl.startGame(); //GameScreen newGame =
                    new GameScreen(gameControl);
                }
            });
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    // Create the exit button
    private void createExitButton() {
        // Try catch to catch the IllegalArgumentException that will be thrown incase an
        // invalid file is passed into the ImageComponent constructor
        try {
            exitButton = new JButton("Exit Game");
            exitButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
            exitButton.setFont(new Font("Roboto", Font.BOLD, 20));
            exitButton.setForeground(Color.RED);
            ImageComponent resizedIcon2 = new ImageComponent("images/exit.png", 50, 50);
            exitButton.setIcon(resizedIcon2);

            // Set the position of the text and the icon in the button
            exitButton.setVerticalAlignment(JButton.CENTER);
            exitButton.setHorizontalAlignment(JButton.RIGHT);
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
                    System.exit(0);
                }
            });
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    // Function to create the help button
    private void createHelpButton() {
        helpButton = new JButton("Help       ");
        helpButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        helpButton.setFont(new Font("Roboto", Font.BOLD, 20));
        helpButton.setForeground(Color.RED);
        ImageComponent resizedIcon2 = new ImageComponent("images/help.png", 50, 50);
        helpButton.setIcon(resizedIcon2);

        // Align the Icons and the text in the button
        helpButton.setVerticalAlignment(JButton.CENTER);
        helpButton.setHorizontalAlignment(JButton.RIGHT);
        helpButton.setHorizontalTextPosition(JButton.LEFT);
        helpButton.setVerticalTextPosition(JButton.CENTER);

        // Change the background of the button
        helpButton.setBackground(Color.WHITE);
        helpButton.setFocusable(false);
        // Change the borders of the button
        helpButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        // Add a mouse listener to the help button
        helpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Create a JEditorPane
                JEditorPane editorPane = new JEditorPane();
                editorPane.setEditable(false); // Make it non-editable
                editorPane.setContentType("text/html"); // Set content type as HTML

                // Read the HTML content from the file and set it to the JEditorPane
                try {
                    // Assuming rules.html is in the project directory
                    File htmlFile = new File("../src/textassets/rules.html");
                    editorPane.setPage(htmlFile.toURI().toURL());
                } catch (IOException ex) {
                    ex.printStackTrace();
                    editorPane.setText("Failed to load the rules.");
                }

                // Create a JScrollPane and add the JEditorPane to it
                JScrollPane scrollPane = new JScrollPane(editorPane);
                scrollPane.setPreferredSize(new Dimension(500, 500)); // Set preferred size

                // Show a message dialog with the JScrollPane
                JOptionPane.showMessageDialog(StartFrame.this, scrollPane, "Game Rules",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

    }

    // Create the panel for the start screen
    private void createStartScreen() {
        // Create a new panel for the start screen
        // Using GridBagLayout to allow for more flexibility in the layout, allow us to
        // determine where exactly we want what to go
        startScreen = new JPanel(new GridBagLayout());
        // Change the background of the frame
        startScreen.setBackground(new Color(hexColor));

        // Create the grid bag contraints
        GridBagConstraints gbc = new GridBagConstraints();
        // Top, Left, Bottom, Right
        // The insets represents the space that a container should leave at each of its
        // edges
        gbc.insets = new Insets(10, 0, 10, 0);

        createStartlabel();
        createStartButton();
        createStartlabel();
        // gridx and gridy determines in which cell your component will be placed
        // 0, 0 is the top left
        // The gridx and gridy is relative to the other components in the panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        // Add the label to the panel
        startScreen.add(startlabel, gbc);

        // Create the buttons
        createStartButton();
        createHelpButton();
        createExitButton();
        // Add the start button to the panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        startScreen.add(startButton, gbc);

        // Add the help button to the panel
        gbc.gridx = 0;
        gbc.gridy = 2;
        startScreen.add(helpButton, gbc);

        // Add the exit button to the panel
        gbc.gridx = 0;
        gbc.gridy = 3;
        startScreen.add(exitButton, gbc);
    }

    // //To test if the constructor is working
    // public static void main(String[] args) {
    // new StartFrame();
    // }
}