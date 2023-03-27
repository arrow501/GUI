package Figures;

public class Rectangle extends Figure {
    private int width;
    private int height;

    public Rectangle(int positionX, int positionY, int width, int height) {
        super(positionX, positionY);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * width + 2 * height;
    }

    @Override
    public String getName() {
        return "Prostokąt";
    }

    @Override
    public void pozycja(int x, int y) {
        boolean isInside = x <= getPositionX()
                && x >= getPositionX() + getWidth()
                && y <= getPositionY()
                && y >= getPositionY() - getHeight();

        System.out.println(
                "Punkt (" + x + "," + y + " ) znajduje się " + (isInside ? "wewnątrz " : "na zewnątrz ") + getName() + "\n");
    }

    @Override
    public String toString() {
        return getName() + "\n" +
                "Lewy górny - (" + getPositionX() + "," + getPositionY() + ")\n" +
                "Szerokość - " + getWidth() + ", Wysokość - " + getHeight() + "\n";
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
