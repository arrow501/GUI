
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingApp extends JFrame implements ActionListener {

    private JButton frButton, fgButton, fbButton, aButton, bButton, cButton;
    private JButton[] numButtons;
    private JTextArea textArea;
    private JTextField[] textFields;

    public SwingApp() {

        super("Swing App");

        setSize(500, 400);

        setLayout(new BorderLayout());

        JPanel leftTopPanel = new JPanel();

        leftTopPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        frButton = new JButton("FR");
        frButton.setForeground(Color.RED);
        fgButton = new JButton("FG");
        fgButton.setForeground(Color.GREEN);
        fbButton = new JButton("FB");
        fbButton.setForeground(Color.BLUE);

        frButton.setOpaque(true);
        fgButton.setOpaque(true);
        fbButton.setOpaque(true);

        frButton.addActionListener(this);
        fgButton.addActionListener(this);
        fbButton.addActionListener(this);

        leftTopPanel.add(frButton);
        leftTopPanel.add(fgButton);
        leftTopPanel.add(fbButton);

        JPanel rightTopPanel = new JPanel();

        rightTopPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        aButton = new JButton("A");
        bButton = new JButton("B");
        cButton = new JButton("C");

        aButton.addActionListener(this);
        bButton.addActionListener(this);
        cButton.addActionListener(this);

        rightTopPanel.add(aButton);
        rightTopPanel.add(bButton);
        rightTopPanel.add(cButton);

        JPanel topPanel = new JPanel(new BorderLayout());

        topPanel.add(leftTopPanel, BorderLayout.WEST);
        topPanel.add(rightTopPanel, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        textArea = new JTextArea(
                "Obszar tekstowy typu JText Area \n\nPole tekstowe 1 typu JTextField \n\nPole tekstowe 2 typu JTextField \n\nPole tekstowe 3 typu JTextField \n\n");
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setForeground(Color.BLACK);

        add(textArea, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();

        bottomPanel.setLayout(new BorderLayout());

        JPanel keypadPanel = new JPanel();

        keypadPanel.setLayout(new GridLayout(3, 3));

        numButtons = new JButton[9];

        for (int i = 0; i < 9; i++) {

            numButtons[i] = new JButton(String.valueOf(i + 1));

            numButtons[i].addActionListener(this);

            keypadPanel.add(numButtons[i]);
        }

        bottomPanel.add(keypadPanel, BorderLayout.WEST);

        JPanel textFieldPanel = new JPanel();

        textFieldPanel.setLayout(new BoxLayout(textFieldPanel, BoxLayout.Y_AXIS));

        textFields = new JTextField[3];
        textFields[0] = new JTextField("Pole tekstowe 1 typu JTextField ");
        textFields[1] = new JTextField("Pole tekstowe 2 typu JTextField ");
        textFields[2] = new JTextField("Pole tekstowe 3 typu JTextField ");

        for (int i = 0; i < 3; i++) {

            textFields[i].addActionListener(this);

            textFieldPanel.add(Box.createVerticalGlue());

            textFieldPanel.add(textFields[i]);
        }

        textFieldPanel.add(Box.createVerticalGlue());

        bottomPanel.add(textFieldPanel, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source == frButton || source == fgButton || source == fbButton) {

            Color color = ((JButton) source).getForeground();

            textArea.setForeground(color);
        }

        else if (source == aButton || source == bButton || source == cButton) {

            String text = ((JButton) source).getText();

            textArea.append(text);
        }

        else if (source instanceof JButton) {

            String text = ((JButton) source).getText();

            for (int i = 0; i < 3; i++) {
                textFields[i].setText(textFields[i].getText() + text);
            }
        }

        else if (source instanceof JTextField) {

            String text = ((JTextField) source).getText();

            textArea.append("\n" + text);
        }
    }

    public static void main(String[] args) {

        new SwingApp();
    }
}
