package Klient;

// A class that represents a basket that extends the wish list class and has an owner
public class Koszyk extends ListaZyczen {
    public Koszyk(Klient klient) {
        setOwner(klient);
    }
}