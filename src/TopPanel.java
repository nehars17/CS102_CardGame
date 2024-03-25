import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TopPanel extends JPanel {
    // The dimensions of the panel
    private final static  int windowHeight = 1200;  
    private final static int windowWidth = 800;            
    private final static int borderWidth = 100;      
    private final static int borderHeight = 100;
    private final static int hexColor = 0x085318; // The color of the poker table 
    private final static Color backgroundColor = new Color(hexColor);
    
    // The componenets of this panel
    private JButton exitGameButton;
    private JPanel leftEmptyPanel;
    private JPanel rightEmptyPanel;
    private JPanel middlePanel = new JPanel(new BorderLayout());
    private JLabel playerLabel;
    private int playerNo;
    private JPanel cardPanel = new JPanel(new GridBagLayout());
    private GridBagConstraints constraints = new GridBagConstraints();

    private JFrame gameScreen;

    // The constructor for the panel
    public TopPanel(JFrame gameScreen) {

        this.gameScreen = gameScreen;
        // Set the size of the panel
        this.setPreferredSize(new Dimension(borderWidth, borderHeight + 50));
        // Set the background color of the panel
        this.setBackground(backgroundColor);
        trimPanel();

        // Create the exit button for the left panel
        createExitGameButton();
        // Add the button to the left panel
        leftEmptyPanel.add(exitGameButton);

        // Create the player label
        createPlayerLabel();

        cardPanel.setBackground(new Color(hexColor));

        playerLabel.setHorizontalTextPosition(JLabel.CENTER);

        // Add the player label to the middle panel
        middlePanel.add(playerLabel, BorderLayout.NORTH);
        middlePanel.add(cardPanel, BorderLayout.CENTER);

        // Add cardbacks
        
         
    }

    private void trimPanel() {
        // Trim the top panel to the prefered size
        leftEmptyPanel = new JPanel();
        leftEmptyPanel.setBackground(new Color(hexColor));
        leftEmptyPanel.setPreferredSize(new Dimension(borderWidth + 80, borderHeight + 80));

        rightEmptyPanel = new JPanel();
        rightEmptyPanel.setBackground(new Color(hexColor));
        rightEmptyPanel.setPreferredSize(new Dimension(borderWidth + 80, borderHeight + 80));
        // Create the middle panel that will not be trimmed
        middlePanel = new JPanel(new BorderLayout());

        this.setLayout(new BorderLayout());
        middlePanel.setBackground(new Color(hexColor));
        this.add(leftEmptyPanel, BorderLayout.WEST);
        this.add(middlePanel, BorderLayout.CENTER);
        this.add(rightEmptyPanel, BorderLayout.EAST); 
    }

    private void createExitGameButton() {
        // Load the new icon for the button
        exitGameButton = new JButton("X");
        // Set the size of the button
        exitGameButton.setPreferredSize(new Dimension(borderWidth + 80, borderHeight + 80));
        // Set the font size and style of the text in the button
        exitGameButton.setFont(new Font("Futura", Font.BOLD , 90)); //| Font.ITALIC
        // Set the text to be in the centre of the button
        exitGameButton.setVerticalTextPosition(JButton.CENTER);
        // Remove the border around x
        exitGameButton.setFocusable(false);
        exitGameButton.setBorderPainted(false);
        exitGameButton.setContentAreaFilled(false);

        // Add a mouse listener to the button
        exitGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // When the 'x' button is clicked, the game will be killed and return back to the start screen
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(exitGameButton);

                // Dispose the current Frame
                if (topFrame != null) {
                    topFrame.dispose();
                }
                // Call the StartFrame
                gameScreen.dispose();
                JFrame newGame = new StartFrame( new GameControl() );
            }
        });
    }

    public void createPlayerLabel() {
        // Get the string consisting of the player number
        String display = "Player ";
        playerLabel = new JLabel(display);
        // Set the font and the size of the player label
        playerLabel.setFont(new Font("Roboto", Font.BOLD, 20));
    }

    // Getters and setters to get the player number
    public int getPlayerNo() {
        return playerNo;
    }

    public void setPlayerNo(int playerNo) {
        this.playerNo = playerNo;
    }

    // Getter method to retrieve the middle panel, the middle panel will be where we are updating the player cards and the player label every time it is changed to the next player
    public JPanel getMiddlePanel() {
        return middlePanel;
    }

    public void setMiddlePanel(JPanel middlePanel) {
        this.middlePanel = middlePanel;
    }

    public void setPlayerLabel(int playerNo){
        playerLabel.setText("Player "+playerNo);

    }


    public void updateCardBacks(int sizeOfPlayersHand){
        cardPanel.removeAll();
        constraints.gridy = 0;
        constraints.weightx = 0.01;

        for (int i = 0; i < sizeOfPlayersHand; i++){
            DisplayCard cardback = new DisplayCard();
            constraints.gridx = i;
            cardPanel.add(cardback, constraints);
            
        }

        this.repaint();
    
       
    }
}
