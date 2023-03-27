package Figures;

public interface Transform {
    static final class Position {
        
        public Position(int positionX, int positionY) {
            this.positionX = positionX;
            this.positionY = positionY;
        }
        public int positionX;
        public int positionY;
    }
    void przesunDo(int x, int y);
    void powrot();
}
