import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {
    List<MyShape> lines = new ArrayList<>();
    List<MyShape> shapes = new ArrayList<>();

    
    public void add(MyShape s) {
        // Add the shape to the list of shapes
        if (s.getType().equals("Pen")) {
            lines.add(new PenLine((Pen) s));

        }
        shapes.add(s);
        // Add the shape component to the draw panel
        super.add(s);
        // Set the location and size of the shape component
        s.setLocation(s.getX() - s.getShapeSize() / 2, s.getY() - s.getShapeSize() / 2);
        s.setSize(s.getShapeSize(), s.getShapeSize());


    }   

    // Override the paintComponent method
    @Override
    protected void paintComponent(Graphics g) {
        // Call the super method to clear the background
        super.paintComponent(g);
        // Cast the Graphics object to a Graphics2D object
        Graphics2D g2d = (Graphics2D) g;
        // Loop through the list of shapes and call their draw methods on the graphics
        // context
        for (MyShape s : shapes) {
            s.draw(g2d);
        }
    }
}
