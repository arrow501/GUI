import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape {


    // Define the constructor with parameters
    public Square(int x, int y, int side, Color color) {
        super(color, x, y, side); // Call the superclass constructor
        // Set the bounds of the panel to fit the square
        setBounds(x, y, side, side);
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