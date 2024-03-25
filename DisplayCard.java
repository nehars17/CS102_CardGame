import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class DisplayCard extends JLabel{
    private static final String cardBackPath = "./cardassets/cardback.png";

    public DisplayCard(Card card){
        super(new ImageComponent(card.getImagePath()));
        
    }

    public DisplayCard(){
        super(new ImageComponent(cardBackPath, 73, 97));
    }



}
