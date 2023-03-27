package Ables;

interface Flyable {
    String drive();
    double distance();
    
    static Flyable hybrid(Flyable flying1, Flyable flying2){
        return new Flyable() {
            @Override
            public String drive(){
                return flying1.drive() + "-" + flying2.drive();
            }
            
            @Override
            public double distance(){
                return Math.max(flying1.distance(), flying2.distance());
            }
        };
    }
}