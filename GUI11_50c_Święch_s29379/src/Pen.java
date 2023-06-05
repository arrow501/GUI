import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Pen extends MyShape {
protected Pen lastPoint;
    protected int lastX;
    protected int lastY;

    // Define the constructor with parameters
    public Pen(int x, int y, int size, Color color, Pen lastPoint) {
        super("Pen", color, x, y, size); // Call the superclass constructor
        // Initialize the instance variables
        if (lastPoint != null) {
            this.lastPoint = lastPoint;
            this.lastX = lastPoint.getX();
            this.lastY = lastPoint.getY();

            // Set the bounds of the panel to fit the pen point and line
            int minX = Math.min(x - size / 2, lastPoint.getX() - lastPoint.size / 2);
            int minY = Math.min(y - size / 2, lastPoint.getY() - lastPoint.size / 2);
            int maxX = Math.max(x + size / 2, lastPoint.getX() + lastPoint.size / 2);
            int maxY = Math.max(y + size / 2, lastPoint.getY() + lastPoint.size / 2);
            setBounds(minX, minY, maxX - minX, maxY - minY);
        } else {
            // Set the bounds of the panel to fit the pen point
            setBounds(x - size / 2, y - size / 2, size, size);
        }
    }
    @Override
    public boolean contains(Point p) {
        int centerX = x + size / 2;
        int centerY = y + size / 2;
        int distanceSquared = (centerX - p.x) * (centerX - p.x) + (centerY - p.y) * (centerY - p.y);
        return distanceSquared <= size * size * 2;
    }

    // Override the paintComponent method to draw the pen point and line
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call the superclass method
        // Set the color of the graphics
        g.setColor(color);
        // Fill an oval with the size of the pen point
        g.fillOval(0, 0, size, size);
    }

    public Pen getLastPoint() {
        return lastPoint;
    }

    public int getLastX() {
        return lastX;
    }

    public int getLastY() {
        return lastY;
    }
}
