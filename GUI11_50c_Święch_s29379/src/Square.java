import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Square extends MyShape {

    // Define the constructor with parameters
    public Square(int x, int y, int side, Color color) {
        super("Square", color, x, y, side); // Call the superclass constructor
        // Set the bounds of the panel to fit the square
        setBounds(x, y, side, side);
    }

    @Override
    public void draw(Graphics2D g) {
        // Set the color of the graphics context
        g.setColor(color);
        // Fill a rectangle with the given coordinates and size
        g.fillRect(x - size / 2, y - size / 2, size, size);
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