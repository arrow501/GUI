import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Pen extends MyShape {
    // Declare a static variable to store the last point
    static Pen lastPoint;

    protected int lastX;
    protected int lastY;

    // Define the constructor with parameters
    public Pen(int x, int y, int size, Color color) {
        super("Pen", color, x, y, size); // Call the superclass constructor
        // Initialize the instance variables
        if (lastPoint != null) {
            this.lastX = lastPoint.getX();
            this.lastY = lastPoint.getY();
        }

    }
    @Override
    public void draw(Graphics2D g) {
    // Set the color of the graphics context
    g.setColor(color);
    // Fill an oval with the given coordinates and size
    g.fillOval(x - size / 2, y - size / 2, size, size);
    }


    public static Pen getLastPoint() {
        return lastPoint;
    }

    public int getLastX() {
        return lastX;
    }

    public int getLastY() {
        return lastY;
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