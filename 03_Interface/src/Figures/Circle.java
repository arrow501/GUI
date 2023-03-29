package Figures;

public class Circle extends Figure {
    private int radius;

    public Circle(int positionX, int positionY, int radius) {
        super(positionX, positionY);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    public void pozycja(int x, int y) {
        boolean isInside = (x - positionX) * (x - positionX) + (y - positionY) * (y - positionY) <= radius * radius;

        System.out.println("Punkt (" + x + "," + y + " ) znajduje się " + (isInside ? "wewnątrz " : "na zewnątrz ")
                + getName() + "\n");
    }

    public String getName() {
        return "Koło";
    }

    @Override
    public String toString() {
        return getName() + "\n" +
                "Środek - (" + getPositionX() + "," + getPositionY() + ")\n" +
                "Promień - " + getRadius() + "\n";
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

}
