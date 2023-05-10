package w07.ex05;

import javax.swing.*;

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

        this.getContentPane().add(new MyPanel());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize( 640, 480);
        this.setVisible(true);
    }
}
