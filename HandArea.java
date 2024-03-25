

import java.awt.*;
import javax.swing.*;

public class HandArea extends JPanel{

    private final static int hexColor = 0x085318; // The color of the poker table
    private final static Color backgroundColor = new Color(hexColor);

    public HandArea(){
        this.setLayout( new GridBagLayout());
        this.setBackground(backgroundColor);
    }


}
