import java.awt.Color;
import java.awt.Point;

import javax.swing.JComponent;

public abstract class MyShape extends JComponent {
    protected Color color;
    protected int x;
    protected int y;
    protected int size;

    protected int id;
    protected String type = "Pen";
    static int ID = 0;

    public MyShape(String type, Color color, int x, int y, int size) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.size = size;

        this.id = ID++;
    }
    public abstract boolean contains(Point p);
    
    public Color getCurrentColor() {
        return color;
    }

    @Override
    public String toString() {
        return "" + id + " " + type + " " + color.getRGB() + " " + x + " " + y + " " + size;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public int getShapeSize() {
        return size;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public static int getID() {
        return ID;
    }

}
