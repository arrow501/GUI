package Klient;

import java.util.ArrayList;
import java.util.List;
import Programy.Program;

// A class that represents a wish list that has an owner and a list of programs
public class ListaZyczen {
    private Klient owner; // A private field that stores the owner of the wish list private

    private List<Program> lista; // A private field that stores the list of programs in the wish list

    public ListaZyczen(List<Program> lista) {
        this.lista = lista;
    }

    public ListaZyczen() {
        lista = new ArrayList<>();
    }

    // A public method that adds a program to the list of programs in the wish list
    public void dodaj(Program program) {
        lista.add(program);
    }

    // A public method that removes a program from the list of programs in the wish
    // list
    public void remove(Program p) {
        lista.remove(p);
    }

    // An overridden method that returns a string representation of the wish list
    // with its owner and programs
    @Override
    public String toString() {
        if (lista.size() == 0)
            return owner.getName() + ": -- pusto --";

        StringBuilder sb = new StringBuilder(owner.getName() + ":");
        for (int i = 0; i < lista.size(); i++) {
            sb.append("\n\t" + (i + 1) + ". " + lista.get(i));
        }
        return sb.toString();
    }

    public Klient getOwner() {
        return owner;
    }

    public void setOwner(Klient owner) {
        this.owner = owner;
    }

    public List<Program> getLista() {
        return lista;
    }

    public void setLista(List<Program> lista) {
        this.lista = lista;
    }
}