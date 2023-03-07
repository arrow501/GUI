import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Prostokat {
    private int width;
    private int height;

    public Prostokat(int width, int height){
        this.width = width;
        this.height = height;
    }
    public void rysuj() throws ProstokatException{
        checkProstokat();

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));

        System.out.println("Zwykły Prostokąt rozmiaru" + getWidth() + " x " + getHeight() + "\n");
    }
    protected void checkProstokat() throws ProstokatException {
        if(getHeight() < 1 || getWidth() < 1) throw new ProstokatException("Błędny prostokąt!");
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
