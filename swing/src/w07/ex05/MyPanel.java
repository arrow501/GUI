package w07.ex05;

import javax.swing.*;
import java.awt.*;

public
    class MyPanel
    extends JPanel {

    public MyPanel(){
        this.setBackground(Color.CYAN);
//        this.setLayout(null);

        JButton jButton = new JButton("Click me"){
            @Override
            public void setLocation(int x, int y) {
                super.setLocation(x, y);
                System.out.println("setLocation");
            }

            @Override
            public void setSize(int width, int height) {
                super.setSize(width, height);
                System.out.println("setSize");
            }
        };
        jButton.setLocation( 150, 150);
        jButton.setSize(200, 100);

        jButton.setPreferredSize(
            new Dimension( 300, 50)
        );

        jButton.setVisible(true);
        this.add(jButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillOval( 0, 0, 150, 300);
    }
}
