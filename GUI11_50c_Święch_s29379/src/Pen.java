import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Pen extends Shape {
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
        // Set the bounds of the panel to fit the pen point
        setBounds(x - size / 2, y - size / 2, size, size);
    }

    public void draw(Graphics2D g) {
        System.out.println("BBBBBB");
        // Set the color of the graphics
        g.setColor(color);
        // Fill an oval with the size of the pen point
        g.fillOval(x - size / 2, y - size / 2, size, size);
        // If there is a previous point, draw a line between them
        if (lastPoint != null) {
            g.drawLine(x + size / 2, y + size / 2, lastPoint.getX() + lastPoint.size / 2,
                    lastPoint.getY() + lastPoint.size / 2);
        }
    }

    // Override the paintComponent method to draw the pen point and line
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call the superclass method
        // Set the color of the graphics
        g.setColor(color);
        // Fill an oval with the size of the pen point
        g.fillOval(0, 0, size, size);
        // If there is a previous point, draw a line between them
        if (lastPoint != null) {
            g.drawLine(size / 2, size / 2, lastPoint.getX() + lastPoint.size / 2,
                    lastPoint.getY() + lastPoint.size / 2);
        }
        // Update the last point to be this point
        lastPoint = this;
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
}
