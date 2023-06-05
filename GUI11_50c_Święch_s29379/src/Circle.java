import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Circle extends MyShape {

    // Declare the instance variables for the center, radius and color of the circle

    // Define the constructor with parameters
    public Circle(int x, int y, int size, Color color) {
        super("Circle", color, x, y, size);
        // Initialize the instance variables

        // Set the bounds of the panel to fit the circle
        setBounds(x - size, y - size, 2 * size, 2 * size);
    }

    public Circle(int x, int y, int w, int h, Color color) {
        this(
                x,
                y,
                (h < w)
                        ? (h / 2)
                        : (w / 2),
                color);
    }
    @Override
    public void draw(Graphics2D g) {
    // Set the color of the graphics context
    g.setColor(color);
    // Fill an oval with the given coordinates and size
    g.fillOval(x - size / 2, y - size / 2, size, size);
    }

    @Override
    public boolean contains(Point2D arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean contains(Rectangle2D arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean contains(double arg0, double arg1) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean contains(double arg0, double arg1, double arg2, double arg3) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Rectangle2D getBounds2D() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform arg0, double arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean intersects(Rectangle2D arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean intersects(double arg0, double arg1, double arg2, double arg3) {
        // TODO Auto-generated method stub
        return false;
    }
    
}