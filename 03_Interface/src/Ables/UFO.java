package Ables;

class UFO implements Flyable, Speakable {

    @Override
    public String drive() {
        return "Warp Drive";
    }

    @Override
    public double distance() {
        return Integer.MAX_VALUE;
    }

    @Override
    public String speak() {
        return "weeuuu-weeeuuuu-weeuuu";
    }

    @Override
    public String toString() {
        return "UFO{drive= " +drive()+ ", distance= " + distance() +", speak= " + speak() +"}";
    }
}