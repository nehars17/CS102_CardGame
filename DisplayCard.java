
import javax.swing.*;

public class DisplayCard extends JLabel{

    public DisplayCard(Card card){
        super(new ImageComponent(card.getImagePath()));
        
    }

}
