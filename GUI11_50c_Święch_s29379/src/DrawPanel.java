import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {
    List<Shape> lines = new ArrayList<>();


 public Component add(Shape shape) {
    if(shape.getType().equals("Pen")){
        Pen pen = (Pen) shape;
        lines.add(new PenLine(pen));

    }
     return super.add(shape);
 }

}
