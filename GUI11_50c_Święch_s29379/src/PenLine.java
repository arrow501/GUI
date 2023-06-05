import java.awt.Graphics;

public class PenLine extends MyShape {
    int lastX;
    int lastY;

    public PenLine(Pen pen) {
        super("Line", pen.getColor(), pen.getX(), pen.getY(), pen.getShapeSize());
        lastX = pen.getLastX();
        lastY = pen.getLastY();
        setBounds(-x - size / 2, -y - size / 2, (x + lastX + size ),(y + lastY + size ));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Set the color of the graphics
        g.setColor(color);
        // Draw a line between the current point and the last point
        g.drawLine(x + size / 2, y + size / 2, lastX + size / 2, lastY + size / 2);
    }
}
