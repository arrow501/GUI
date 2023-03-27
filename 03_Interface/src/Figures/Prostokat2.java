package Figures;

public class Prostokat2 extends Rectangle implements Draw{
    private char drawChar;

    public Prostokat2(int positionX, int positionY, int width, int height, char drawChar) {
        super(positionX, positionY, width, height);
        this.drawChar = drawChar;
    }

    public void rysuj(){
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                System.out.print(drawChar);
            }
            System.out.println();
        }
    }
}
