import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {
    public boolean deleteMode = false;
    List<MyShape> shapes = new ArrayList<>();

 public Component add(MyShape shape) {
    shapes.add(shape);
     return super.add(shape);
 }

public List<MyShape> getShapes() {
    return shapes;
}

public void setDeleteMode(boolean b) {
    deleteMode = b;
    System.out.println("DeleteMode: " + deleteMode);
}

public boolean isDeleteMode() {
    return deleteMode;
}





}
