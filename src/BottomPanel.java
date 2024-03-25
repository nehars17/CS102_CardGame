import java.awt.*;
import javax.swing.*;

public class BottomPanel extends JPanel {

    private final int colorCode = 0x085318; //color of background
    private final Color emptyPanelColor = new Color(colorCode);
    private final int borderHeight = 200;
    private final int borderWidth = 200;
    private final Dimension emptyPanelDimensions = new Dimension(borderWidth, borderHeight); 
    private JPanel toPlayArea;
    private JPanel handArea;
    
    
    public BottomPanel(){
        this.setLayout(new BorderLayout());
        this.setBackground(emptyPanelColor);
        // this.trimPanel();
        this.addCardAreas();

        this.setBorder(BorderFactory.createEmptyBorder());

    } 

    private void addCardAreas(){

        toPlayArea = new ToPlayArea();
        handArea = new HandArea();

        
        JPanel formatCardPanels = new JPanel( new GridLayout(2, 1));    // gridlayout of 2 rows 1 col to stack playArea and handArea
        formatCardPanels.setBackground(emptyPanelColor);
        formatCardPanels.add( toPlayArea);
        formatCardPanels.add( handArea);

        this.add(formatCardPanels, BorderLayout.CENTER);        
    }

    private void trimPanel(){
        this.add(createEmptyPanel(),BorderLayout.WEST);
        this.add(createEmptyPanel(),BorderLayout.EAST);

    }

    private JPanel createEmptyPanel(){
        JPanel emptyPanel = new JPanel();
        this.setBackground(emptyPanelColor);
        this.setPreferredSize(emptyPanelDimensions);
        return emptyPanel;
    }

    public JPanel getToPlayArea() {
        return toPlayArea;
    }

    public JPanel getHandArea() {
        return handArea;
    }

    

}

