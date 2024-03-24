import javax.swing.*;
import java.awt.*;

// This class will load a file and create an image icon to be used in the panels
public class ImageComponent extends ImageIcon {
    // Constructor
    public ImageComponent(String filename) {
        super(filename);
    }
    
    // Another constructor that takes in the width and the size of the image icon and scales it to the desired size
    public ImageComponent(String filename, int width, int height) {
        super(new ImageIcon(filename).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }
}
