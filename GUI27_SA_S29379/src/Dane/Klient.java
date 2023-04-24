package Dane;

public class Klient {
    private Koszyk koszyk;
    private String name;
    private int funds;
    private boolean abonament;

    public Klient(String name, int funds, boolean abonament) {
        this.name = name;
        this.funds = funds;
        this.abonament = abonament;
        koszyk = new Koszyk();
    }

    public Programy getKoszyk() {
        return koszyk;
    }

}
