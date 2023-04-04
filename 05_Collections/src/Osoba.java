import java.util.Collection;
import java.util.Objects;

public class Osoba implements Comparable<Osoba> {
    private String imie;
    private int rokUrodzenia;

    public Osoba(String imie, int rokUrodzenia) {
        this.imie = imie;
        this.rokUrodzenia = rokUrodzenia;
    }

    public static boolean wKolekcji(Collection<Osoba> kol, String imie, int rokUrodzenia) {
        return kol.contains(new Osoba(imie, rokUrodzenia));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Osoba))
            return false;

        Osoba osoba = (Osoba) o;
        return getRokUrodzenia() == osoba.getRokUrodzenia() && getImie().equals(osoba.getImie());
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, rokUrodzenia);
    }

    @Override
    public int compareTo(Osoba osoba) {
        int compare = this.imie.compareTo(osoba.imie);
        if (compare == 0) {
            compare = Integer.compare(this.rokUrodzenia, osoba.rokUrodzenia);
        }
        return compare;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public int getRokUrodzenia() {
        return rokUrodzenia;
    }

    public void setRokUrodzenia(int rokUrodzenia) {
        this.rokUrodzenia = rokUrodzenia;
    }

}