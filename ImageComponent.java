// import javax.swing.*;
// import java.awt.*;

// This class will load a file and create an image icon to be used in the panels
// public class ImageComponent extends ImageIcon {
//     // Constructor
//     public ImageComponent(String filename) {
//         super(filename);
//     }
    
//     // Another constructor that takes in the width and the size of the image icon and scales it to the desired size
//     public ImageComponent(String filename, int width, int height) {
//         super(new ImageIcon(filename).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
//     }
// }

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ImageComponent extends ImageIcon {
    public ImageComponent(String filename) throws IllegalArgumentException {
        // Check if the input filename is valid
        File file = new File(filename);
        if (!file.exists() || !file.canRead()) {
            // Throw an exception when there is an invalid file
            throw new IllegalArgumentException("Invalid file: " + filename);
        }
        // Super() cannot be used because it is not at the first line anymore hence need to use the setIamge() method which will set the icon of the ImageIcon object
        setImage(new ImageIcon(filename).getImage());
    }

    public ImageComponent(String filename, int width, int height) throws IllegalArgumentException {
        File file = new File(filename);
        if (!file.exists() || !file.canRead()) {
            throw new IllegalArgumentException("Invalid file: " + filename);
        }
        setImage(new ImageIcon(filename).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }
}
