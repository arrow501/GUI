import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Square extends MyShape {

    public Square(int x, int y, int side, Color color) {
        super("Square", color, x - side / 2, y - side / 2, side); // Subtract half of the side from x and y
        // Set the bounds of the panel to fit the square
        setBounds(x - side / 2, y - side / 2, side, side);
    }

    @Override
    public boolean contains(Point p) {
        return p.x >= x && p.x <= x + size && p.y >= y && p.y <= y + size;
    }

    // Override the paintComponent method to draw the square
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call the superclass method
        // Set the color of the graphics
        g.setColor(color);
        // Fill a rectangle with the width and height of the square
        g.fillRect(0, 0, size, size);
    }
}