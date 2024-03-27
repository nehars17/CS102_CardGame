package gui.windows;

import controller.GameControl;
import gui.components.ImageComponent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * This class represents the start frame of the game, providing a graphical user interface
 * for the user to interact with at the beginning of the application. It allows the user to
 * start the game, access help information, or exit the application.
 */
public class StartFrame extends JFrame {
    private final static int windowHeight = 1200;
    private final static int windowWidth = 800;
    private final static int buttonWidth = 200;
    private final static int buttonHeight = 80;
    private final static int hexColor = 0x085318; // The color of the poker table

    private JPanel startScreen;
    private JLabel startlabel;
    private JButton startButton;
    private JButton helpButton;
    private JButton exitButton;

    private GameControl gameControl;

    /**
     * Constructs a StartFrame with a reference to the GameControl.
     * It initializes the frame, setting up the UI components and event listeners.
     * 
     * @param gameControl A reference to the game control class for game logic management.
     */
    public StartFrame(GameControl gameControl) {
        this.gameControl = gameControl;
        try {
            this.setTitle("Dai Di");
            this.setSize(windowHeight, windowWidth);
            this.setResizable(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ImageComponent logo = new ImageComponent("images/logo.jpg");
            this.setIconImage(logo.getImage());
            this.getContentPane().setBackground(new Color(hexColor));
            this.setLocationRelativeTo(null);

            createStartScreen();

            this.add(startScreen);

            this.setVisible(true);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes the label for the start screen with game title and description.
     */
    private void createStartlabel() {
        try {
            ImageComponent startImage = new ImageComponent("images/startscreen.png", 330, 280);
            startlabel = new JLabel();
            startlabel.setIcon(startImage);
            startlabel.setText("<html><div style='text-align: center;'>Welcome to Dai Di!!!<br>A 4 player game of luck and skill</div></html>");
            startlabel.setFont(new Font("Roboto", Font.BOLD, 30));
            startlabel.setForeground(Color.WHITE);
            startlabel.setHorizontalTextPosition(JLabel.CENTER);
            startlabel.setVerticalTextPosition(JLabel.BOTTOM);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes the start button with properties and event handling to start the game.
     */
    private void createStartButton() {
        try {
            startButton = new JButton("Start Game");
            startButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
            startButton.setFont(new Font("Roboto", Font.BOLD, 20));
            startButton.setForeground(Color.RED);
            ImageComponent resizedIcon = new ImageComponent("images/play.jpg", 50, 50);
            startButton.setIcon(resizedIcon);

            startButton.setHorizontalTextPosition(JButton.LEFT);
            startButton.setVerticalTextPosition(JButton.CENTER);
            startButton.setBackground(Color.WHITE);
            startButton.setFocusable(false);
            startButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());

            startButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    dispose();
                    new GameScreen(gameControl);
                }
            });
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes the exit button with properties and event handling to exit the application.
     */
    private void createExitButton() {
        try {
            exitButton = new JButton("Exit Game");
            exitButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
            exitButton.setFont(new Font("Roboto", Font.BOLD, 20));
            exitButton.setForeground(Color.RED);
            ImageComponent resizedIcon2 = new ImageComponent("images/exit.png", 50, 50);
            exitButton.setIcon(resizedIcon2);

            exitButton.setVerticalAlignment(JButton.CENTER);
            exitButton.setHorizontalAlignment(JButton.RIGHT);
            exitButton.setHorizontalTextPosition(JButton.LEFT);
            exitButton.setVerticalTextPosition(JButton.CENTER);

            exitButton.setBackground(Color.WHITE);
            exitButton.setFocusable(false);
            exitButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());

            exitButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.exit(0);
                }
            });
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes the help button with properties and
     * event handling to display game rules to the user.
     */
    private void createHelpButton() {
        helpButton = new JButton("Help");
        helpButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        helpButton.setFont(new Font("Roboto", Font.BOLD, 20));
        helpButton.setForeground(Color.RED);
        ImageComponent resizedIcon2 = new ImageComponent("images/help.png", 50, 50);
        helpButton.setIcon(resizedIcon2);

        helpButton.setVerticalAlignment(JButton.CENTER);
        helpButton.setHorizontalAlignment(JButton.RIGHT);
        helpButton.setHorizontalTextPosition(JButton.LEFT);
        helpButton.setVerticalTextPosition(JButton.CENTER);

        helpButton.setBackground(Color.WHITE);
        helpButton.setFocusable(false);
        helpButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        helpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JEditorPane editorPane = new JEditorPane();
                editorPane.setEditable(false);
                editorPane.setContentType("text/html");

                try {
                    File htmlFile = new File("src/textassets/rules.html");
                    editorPane.setPage(htmlFile.toURI().toURL());
                } catch (IOException ex) {
                    ex.printStackTrace();
                    editorPane.setText("Failed to load the rules.");
                }

                JScrollPane scrollPane = new JScrollPane(editorPane);
                scrollPane.setPreferredSize(new Dimension(500, 500));

                JOptionPane.showMessageDialog(StartFrame.this, scrollPane, "Game Rules", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    /**
     * Initializes and arranges all UI components on the start screen using a GridBagLayout.
     */
    private void createStartScreen() {
        startScreen = new JPanel(new GridBagLayout());
        startScreen.setBackground(new Color(hexColor));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);

        createStartlabel();
        createStartButton();
        createHelpButton();
        createExitButton();

        gbc.gridx = 0;
        gbc.gridy = 0;
        startScreen.add(startlabel, gbc);

        gbc.gridy = 1;
        startScreen.add(startButton, gbc);

        gbc.gridy = 2;
        startScreen.add(helpButton, gbc);

        gbc.gridy = 3;
        startScreen.add(exitButton, gbc);
    }
}

