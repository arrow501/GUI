
//importing swing and awt packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//creating a class that extends JFrame and implements ActionListener
public class SwingApp extends JFrame implements ActionListener {

    // declaring the swing components
    private JButton frButton, fgButton, fbButton, aButton, bButton, cButton;
    private JButton[] numButtons;
    private JTextArea textArea;
    private JTextField[] textFields;

    // creating a constructor that sets up the GUI
    public SwingApp() {
        // setting the title of the frame
        super("Swing App");

        // setting the size of the frame
        setSize(500, 400);

        // setting the layout of the frame to BorderLayout
        setLayout(new BorderLayout());

        // creating a panel for the top bar buttons
        JPanel leftTopPanel = new JPanel();

        // setting the layout of the top panel to FlowLayout with left alignment
        leftTopPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // creating the color buttons with red, green and blue texts
        frButton = new JButton("FR");
        frButton.setForeground(Color.RED);
        fgButton = new JButton("FG");
        fgButton.setForeground(Color.GREEN);
        fbButton = new JButton("FB");
        fbButton.setForeground(Color.BLUE);

        // setting the color buttons to be opaque
        frButton.setOpaque(true);
        fgButton.setOpaque(true);
        fbButton.setOpaque(true);
        // adding action listeners to the color buttons
        frButton.addActionListener(this);
        fgButton.addActionListener(this);
        fbButton.addActionListener(this);

        // adding the color buttons to the top panel
        leftTopPanel.add(frButton);
        leftTopPanel.add(fgButton);
        leftTopPanel.add(fbButton);

        // creating a panel for the right bar buttons
        JPanel rightTopPanel = new JPanel();

        // setting the layout of the right panel to FlowLayout with right alignment
        rightTopPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // creating the alphabet buttons with A, B and C texts
        aButton = new JButton("A");
        bButton = new JButton("B");
        cButton = new JButton("C");

        // adding action listeners to the alphabet buttons
        aButton.addActionListener(this);
        bButton.addActionListener(this);
        cButton.addActionListener(this);

        // adding the alphabet buttons to the right panel
        rightTopPanel.add(aButton);
        rightTopPanel.add(bButton);
        rightTopPanel.add(cButton);

        JPanel topPanel = new JPanel(new BorderLayout());
        // adding the top and right panels to the north area of the frame
        topPanel.add(leftTopPanel, BorderLayout.WEST);
        topPanel.add(rightTopPanel, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        // continuing from the previous code

        // creating a text area with some initial text and setting its font and color
        textArea = new JTextArea(
                "Obszar tekstowy typu JText Area \n\nPole tekstowe 1 typu JTextField \n\nPole tekstowe 2 typu JTextField \n\nPole tekstowe 3 typu JTextField \n\n");
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setForeground(Color.BLACK);

        // adding the text area to the center area of the frame
        add(textArea, BorderLayout.CENTER);

        // creating a panel for the bottom area of the frame
        JPanel bottomPanel = new JPanel();

        // setting the layout of the bottom panel to BorderLayout
        bottomPanel.setLayout(new BorderLayout());

        // creating a panel for the keypad buttons
        JPanel keypadPanel = new JPanel();

        // setting the layout of the keypad panel to GridLayout with 3 rows and 3
        // columns
        keypadPanel.setLayout(new GridLayout(3, 3));

        // creating an array of 9 numeric buttons with 1 to 9 texts
        numButtons = new JButton[9];

        // creating a loop to initialize and add the numeric buttons to the keypad panel
        for (int i = 0; i < 9; i++) {
            // creating a new button with the corresponding text
            numButtons[i] = new JButton(String.valueOf(i + 1));

            // adding an action listener to the button
            numButtons[i].addActionListener(this);

            // adding the button to the keypad panel
            keypadPanel.add(numButtons[i]);
        }

        // adding the keypad panel to the west area of the bottom panel
        bottomPanel.add(keypadPanel, BorderLayout.WEST);

        // creating a panel for the text fields
        JPanel textFieldPanel = new JPanel();

        // setting the layout of the text field panel to BoxLayout with vertical axis
        textFieldPanel.setLayout(new BoxLayout(textFieldPanel, BoxLayout.Y_AXIS));

        // creating an array of 3 text fields with some initial texts
        textFields = new JTextField[3];
        textFields[0] = new JTextField("Pole tekstowe 1 typu JTextField ");
        textFields[1] = new JTextField("Pole tekstowe 2 typu JTextField ");
        textFields[2] = new JTextField("Pole tekstowe 3 typu JTextField ");

        // creating a loop to add action listeners and the text fields to the text field
        // panel
        for (int i = 0; i < 3; i++) {
            // adding an action listener to the text field
            textFields[i].addActionListener(this);

            // adding some vertical glue to create space between the text fields
            textFieldPanel.add(Box.createVerticalGlue());

            // adding the text field to the text field panel
            textFieldPanel.add(textFields[i]);
        }

        // adding some vertical glue to create space after the last text field
        textFieldPanel.add(Box.createVerticalGlue());

        // adding the text field panel to the east area of the bottom panel
        bottomPanel.add(textFieldPanel, BorderLayout.EAST);

        // adding the bottom panel to the south area of the frame
        add(bottomPanel, BorderLayout.SOUTH);

        // setting the default close operation of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // making the frame visible
        setVisible(true);
    }

    // implementing the actionPerformed method of ActionListener interface
    public void actionPerformed(ActionEvent e) {
        // getting the source of the event
        Object source = e.getSource();

        // checking if the source is one of the color buttons
        if (source == frButton || source == fgButton || source == fbButton) {
            // getting the foreground color of the button
            Color color = ((JButton) source).getForeground();

            // setting the foreground color of the text area to the same color
            textArea.setForeground(color);
        }

        // checking if the source is one of the alphabet buttons
        else if (source == aButton || source == bButton || source == cButton) {
            // getting the text of the button
            String text = ((JButton) source).getText();

            // appending the text to the end of the text area
            textArea.append(text);
        }

        // checking if the source is one of the numeric buttons
        else if (source instanceof JButton) {
            // getting the text of the button
            String text = ((JButton) source).getText();

            // appending the text to each of the text fields
            for (int i = 0; i < 3; i++) {
                textFields[i].setText(textFields[i].getText() + text);
            }
        }

        // checking if the source is one of the text fields
        else if (source instanceof JTextField) {
            // getting the text of the text field
            String text = ((JTextField) source).getText();

            // appending a new line and then the text to the end of the text area
            textArea.append("\n" + text);
        }
    }

    // creating a main method to test the program
    public static void main(String[] args) {
        // creating an instance of SwingApp class
        new SwingApp();
    }
}
