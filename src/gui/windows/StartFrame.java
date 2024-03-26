package gui.windows;

import controller.GameControl;
import gui.components.ImageComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The initial frame of the game, providing options to start the game, view help, or exit.
 */
public class StartFrame extends JFrame {
    private static final int WINDOW_HEIGHT = 1200;
    private static final int WINDOW_WIDTH = 800;
    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 80;
    private static final int HEX_COLOR = 0x085318; // The color of the poker table

    private JPanel startScreen;
    private JLabel startLabel;
    private JButton startButton;
    private JButton helpButton;
    private JButton exitButton;

    private final GameControl gameControl;

    /**
     * Constructs the StartFrame with a reference to the game control.
     * 
     * @param gameControl The game control object to interact with the game logic.
     */
    public StartFrame(GameControl gameControl) {
        this.gameControl = gameControl;
        initializeFrame();
        createStartScreen();
        this.add(startScreen);
        this.setVisible(true);
    }

    /**
     * Initializes the frame's basic properties.
     */
    private void initializeFrame() {
        this.setTitle("Dai Di");
        this.setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            ImageComponent logo = new ImageComponent("images/logo.jpg");
            this.setIconImage(logo.getImage());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        this.getContentPane().setBackground(new Color(HEX_COLOR));
        this.setLocationRelativeTo(null);
    }

    /**
     * Creates the start screen layout with buttons and a welcome message.
     */
    private void createStartScreen() {
        startScreen = new JPanel(new GridBagLayout());
        startScreen.setBackground(new Color(HEX_COLOR));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);

        createStartLabel(gbc);
        createButtons(gbc);
    }

    /**
     * Creates the start screen label with game instructions or welcome message.
     * 
     * @param gbc The GridBagConstraints object to manage layout constraints.
     */
    private void createStartLabel(GridBagConstraints gbc) {
        try {
            ImageComponent startImage = new ImageComponent("images/startscreen.png", 330, 280);
            startLabel = new JLabel();
            startLabel.setIcon(new ImageIcon(startImage.getImage()));
            startLabel.setText("<html><div style='text-align: center;'>Welcome to Dai Di!<br>A 4 player game of luck and skill</div></html>");
            startLabel.setFont(new Font("Roboto", Font.BOLD, 30));
            startLabel.setForeground(Color.WHITE);
            startLabel.setHorizontalTextPosition(JLabel.CENTER);
            startLabel.setVerticalTextPosition(JLabel.BOTTOM);
            gbc.gridx = 0;
            gbc.gridy = 0;
            startScreen.add(startLabel, gbc);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the buttons for starting the game, viewing help, and exiting the game.
     * 
     * @param gbc The GridBagConstraints object to manage layout constraints.
     */
    private void createButtons(GridBagConstraints gbc) {
        createStartButton();
        gbc.gridx = 0;
        gbc.gridy = 1;
        startScreen.add(startButton, gbc);

        createHelpButton();
        gbc.gridy = 2;
        startScreen.add(helpButton, gbc);

        createExitButton();
        gbc.gridy = 3;
        startScreen.add(exitButton, gbc);
    }

    private void createStartButton() {
        startButton = new JButton("Start Game");
        configureButton(startButton, "images/play.jpg", e -> {
            dispose(); // Close the current window
            new GameScreen(gameControl); // Open the main game window
        });
    }
    
    private void createHelpButton() {
        helpButton = new JButton("Help");
        configureButton(helpButton, "images/help.png", e -> {
            // Display help dialog or window
            JOptionPane.showMessageDialog(this, "Game Rules:\n[Insert game rules here]", "Help", JOptionPane.INFORMATION_MESSAGE);
        });
    }
    
    private void createExitButton() {
        exitButton = new JButton("Exit Game");
        configureButton(exitButton, "images/exit.png", e -> System.exit(0)); // Exit the application
    }
    
    /**
     * Configures a JButton with the provided text, icon, and action listener.
     * 
     * @param button      The button to configure.
     * @param iconPath    Path to the icon image.
     * @param action      ActionListener to be attached to the button.
     */
    private void configureButton(JButton button, String iconPath, ActionListener action) {
        button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button.setFont(new Font("Roboto", Font.BOLD, 20));
        button.setForeground(Color.RED);
        try {
            Image img = new ImageIcon(iconPath).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            e.printStackTrace();
            button.setIcon(null); // Fallback to no icon in case of failure
        }
        button.setHorizontalTextPosition(JButton.RIGHT);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setBackground(Color.WHITE);
        button.setFocusable(false);
        button.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        button.addActionListener(action);
    }
    
}
