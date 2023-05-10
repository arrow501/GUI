package w07.ex07;

import javax.swing.*;
import java.awt.*;

public
    class Main
    extends JFrame{

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
            () -> {
                new Main();
            }
        );
    }

    public Main() {
        MyColorPanel colorPanel1 = new MyColorPanel(Color.PINK);
        MyColorPanel colorPanel2 = new MyColorPanel(Color.MAGENTA);
        MyColorPanel colorPanel3 = new MyColorPanel(Color.DARK_GRAY);

        JPanel contollersPanel = new JPanel();
        contollersPanel.add(colorPanel1);
        contollersPanel.add(colorPanel2);
        contollersPanel.add(colorPanel3);

        this.getContentPane().add(contollersPanel, BorderLayout.PAGE_END);

        JPanel resPanel = new JPanel();
        resPanel.setBackground(Color.DARK_GRAY);


        ColorListener cl = new ColorListener() {
            @Override
            public void colorChanged(ColorEvent evt) {
                resPanel.setBackground(evt.getColor());
            }
        };

        colorPanel1.addColorListener(cl);
        colorPanel2.addColorListener(cl);
        colorPanel3.addColorListener(cl);

        this.getContentPane().add(resPanel);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize( 640, 480);
        this.setVisible(true);
    }
}
