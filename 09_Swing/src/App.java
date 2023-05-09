import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
   public static void main(String[] args) {
      SwingUtilities.invokeLater(
            () -> {
               new App(args);
            });
   }

   public App(String[] args) {
      // String initText = text;
      Color color = JColorChooser.showDialog(null, "TOOL_TIP_TEXT_KEY", Color.WHITE);

      JTextArea textArea = new JTextArea();
      textArea.setForeground(color);
      textArea.setFont(Font.decode("Dialog BOLDITALIC 14"));
      this.getContentPane().add(textArea);

      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize(640, 480);
      this.setVisible(true);
   }
}
