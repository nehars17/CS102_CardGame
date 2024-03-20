import javax.swing.*;
import java.awt.*;

// Frame layout
// __________________________________
// |             North              |
// |--------------------------------|
// |  E  |                    |  W  | 
// |  a  |       Center       |  e  |  
// |  s  |                    |  s  |
// |  t  |                    |  t  |
// |--------------------------------|
// |           Play-area            |
// |--------------------------------|
// |              Hand              |
// |________________________________|

public class InitializeGame {
    
    private final static  int windowHeight = 1200;  
    private final static int windowWidth = 800;            
    private final static int borderWidth = 50;      
    private final static int borderHeight = 50;     

    public static JFrame createFrame(){
        //initialise frame settings

        JFrame gameWindow = new JFrame("Tai Tee");

        gameWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // makes the X  delete window button work
        gameWindow.setSize(windowHeight, windowWidth); // sets size of window
        gameWindow.setLocationRelativeTo(null); // make window open in middle of screen
        gameWindow.setResizable(false);

        gameWindow.setLayout( new BorderLayout());

        addLayoutComponents(gameWindow);

        gameWindow.setVisible(true); // display added components

        return gameWindow;

    }

    private static void addLayoutComponents(JFrame gameWindowFrame){

        JPanel northHand = new JPanel(new FlowLayout(0, borderWidth, borderHeight));
        JPanel eastHand = new JPanel( new FlowLayout(0, borderWidth, borderHeight));
        JPanel westHand = new JPanel( new FlowLayout(0, borderWidth, borderHeight));
        JPanel centerPanel = new JPanel( new BorderLayout());
        JPanel playerArea = new  JPanel(new GridLayout(2,1, 100, 100)); // inclusive of player hands and play

        setupOtherHand(northHand, "p1");
        setupOtherHand(westHand, "p2");
        setupOtherHand(eastHand, "p3");

        gameWindowFrame.add(northHand, BorderLayout.NORTH);
        gameWindowFrame.add(eastHand, BorderLayout.EAST);
        gameWindowFrame.add(westHand, BorderLayout.WEST);
        gameWindowFrame.add(playerArea, BorderLayout.SOUTH);


    }

    private static void setupOtherHand( JPanel handPanel, String playerString){
        // handPanel.setBackground(null);
        handPanel.add(createPlayerLabel(playerString)); //playername is added
    }

    private static JLabel createPlayerLabel ( String playerName){
        return new JLabel(playerName);
    }

}
