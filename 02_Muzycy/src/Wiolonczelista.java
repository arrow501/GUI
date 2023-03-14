// podklasa dziedzicząca po klasie abstrakcyjnej 
class Wiolonczelista extends Muzyk {

    // konstruktor
    public Wiolonczelista(String imie, double czas) {
        super(imie, czas);
    }

    @Override
    public String instrument() {
        return "Wiolonczela";
    }

    @Override
    public double stawka() {
        return 250.0;
    }
}