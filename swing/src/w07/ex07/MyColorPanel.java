package w07.ex07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public
    class MyColorPanel
    extends JPanel {

    private JButton button;

    public MyColorPanel(Color color) {
        this.setPreferredSize(
            new Dimension( 150, 150)
        );
        this.setBackground(color);

        this.setLayout(new BorderLayout());
        this.button = new JButton("set random color");

        this.button.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Color color = new Color(
                        (int)(Math.random()*255),
                        (int)(Math.random()*255),
                        (int)(Math.random()*255)
                    );
                    setBackground(color);
                    fireColorChange(
                        new ColorEvent( MyColorPanel.this, color)
                    );
                }
            }
        );

        this.add( this.button, BorderLayout.PAGE_END);

        myListeners = new ArrayList<>();
    }

    private List<ColorListener> myListeners;

    public void addColorListener(ColorListener colorListener){
        myListeners.add(colorListener);
    }

    public void removeColorListener(ColorListener colorListener){
        myListeners.remove(colorListener);
    }

    private void fireColorChange(ColorEvent colorEvent){
        for(ColorListener colorListener : myListeners)
            colorListener.colorChanged(colorEvent);
    }
}