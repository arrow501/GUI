import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {
    public boolean deleteMode = false;
    List<MyShape> shapes = new ArrayList<>();
    List<MyShape> toBeRemoved = new ArrayList<>();
    
    public Component add(MyShape shape) {
        shapes.add(0, shape);
        return super.add(shape, 0);
    }
    public void addLast(MyShape shape) {
        shapes.add( shape);
        super.add(shape);
    }

    public List<MyShape> getShapes() {
        return shapes;
    }

    @Override
    public void remove(java.awt.Component comp) {
        super.remove(comp);

        toBeRemoved.add((MyShape) comp);
    }

    public void clearRemoved() {
        for (MyShape s : toBeRemoved) {
            shapes.remove(s);
        }
    }

    public void setDeleteMode(boolean b) {
        deleteMode = b;
    }

    public boolean isDeleteMode() {
        return deleteMode;
    }

}
