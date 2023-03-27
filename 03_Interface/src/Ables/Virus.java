package Ables;

class Virus implements Flyable {
    @Override
    public String drive() {
        return "Brownian motion";
    }

    @Override
    public double distance() {
        return 2;
    }

    @Override
    public String toString() {
        return "Virus{drive= " +drive()+ ", distance= " + distance() +"}";
    }
}