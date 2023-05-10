package w07.ex06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public
    class MyPanel
    extends JPanel {

    public MyPanel(){
        this.setBackground(Color.CYAN);
        this.setLayout(null);

        JButton jButton = new JButton("Click me");
        jButton.setLocation( 150, 150);
        jButton.setSize(200, 100);

        jButton.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    jButton.setLocation(
                        (int)(Math.random()*(getWidth()-jButton.getWidth())),
                        (int)(Math.random()*getHeight()-jButton.getHeight())
                    );
                }
            }
        );

        jButton.setVisible(true);
        this.add(jButton);
    }
}
