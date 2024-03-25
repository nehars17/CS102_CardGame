import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel {
    private final static int panelWidth = 100;
    private final static int panelHeight = 100;
    private JPanel playerNumberPanel;
    private int rotationAngle;
    private JPanel backofCardPanel;
    // private RotatedLabel rotatedLabel;
    
    public SidePanel(int rotationAngle, GameControl game) {

        this.rotationAngle = rotationAngle;

        this.setBackground(Color.RED);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(2*panelWidth, panelHeight));

        playerNumberPanel = new JPanel(new BorderLayout());
        playerNumberPanel.setBackground(Color.RED);
        
        
        // Create empty panels for trimming
        // JPanel leftEmptyPanel = new JPanel();
        // leftEmptyPanel.setBackground(color);
        // leftEmptyPanel.setPreferredSize(new Dimension(panelWidth/2, panelHeight/2));

        // JPanel rightEmptyPanel = new JPanel();
        // rightEmptyPanel.setBackground(color);
        // rightEmptyPanel.setPreferredSize(new Dimension(panelWidth/2, panelHeight/2));


        JPanel centerPanel = new JPanel( new GridLayout(2,1));
        
        
        // Add the player number panel and empty panels to trim the main panel
        add(centerPanel, BorderLayout.CENTER);
        // add(leftEmptyPanel, BorderLayout.SOUTH);
        // add(rightEmptyPanel, BorderLayout.NORTH);
        add(playerNumberPanel, BorderLayout.WEST);

        
    }

    // Create and add the RotatedLabel for the player number

    // public void setPlayerLabel( int playerNumber){

    //     rotatedLabel = new RotatedLabel(playerNumber, rotationAngle);
    //     playerNumberPanel.add(rotatedLabel, BorderLayout.CENTER);
    //     playerNumberPanel.repaint();
        
    // }

}
        
