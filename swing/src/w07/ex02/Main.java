package w07.ex02;

import javax.swing.*;

public class Main
        extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> {
                    new Main();
                });
    }

    public Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640, 480);
        this.setVisible(true);
    }
}
