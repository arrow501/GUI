import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingApp extends JFrame implements ActionListener {

    // Declare the components as constants
    private static final JButton FR_BUTTON = new JButton("FR");
    private static final JButton FG_BUTTON = new JButton("FG");
    private static final JButton FB_BUTTON = new JButton("FB");
    private static final JButton A_BUTTON = new JButton("A");
    private static final JButton B_BUTTON = new JButton("B");
    private static final JButton C_BUTTON = new JButton("C");
    private static final JTextArea TEXT_AREA = new JTextArea(
            "Obszar tekstowy typu JText Area \n\nPole tekstowe 1 typu JTextField \n\nPole tekstowe 2 typu JTextField \n\nPole tekstowe 3 typu JTextField \n\n");
    private static final JTextField[] TEXT_FIELDS = new JTextField[3];
    private static final JButton[] NUM_BUTTONS = new JButton[9];

    public SwingApp() {
        super("Swing App");
        setSize(500, 400);
        setLayout(new BorderLayout());
        add(createTopPanel(), BorderLayout.NORTH);
        add(createCenterPanel(), BorderLayout.CENTER);
        add(createBottomPanel(), BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Create the top panel with two sub-panels
    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(createLeftTopPanel(), BorderLayout.WEST);
        topPanel.add(createRightTopPanel(), BorderLayout.EAST);
        return topPanel;
    }

    // Create the left top panel with three color buttons
    private JPanel createLeftTopPanel() {
        JPanel leftTopPanel = new JPanel();
        leftTopPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        FR_BUTTON.setForeground(Color.RED);
        FG_BUTTON.setForeground(Color.GREEN);
        FB_BUTTON.setForeground(Color.BLUE);
        FR_BUTTON.setOpaque(true);
        FG_BUTTON.setOpaque(true);
        FB_BUTTON.setOpaque(true);
        FR_BUTTON.addActionListener(this);
        FG_BUTTON.addActionListener(this);
        FB_BUTTON.addActionListener(this);
        leftTopPanel.add(FR_BUTTON);
        leftTopPanel.add(FG_BUTTON);
        leftTopPanel.add(FB_BUTTON);
        return leftTopPanel;
    }

    // Create the right top panel with three letter buttons
    private JPanel createRightTopPanel() {
        JPanel rightTopPanel = new JPanel();
        rightTopPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        A_BUTTON.addActionListener(this);
        B_BUTTON.addActionListener(this);
        C_BUTTON.addActionListener(this);
        rightTopPanel.add(A_BUTTON);
        rightTopPanel.add(B_BUTTON);
        rightTopPanel.add(C_BUTTON);
        return rightTopPanel;
    }

    // Create the center panel with a text area
    private JScrollPane createCenterPanel() {

        TEXT_AREA.setFont(new Font("Arial", Font.PLAIN, 16));
        TEXT_AREA.setForeground(Color.BLACK);

        // Wrap the text area in a scroll pane
        JScrollPane centerPanel = new JScrollPane(TEXT_AREA);

        return centerPanel;
    }

    // Create the bottom panel with two sub-panels
    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(createKeypadPanel(), BorderLayout.WEST);
        bottomPanel.add(createTextFieldPanel(), BorderLayout.EAST);
        return bottomPanel;
    }

    // Create the keypad panel with nine number buttons
    private JPanel createKeypadPanel() {
        JPanel keypadPanel = new JPanel();
        keypadPanel.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            NUM_BUTTONS[i] = new JButton(String.valueOf(i + 1));
            NUM_BUTTONS[i].addActionListener(this);
            keypadPanel.add(NUM_BUTTONS[i]);
        }

        return keypadPanel;
    }

    // Create the text field panel with three text fields
    private JPanel createTextFieldPanel() {
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new BoxLayout(textFieldPanel, BoxLayout.Y_AXIS));
        TEXT_FIELDS[0] = new JTextField("Pole tekstowe 1 typu JTextField ");
        TEXT_FIELDS[1] = new JTextField("Pole tekstowe 2 typu JTextField ");
        TEXT_FIELDS[2] = new JTextField("Pole tekstowe 3 typu JTextField ");

        for (int i = 0; i < 3; i++) {
            TEXT_FIELDS[i].addActionListener(this);
            textFieldPanel.add(Box.createVerticalGlue());
            textFieldPanel.add(TEXT_FIELDS[i]);
        }

        textFieldPanel.add(Box.createVerticalGlue());
        return textFieldPanel;
    }

    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source == FR_BUTTON || source == FG_BUTTON || source == FB_BUTTON) {

            Color color = ((JButton) source).getForeground();

            TEXT_AREA.setForeground(color);

        } else if (source == A_BUTTON || source == B_BUTTON || source == C_BUTTON) {

            String text = ((JButton) source).getText();

            TEXT_AREA.append(text);

        } else if (source instanceof JButton) {

            String text = ((JButton) source).getText();

            for (int i = 0; i < 3; i++) {
                TEXT_FIELDS[i].setText(TEXT_FIELDS[i].getText() + text);

            }
        } else if (source instanceof JTextField) {

            String text = ((JTextField) source).getText();

            TEXT_AREA.append("\n" + text);

        }
    }

    public static void main(String[] args) {

        new SwingApp();
    }
}
