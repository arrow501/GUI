package Figures;

public abstract class Figure implements Calculate {
    protected int positionX;
    protected int positionY;
    
    public Figure(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
    abstract public String getName();

    abstract public void pozycja(int x, int y);

    @Override
    public String toString(){
        return getName() + "{x: " + getPositionX() +"; y: " + getPositionY() + "}";
    }

    public int getPositionX() {
        return positionX;
    }
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    public int getPositionY() {
        return positionY;
    }
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
