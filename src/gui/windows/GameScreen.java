package gui.windows;
import javax.swing.*;

import controller.GameControl;
import gui.components.ClickableCard;
import gui.panels.BottomPanel;
import gui.panels.MiddlePanel;
import gui.panels.SidePanel;
import gui.panels.TopPanel;
import model.cards.Card;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GameScreen extends JFrame {
    // Set the dimensions of the Frame
    private final static  int windowHeight = 1200;  
    private final static int windowWidth = 800;            
    private final static int borderWidth = 100;      
    private final static int borderHeight = 100;
    private final static int hexColor = 0x085318; // The color of the poker table
    private final static Color backgroundColor = new Color(hexColor);

    // All of the panels and labels that will be in this frame
    private TopPanel northHand;
    private BottomPanel southHand;
    private JPanel centerPanel;
    private SidePanel leftPanel;
    private SidePanel  rightPanel;


    GameControl game;
    
    // Constructor to create the frame
    public GameScreen(GameControl game) {

        this.game = game; 
        game.startGame();

        try{
            // Create the frame for the application

            this.setTitle("Dai Di"); // Sets the title of the frame
            this.setSize(windowHeight, windowWidth); // Set the size of the frame
            this.setResizable(true); // Set the frame to be resizable
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the frame such that it will be closed upon pressing 'x'

            ImageIcon logo = new ImageIcon("images/logo.jpg"); //Set the image icon for the logo of the frame
            this.setIconImage(logo.getImage()); 
            this.getContentPane().setBackground(new Color(hexColor)); // Set the background color of the frame to the colour of the poker table
            this.setLocationRelativeTo(null); // Set the frame to appear in the middle of the screen
            

        }catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        
    
        // Add the different components to the panel

        // add other player hand displayed
        northHand = new TopPanel(this);
        this.add(northHand, BorderLayout.NORTH);

        // add hand and toplayarea

        southHand = new BottomPanel();
        southHand.setPreferredSize(new Dimension(borderWidth*2, borderHeight*2));
        this.add(southHand, BorderLayout.SOUTH);

        // add center pile containing prev pile and buttons

        centerPanel = new MiddlePanel(game, this);
        this.add(centerPanel, BorderLayout.CENTER);

        //add left and right player hand displayed

        leftPanel = new SidePanel(270);
        rightPanel = new SidePanel(90); // rotate 90 degrees

        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);
        

        this.updatePlayerHand();
        this.updateSidePanels();

    
        // Set the frame to be accessible
        this.setVisible(true);
    }

    public void updateToNextPlayer(){

        this.clearPlayerArea();
        this.updateSidePanels();
        this.updatePlayerHand();
    }

    public void updateSidePanels(){

        int curPlayerID = game.getCurrentPlayer();

        HashMap<Integer, Integer> cardCount = game.getSizeOfPlayersHand();

        int leftPlayer = curPlayerID - 1 == 0 ? 4:  curPlayerID - 1  ;
        int rightPlayer = curPlayerID % 4 + 1 ;
        int northPlayer = curPlayerID > 2 ? curPlayerID-2 : curPlayerID+2 ;

        int leftCardNo = cardCount.get(leftPlayer);
        int rightCardNo = cardCount.get(rightPlayer);
        int northCardNo = cardCount.get(northPlayer);

        leftPanel.setPlayerLabel(leftPlayer);
        rightPanel.setPlayerLabel(rightPlayer);
        northHand.setPlayerLabel(northPlayer);

        leftPanel.updateCardBacks(leftCardNo);
        rightPanel.updateCardBacks(rightCardNo);
        northHand.updateCardBacks(northCardNo);

        this.revalidate();
        
    }

    public void updatePlayerHand(){

        ArrayList<Card> cardsToLoad = game.getCurrentPlayerHand();
        JPanel hand = southHand.getHandArea();
        for ( Card card : cardsToLoad){
            ClickableCard cardButton = new ClickableCard(this, card, hand, southHand.getToPlayArea());
            hand.add(cardButton);
        }

        this.revalidate();
        this.setVisible(true);
    }

    public void clearPlayerArea(){
        JPanel playArea = southHand.getToPlayArea();
        JPanel hand = southHand.getHandArea();
        hand.removeAll();
        playArea.removeAll();
        hand.repaint();
        playArea.repaint();
        this.revalidate();
        
        
    }

    public BottomPanel getBottomPanel(){
        return southHand;
    }

    public void generateOtherPlayerCards(){
        
    }

    // To test if the constructor for this frame is working
    
}
