import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorButton extends JFrame implements ActionListener {

    // Define an array of colors
    private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN};
    // Define a variable to keep track of the current color index
    private int colorIndex = 0;
    // Define a button
    private JButton button;

    public ColorButton() {
        // Set the title of the frame
        super("Color Button");
        // Set the size of the frame
        setSize(300, 200);
        // Set the layout of the frame to null
        setLayout(null);
        // Create a button with text "Click"
        button = new JButton("Click");
        // Set the bounds of the button
        button.setBounds(100, 75, 100, 50);
        // Add an action listener to the button
        button.addActionListener(this);
        // Add the button to the frame
        add(button);
        // Set the default close operation of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the visibility of the frame to true
        setVisible(true);
    }


    // Override the actionPerformed method of ActionListener interface
    @Override
    public void actionPerformed(ActionEvent e) {
        // If the source of the event is the button
        if (e.getSource() == button) {
            // Set the background color of the button to the current color in the array
            button.setBackground(colors[colorIndex]);
            // Increment the color index by one
            colorIndex++;
            // If the color index reaches the length of the array, reset it to zero
            if (colorIndex == colors.length) {
                colorIndex = 0;
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of ColorButton class
        new ColorButton();
    }
}
