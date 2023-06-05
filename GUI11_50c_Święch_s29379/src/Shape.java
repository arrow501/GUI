import java.awt.Color;

import javax.swing.JComponent;

public abstract class Shape extends JComponent {
    protected Color color;
    protected int x;
    protected int y;
    protected int size;


    
    public Shape(Color color, int x, int y, int size) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.size = size;
    }



    public Color getCurrentColor() {
        return color;
    }
    @Override
    public int getX() {
        return x;
    }
    @Override
    public int getY() {
        return y;
    }
}
