import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class DisplayCard extends JLabel{
    private static final String cardBackPath = "./cardassets/cardback.png";
    private static final int cardBackWidth = 73;
    private static final int cardBackHeight = 97;

    public DisplayCard(Card card){
        super(new ImageComponent(card.getImagePath()));
        
    }

    public DisplayCard(){
        super(new ImageComponent(cardBackPath, cardBackWidth, cardBackHeight));
        
    }

    public static ImageComponent getCardBack(){
        return new ImageComponent(cardBackPath,cardBackWidth, cardBackHeight);
    }



}
