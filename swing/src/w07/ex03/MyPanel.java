package w07.ex03;

import javax.swing.*;
import java.awt.*;

public
    class MyPanel
    extends JPanel {

    public MyPanel(){
        this.setBackground(Color.CYAN);
        for(int i=0; i<10; i++)
            this.add(
                new JButton("Click me")
            );
    }
}
