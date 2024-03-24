import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test {
    public static void main(String[] args) {
        // create a new frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setResizable(true);
        frame.getContentPane().setBackground(Color.green);
        frame.setLayout(new GridBagLayout()); // Change layout to GridBagLayout

        // Create a new panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setPreferredSize(new Dimension(500,500));
        panel.setLayout(new GridBagLayout());

        // Create a GridBagConstraints object
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 0); // Add padding to the components

        // Create a label
        JLabel label = new JLabel("Hello World");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(label, gbc);

        // Ceate a new panel
        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(500,400));
        panel2.setLayout(new FlowLayout()); // Change layout to FlowLayout (default layout manager for JPanel
        panel2.setBackground(Color.RED);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(panel2, gbc);

        // Add a mouse listener to the panel
        panel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse Clicked");
                panel.removeAll();
                panel.revalidate();
                panel.repaint();
            }
        });



        frame.add(panel, gbc); // Add the panel to the frame with the GridBagConstraints object

        frame.setVisible(true);
    }
}