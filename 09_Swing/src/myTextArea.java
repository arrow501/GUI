import java.awt.Color;

import javax.swing.*;

public class myTextArea extends JTextArea {

    public myTextArea() {
        JColorChooser cc = new JColorChooser();
        Color color = cc.showDialog(null, TOOL_TIP_TEXT_KEY, Color.WHITE);
        this.add(cc);
    }

}
