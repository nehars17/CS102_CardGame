import java.awt.*;
import javax.swing.*;
import java.util.ArrayList.*;


public class MiddlePanel extends JPanel {

    private MiddleButtonPanel buttonPanel;
    private JPanel middlePile;
    private final static int hexColor = 0x085318; // The color of the poker table
    private final static Color backgroundColor = new Color(hexColor);
    
    
    
    public MiddlePanel(GameControl game, GameScreen gameScreen){

        
        middlePile = new JPanel(new GridBagLayout()); 
        middlePile.setBackground(backgroundColor);
        JPanel whileEmpty = new JPanel();
        whileEmpty.setBackground(backgroundColor);
        
        middlePile.add(whileEmpty);


        
        buttonPanel = new MiddleButtonPanel( game, gameScreen, middlePile);
        this.setLayout(new GridLayout(2,1));
        
        
        this.add(middlePile);
        this.add(buttonPanel);

    }
}
