package Dane;

public class Koszyk extends Programy {
    public Koszyk(Klient klient) {
        super(klient.getKoszyk().getItems());
    }

    public Koszyk() {
        super();
    }
}