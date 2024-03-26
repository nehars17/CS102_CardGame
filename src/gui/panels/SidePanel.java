package gui.panels;

import gui.components.DisplayCard;
import gui.components.RotatedLabel;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel {
    private final static int panelWidth = 180;
    private final static int panelHeight = 100;
    private int rotationAngle;
    private JPanel backofCardPanel = new JPanel(new GridBagLayout());
    private RotatedLabel rotatedLabel;
    private GridBagConstraints constraints = new GridBagConstraints();
    private final static int hexColor = 0x085318; // The color of the poker table
    private final static Color backgroundColor = new Color(hexColor);

    public SidePanel(int rotationAngle) {

        this.rotationAngle = rotationAngle;

        this.setLayout(new BorderLayout());
        this.setBackground(backgroundColor);
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));

        rotatedLabel = new RotatedLabel("Player", rotationAngle);
        rotatedLabel.setForeground(Color.WHITE);
        rotatedLabel.setFont(new Font("Roboto", Font.BOLD, 20));

        if (rotationAngle == 90) {
            this.add(rotatedLabel, BorderLayout.EAST);
        } else {
            this.add(rotatedLabel, BorderLayout.WEST);
        }

        backofCardPanel.setBackground(backgroundColor);

        add(backofCardPanel, BorderLayout.CENTER);
    }

    // Create and add the RotatedLabel for the player number

    public void setPlayerLabel(int playerNumber) {

        rotatedLabel.setText("Player " + playerNumber);

    }

    public void updateCardBacks(int sizeOfPlayersHand) {
        backofCardPanel.removeAll();

        constraints.gridx = 0;
        constraints.weighty = 0.01;

        for (int i = 0; i < sizeOfPlayersHand; i++) {
            constraints.gridy = i;
            RotatedLabel cardback = new RotatedLabel(DisplayCard.getCardBack(), rotationAngle);
            backofCardPanel.add(cardback, constraints);

        }

        this.repaint();

    }
}
