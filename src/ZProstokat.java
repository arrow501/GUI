import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class ZProstokat extends Prostokat{
    private static int squareId = 1;
    private static int rectangleId = 1;

    private char edge;
    private char body;

    public ZProstokat
    (int width, int height, char edgeSymbol, char fillSymbol){
        super(width, height);
        this.edge = edgeSymbol;
        this.body = fillSymbol;
    }
    public ZProstokat
    (int sideLength, char edgeSymbol, char fillSymbol){
        this(sideLength, sideLength, edgeSymbol, fillSymbol);
    }
    @Override
    public void rysuj() throws ProstokatException{
        checkProstokat(); // throws ProstokatException

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));

        if(getHeight() == getWidth()){
            System.out.println("Kwadrat (" + squareId++ + ") rozmiaru " + getWidth() + " x " + getHeight()+ ", " + getCharCount());
        } else {
            System.out.println("Prostokat ("+ rectangleId++ + ") rozmiaru " + getWidth() + " x " + getHeight() + ", " + getCharCount());
        }

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                if(i == 0 || i == getHeight() - 1 || j == 0 || j == getWidth() - 1){
                    System.out.print(edge);
                } else {
                    System.out.print(body);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    @Override
    protected void checkProstokat() throws ProstokatException{
        super.checkProstokat();

        if((getHeight() == 1 || getWidth() == 1) && edge != body)
            throw new ProstokatException("Błędny prostokąt!");
    }
    private String getCharCount() {
        if( getWidth() == 1) return edge + " = " + getHeight();
        if(getHeight() == 1) return edge + " = " + getWidth();

        int edgeCount = 2 * getWidth() + 2 * (getHeight() - 2);
        int bodyCount = getWidth() * getHeight() - edgeCount;
        return body + " = " + bodyCount + ", " + edge + " = " + edgeCount;
    }


}
