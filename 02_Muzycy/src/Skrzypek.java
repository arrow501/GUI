// podklasa dziedzicząca po klasie abstrakcyjnej 
class Skrzypek extends Muzyk {

    // konstruktor
    public Skrzypek(String imie, double czas) {
        super(imie, czas);
    }

    @Override
    public String instrument() {
        return "Flet";
    }

    @Override
    public double stawka() {
        return 350.0;
    }
}