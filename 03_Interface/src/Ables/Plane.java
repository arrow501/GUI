package Ables;

class Plane implements Flyable, Speakable{

    @Override
    public String drive() {
        return "Jet engine";
    }

    @Override
    public double distance() {
        return 17_700_000; // 777's range
    }

    @Override
    public String speak() {
        return "woooooooosh";
    }

    @Override
    public String toString() {
        return "Plane{drive= " +drive()+ ", distance= " + distance() +", speak= " + speak() +"}";
    }
}