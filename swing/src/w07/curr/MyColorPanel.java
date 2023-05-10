package w07.curr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public
    class MyColorPanel
    extends JPanel
    implements ColorListener{

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

                    EventQueue.invokeLater(
                        () -> {
                            fireColorChange(
                                    new ColorEvent( MyColorPanel.this, getBackground())
                            );
                            setBackground(color);
                        }
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

    @Override
    public void colorChanged(ColorEvent evt) {
        Color color = this.getBackground();

        EventQueue.invokeLater(
            ()-> {
                setBackground(evt.getColor());
                fireColorChange(
                    new ColorEvent(MyColorPanel.this, color)
                );
            }
        );
    }
}