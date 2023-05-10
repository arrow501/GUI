package w07.ex01;

import javax.swing.*;

public
    class Main {

    public static void main(String[] args) {
//        Frame frame = new Frame();
//        frame.setSize(640, 480);
//        frame.setVisible(true);

        SwingUtilities.invokeLater(
            new Runnable() {
                @Override
                public void run() {
                    JFrame jFrame = new JFrame();
                    jFrame.setSize( 640, 480);
                    jFrame.setVisible(true);
                }
            }
        );

    }
}
