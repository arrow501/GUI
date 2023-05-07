package Klient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Programy.Program;

// A class that represents a wish list that has an owner and a list of programs
public class ListaZyczen implements Iterable<Program> {
    private Klient owner; // A private field that stores the owner of the wish list private

    private List<Program> lista; // A private field that stores the list of programs in the wish list

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

    @Override
    public Iterator<Program> iterator() {
        return getLista().iterator();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        result = prime * result + ((lista == null) ? 0 : lista.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ListaZyczen other = (ListaZyczen) obj;
        if (owner == null) {
            if (other.owner != null)
                return false;
        } else if (!owner.equals(other.owner))
            return false;
        if (lista == null) {
            if (other.lista != null)
                return false;
        } else if (!lista.equals(other.lista))
            return false;
        return true;
    }

    public void clear() {
        getLista().clear();
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