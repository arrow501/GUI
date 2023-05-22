import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorButton extends JFrame implements ActionListener {

    private Color[] colors = { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN };

    private int colorIndex = 0;

    private JButton button;

    public ColorButton() {

        super("Color Button");

        setSize(300, 200);

        setLayout(null);

        button = new JButton("Click");

        button.setBounds(100, 75, 100, 50);

        button.addActionListener(this);

        add(button);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button) {

            button.setBackground(colors[colorIndex]);

            colorIndex++;

            if (colorIndex == colors.length) {
                colorIndex = 0;
            }
        }
    }

    public static void main(String[] args) {

        new ColorButton();
    }
}
