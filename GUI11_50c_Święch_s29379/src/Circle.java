import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Circle extends MyShape {
    public Circle(int x, int y, int size, Color color) {
        super("Circle", color, x, y , size); // Subtract half of the size from x and y
        // Set the bounds of the panel to fit the circle
        setBounds(x - size, y - size, 2 * size, 2 * size);
    }

    @Override
    public boolean contains(Point p) {
        int centerX = x + size ;
        int centerY = y + size ;
        int distanceSquared = (centerX - p.x) * (centerX - p.x) + (centerY - p.y) * (centerY - p.y);
        return distanceSquared <= size * size;
    }
    // Override the paintComponent method to draw the circle
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Set the color of the graphics
        g.setColor(getColor());
        // Fill an oval with the center and radius of the circle
        g.fillOval(0, 0, 2 * size, 2 * size);
    }

}