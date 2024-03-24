import java.awt.*;
import javax.swing.*;
import java.util.ArrayList.*;


public class MiddlePanel extends JPanel {

    private MiddleButtonPanel buttonPanel;
    private JPanel middlePile;
    
    
    public MiddlePanel(GameControl game, GameScreen gameScreen){

        
        middlePile = new JPanel(new GridBagLayout()); 
        JPanel whileEmpty = new JPanel();
        middlePile.add(whileEmpty);

        
        buttonPanel = new MiddleButtonPanel( game, gameScreen, middlePile);
        this.setLayout(new GridLayout(2,1));
        
        
        this.add(middlePile);
        this.add(buttonPanel);

    }
}
