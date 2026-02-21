import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleUIApp {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Simple UI Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Create a panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        panel.setBackground(new Color(240, 240, 240));

        // Create a label for input instruction
        JLabel inputLabel = new JLabel("Enter text:");
        inputLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(inputLabel);

        // Create a text field
        JTextField textField = new JTextField(20);
        textField.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(textField);

        // Create a display button
        JButton displayButton = new JButton("Display");
        displayButton.setFont(new Font("Arial", Font.BOLD, 12));
        displayButton.setPreferredSize(new Dimension(100, 30));
        panel.add(displayButton);

        // Create a label to show the output
        JLabel outputLabel = new JLabel("Output will appear here");
        outputLabel.setFont(new Font("Arial", Font.ITALIC, 13));
        outputLabel.setForeground(new Color(0, 100, 200));
        panel.add(outputLabel);

        // Add action listener to the display button
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                if (text.isEmpty()) {
                    outputLabel.setText("Please enter some text!");
                    outputLabel.setForeground(new Color(200, 0, 0));
                } else {
                    outputLabel.setText("You typed: " + text);
                    outputLabel.setForeground(new Color(0, 100, 200));
                }
            }
        });

        // Add the panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }
}
