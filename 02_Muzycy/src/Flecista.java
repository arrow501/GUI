
// podklasa dziedzicząca po klasie abstrakcyjnej 
class Flecista extends Muzyk {

    // konstruktor
    public Flecista(String imie, double czas) {
        super(imie, czas);
    }

    @Override
    public String instrument() {
        return "Flet";
    }

    @Override
    public double stawka() {
        return 300.0;
    }
}