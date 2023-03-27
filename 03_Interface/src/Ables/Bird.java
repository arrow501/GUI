package Ables;

class Bird implements Flyable, Speakable {

    @Override
    public String drive() {
        return "Wings";
    }

    @Override
    public double distance() {
        return 5_000;
    }

    @Override
    public String speak() {
        return "*chirps*";
    }

    @Override
    public String toString() {
        return "Bird{drive= " +drive()+ ", distance= " + distance() +", speak= " + speak() +"}";
    }
}