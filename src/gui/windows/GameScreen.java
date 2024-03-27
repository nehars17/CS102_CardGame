package gui.windows;

import controller.GameControl;
import model.cards.Card;
import gui.components.ClickableCard;
import gui.panels.BottomPanel;
import gui.panels.MiddlePanel;
import gui.panels.SidePanel;
import gui.panels.TopPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The main game window for the Big Two card game. It initializes and displays
 * the game board, player hands, and control panels.
 */
public class GameScreen extends JFrame {
    // Dimensions and color constants for the frame
    private static final int WINDOW_HEIGHT = 1200;
    private static final int WINDOW_WIDTH = 800;
    private static final int BORDER_WIDTH = 100;
    private static final int BORDER_HEIGHT = 100;
    private static final int HEX_COLOR = 0x085318; // The color of the poker table

    // Panels for displaying different aspects of the game
    private TopPanel northHand;
    private BottomPanel southHand;
    private MiddlePanel centerPanel;
    private SidePanel leftPanel;
    private SidePanel rightPanel;

    private final GameControl game;

    /**
     * Constructs the game screen, setting up the game environment and UI components.
     *
     * @param game The game control logic.
     */
    public GameScreen(GameControl game) {
        this.game = game;
        game.startGame();
        initializeFrame();
        layoutComponents();
        updatePlayerHand();
        updateSidePanels();
        this.setVisible(true); // Make the frame visible after all components are added
    }

    /**
     * Initializes the frame's properties such as title, size, and close operation.
     */
    private void initializeFrame() {
        this.setTitle("Dai Di");
        this.setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon logo = new ImageIcon("images/logo.jpg");
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(new Color(HEX_COLOR));
        this.setLocationRelativeTo(null); // Center the window on the screen
    }

    /**
     * Lays out the components on the game screen, including player hands and the central play area.
     */
    private void layoutComponents() {
        northHand = new TopPanel(this);
        this.add(northHand, BorderLayout.NORTH);

        southHand = new BottomPanel();
        southHand.setPreferredSize(new Dimension(BORDER_WIDTH * 2, BORDER_HEIGHT * 2));
        this.add(southHand, BorderLayout.SOUTH);

        centerPanel = new MiddlePanel(game, this);
        this.add(centerPanel, BorderLayout.CENTER);

        leftPanel = new SidePanel(270); // Rotate 270 degrees for left side
        rightPanel = new SidePanel(90); // Rotate 90 degrees for right side
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);
    }

    /*
     * Updates the game UI to reflect the next player's turn. 
     */
    public void updateToNextPlayer() {
        clearPlayerArea();
        updateSidePanels();
        updatePlayerHand();
        updateIfNewRound();

    }

    /**
     * Updates the side panels with the current status of the game, including player hands.
     */
    public void updateSidePanels() {
        int curPlayerID = game.getCurrentPlayer();
        HashMap<Integer, Integer> cardCount = game.getSizeOfPlayersHand();

        // Calculate player positions relative to the current player
        int leftPlayer = curPlayerID - 1 == 0 ? 4 : curPlayerID - 1;
        int rightPlayer = curPlayerID % 4 + 1;
        int northPlayer = curPlayerID > 2 ? curPlayerID - 2 : curPlayerID + 2;

        // Update the card backs and player labels for side panels
        leftPanel.setPlayerLabel(leftPlayer);
        rightPanel.setPlayerLabel(rightPlayer);
        northHand.setPlayerLabel(northPlayer);

        leftPanel.updateCardBacks(cardCount.get(leftPlayer));
        rightPanel.updateCardBacks(cardCount.get(rightPlayer));
        northHand.updateCardBacks(cardCount.get(northPlayer));

        this.revalidate();
    }

    /**
     * Updates the current player's hand display.
     */
    public void updatePlayerHand() {
        ArrayList<Card> cardsToLoad = game.getCurrentPlayerHand();
        JPanel hand = southHand.getHandArea();
        hand.removeAll(); // Clear the hand area before adding new cards
        for (Card card : cardsToLoad) {
            ClickableCard cardButton = new ClickableCard(this, card, hand, southHand.getToPlayArea());
            hand.add(cardButton);
        }

        this.revalidate();
        this.repaint();
    }

    /**
     * Clears the play area and the player's current hand display in preparation for the next turn.
     */
    public void clearPlayerArea() {
        JPanel playArea = southHand.getToPlayArea();
        JPanel hand = southHand.getHandArea();
        hand.removeAll();
        playArea.removeAll();
        hand.repaint();
        playArea.repaint();
        this.revalidate();
    }

    /*
     * Function call to update the middle panel to inform the player if it is a new round
     */

    public void updateIfNewRound(){
        if (!game.playerAllowedToPass()){
            JPanel middlePile = centerPanel.getMiddlePile();
            middlePile.removeAll();

            JLabel informPlayer = new JLabel("All other players have passed, new round started.");
            informPlayer.setFont(new Font ("Roboto", Font.BOLD, 20));
            informPlayer.setForeground(Color.WHITE);

            middlePile.add(informPlayer);
        }
    }

    /**
     * Retrieves the bottom panel of the game screen. This is primarily used for
     * adding or removing components dynamically during the game.
     *
     * @return The bottom panel of the game screen.
     */
    public BottomPanel getBottomPanel() {
        return southHand;
    }
}
