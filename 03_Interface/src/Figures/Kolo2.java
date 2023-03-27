package Figures;

import java.util.Stack;

public class Kolo2 extends Circle implements Transform {

    private Stack<Position> previousPositions = new Stack<Position>();
    
    public Kolo2(int positionX, int positionY, int radius) {
        super(positionX, positionY, radius);
    }

    @Override
    public void powrot() {
        try {
            Position previous = previousPositions.pop();
            this.positionX = previous.positionX;
            this.positionY = previous.positionY;    
        } catch (Exception e) {
            throw new RuntimeException("No previous position for " + getName());
        }
        
    }

    @Override
    public void przesunDo(int x, int y) {
        previousPositions.add(new Position(positionX, positionY));

        this.positionX = x;
        this.positionY = y;        
    }
    
}
