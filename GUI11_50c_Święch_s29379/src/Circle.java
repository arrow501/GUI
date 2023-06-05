import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Circle extends MyShape {

    // Declare the instance variables for the center, radius and color of the circle

    public Circle(int x, int y, int size, Color color) {
        super("Circle", color, x - size, y - size, size); // Subtract half of the size from x and y
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
    public boolean contains(Point p) {
        int centerX = x + size / 2;
        int centerY = y + size / 2;
        int distanceSquared = (centerX - p.x) * (centerX - p.x) + (centerY - p.y) * (centerY - p.y);
        return distanceSquared <= size * size / 4;
    }
    // Override the paintComponent method to draw the circle
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Set the color of the graphics
        g.setColor(color);
        // Fill an oval with the center and radius of the circle
        g.fillOval(0, 0, 2 * size, 2 * size);
    }

}