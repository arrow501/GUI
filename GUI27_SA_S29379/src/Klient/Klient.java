package Klient;

import java.util.ArrayList;
import java.util.List;

import Programy.Program;

// A class that represents a client with a name, funds, subscription status, wish list and basket
public class Klient {
    private ListaZyczen lista; // stores the wish list of the client
    private Koszyk koszyk; // stores the basket of the client
    private String name;
    private int funds; // stores the funds of the client
    private boolean abonament; // stores whether the client has a subscription or not

    public Klient(String name, int funds, boolean abonament) {
        this.name = name;
        this.funds = funds;
        this.abonament = abonament;
        lista = new ListaZyczen();
        lista.setOwner(this);
    }

    public void dodaj(Program program) {
        lista.dodaj(program);
    }

    public ListaZyczen pobierzListeZyczen() {
        return lista;
    }

    // A public method that transfers the programs from the wish list to the basket
    // of this client
    // It takes a basket object as a parameter and assigns it to this client's
    // basket field
    // It iterates over the programs in the wish list and adds them to the basket if
    // they have a price
    // It removes the programs from the wish list after adding them to the basket
    public void przepakuj(Koszyk koszykKinomana) {
        this.koszyk = koszykKinomana;

        for (Program p : lista.getLista()) {
            if (p.getCena() != null) {
                koszykKinomana.dodaj(p);
            }
        }
        for (Program p : koszyk.getLista()) {
            lista.remove(p);
        }
    }

    // A public method that pays for the programs in the basket using a given
    // payment method and option
    // It takes a string parameter that indicates the payment method and a boolean
    // parameter that indicates whether to use auto-saving or not
    // It calculates the commission fee based on the payment method using a switch
    // expression
    // If auto-saving is true, it pays for as many programs as possible with the
    // available funds and removes them from the basket
    // If auto-saving is false, it pays for all the programs in the basket if there
    // are enough funds and clears the basket
    public void zaplac(String metodaPlatnosci, boolean autoOdkladanie) {
        double cena = 0;
        double prowizja = switch (metodaPlatnosci) {
            case "karta" -> 0.02;
            case "przelew" -> 0;
            default -> 0;
        };

        if (autoOdkladanie) {
            List<Program> paid = new ArrayList<>();

            for (Program p : koszyk.getLista()) {
                double cenaProgram = p.getCena() * p.getDeviceCount() * (1 + prowizja);
                if (cena + cenaProgram > funds) {
                    break;
                }
                cena += cenaProgram;
                paid.add(p);
            }
            funds -= cena;
            for (Program p : paid) {
                koszyk.remove(p);
            }
        } else {
            cena = koszyk.getLista()
                    .stream()
                    .map(p -> p.getCena() * p.getDeviceCount())
                    .reduce(0, (a, b) -> a + b);
            cena *= 1 + prowizja;

            if (cena > funds) {
                koszyk.getLista().clear();
                lista.getLista().clear();
            } else {
                funds -= cena;
                koszyk.getLista().clear();
            }
        }

    }

    public int pobierzPortfel() {
        return funds;
    }

    public Koszyk pobierzKoszyk() {
        return koszyk;
    }

    public ListaZyczen getLista() {
        return lista;
    }

    public Koszyk getKoszyk() {
        return koszyk;
    }

    public String getName() {
        return name;
    }

    public int getFunds() {
        return funds;
    }

    public boolean isAbonament() {
        return abonament;
    }

}
