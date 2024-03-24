import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.ArrayList.*;

public class MiddleButtonPanel extends JPanel{

    private JButton playButton;
    private JButton passButton;
    private GameControl game;
    private GameScreen gameFrame;
    
    public MiddleButtonPanel(GameControl game, GameScreen gameFrame, JPanel middlePile){
        this.setLayout(new GridLayout(1,2));

        ToPlayArea playArea = (ToPlayArea)gameFrame.getBottomPanel().getToPlayArea();
        
        playButton = new PlayButton(game,  middlePile , playArea, gameFrame);
        passButton = new PassButton(game, gameFrame);
        
        this.add(playButton);
        this.add(passButton);
        
    }


    // public static void main(String[] args) {
    //     GameControl gc = new GameControl();
    //     new MiddleButtonPanel(gc, new GameScreen(gc), new JPanel());
    // }

    

}
