package gui.panels;

import controller.GameControl;
import gui.components.DisplayCard;
import gui.windows.StartFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Represents the top panel in the game UI, displaying player information and providing an exit button.
 */
public class TopPanel extends JPanel {
    private static final Color BACKGROUND_COLOR = new Color(0x085318); // The color of the poker table
    private static final int BORDER_WIDTH = 100;
    private static final int BORDER_HEIGHT = 100;

    private JButton exitGameButton;
    private JLabel playerLabel;
    private JPanel cardPanel = new JPanel(new GridBagLayout());
    private GridBagConstraints constraints = new GridBagConstraints();

    private JFrame gameScreen;

    /**
     * Constructs a TopPanel with references to the game control logic and the main game screen.
     *
     * @param gameScreen The JFrame on which the game is displayed.
     */
    public TopPanel(JFrame gameScreen) {
        this.gameScreen = gameScreen;
        setBackground(BACKGROUND_COLOR);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(BORDER_WIDTH, BORDER_HEIGHT + 50));

        initializeComponents();
    }

    /**
     * Initializes and arranges the components within the panel.
     */
    private void initializeComponents() {
        createExitGameButton();
        createPlayerLabel();
        configureCardPanel();

        // Creating empty panels for padding
        JPanel leftPadding = createPaddingPanel();
        JPanel rightPadding = createPaddingPanel();

        leftPadding.add(exitGameButton);

        add(leftPadding, BorderLayout.WEST);
        add(createMiddlePanel(), BorderLayout.CENTER);
        add(rightPadding, BorderLayout.EAST);
    }

    /**
     * Creates the exit game button and configures its action.
     */
    private void createExitGameButton() {
        exitGameButton = new JButton("X");
        exitGameButton.setPreferredSize(new Dimension(BORDER_WIDTH, BORDER_HEIGHT));
        exitGameButton.setFont(new Font("Futura", Font.BOLD, 50));
        exitGameButton.setHorizontalTextPosition(JButton.LEFT);
        exitGameButton.setVerticalTextPosition(JButton.TOP);
        exitGameButton.setFocusable(false);
        exitGameButton.setBorderPainted(false);
        exitGameButton.setContentAreaFilled(false);
        exitGameButton.setForeground(Color.RED);

        exitGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gameScreen.dispose(); // Close the current game screen
                new StartFrame(new GameControl()); // Return to the start screen
            }
        });
    }

    /**
     * Creates the label to display player information.
     */
    private void createPlayerLabel() {
        playerLabel = new JLabel("Player ", SwingConstants.CENTER);
        playerLabel.setForeground(Color.WHITE);
        playerLabel.setFont(new Font("Roboto", Font.BOLD, 20));
    }

    /**
     * Configures the card panel to display a visual representation of the player's hand.
     */
    private void configureCardPanel() {
        cardPanel.setBackground(BACKGROUND_COLOR);
    }

    /**
     * Creates a JPanel for padding purposes with the background color set.
     *
     * @return A JPanel used for padding.
     */
    private JPanel createPaddingPanel() {
        JPanel paddingPanel = new JPanel();
        paddingPanel.setBackground(BACKGROUND_COLOR);
        paddingPanel.setPreferredSize(new Dimension(BORDER_WIDTH, BORDER_HEIGHT));
        return paddingPanel;
    }

    /**
     * Creates and configures the middle panel containing the player label and card display.
     *
     * @return The configured JPanel.
     */
    private JPanel createMiddlePanel() {
        JPanel middlePanel = new JPanel(new BorderLayout());
        middlePanel.setBackground(BACKGROUND_COLOR);
        middlePanel.add(playerLabel, BorderLayout.NORTH);
        middlePanel.add(cardPanel, BorderLayout.CENTER);
        return middlePanel;
    }

    /**
     * Updates the player label and card backs based on the current player's hand size.
     *
     * @param playerNo The number of the current player.
     * @param sizeOfPlayersHand The number of cards in the player's hand.
     */
    public void updatePlayerAndCards(int playerNo, int sizeOfPlayersHand) {
        setPlayerLabel(playerNo);
        updateCardBacks(sizeOfPlayersHand);
    }

    /**
     * Updates the displayed card backs to match the size of the player's hand.
     *
     * @param sizeOfPlayersHand The size of the player's hand.
     */
    public void updateCardBacks(int sizeOfPlayersHand) {
        cardPanel.removeAll();

        constraints.gridy = 1;
        constraints.weightx = 0.1;

        for (int i = 0; i < sizeOfPlayersHand; i++) {

            constraints.gridx = i;
            DisplayCard cardBack = new DisplayCard();
            cardPanel.add(cardBack, constraints);
        }

        cardPanel.revalidate();
        cardPanel.repaint();
    }

    /**
     * Sets the player label to display the specified player number.
     *
     * @param playerNo The player number to display.
     */
    public void setPlayerLabel(int playerNo) {
        playerLabel.setText("Player " + playerNo);
    }
}

