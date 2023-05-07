package Cennik;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cennik {
    // A static field that holds the singleton instance of this class
    private static Cennik instance = null;

    // A map that stores the genre as the key and a list of CennikItem objects as the value
    private Map<String, List<CennikItem>> cennik;

    public Cennik() {
        this.cennik = new HashMap<>();
    }

    // A public static method that returns the singleton instance of this class
    // If the instance is null, it creates a new one
    public static Cennik pobierzCennik() {
        if (instance == null)
            instance = new Cennik();

        return instance;
    }

    // A public method that returns the list of CennikItem objects for a given genre
    public List<CennikItem> getGenreList(String genre) {
        return cennik.get(genre);
    }

    public void dodaj(String genre, String title, int regularPrice, int upToCountPrice, int deviceCount,
            int abonamentPrice) {
        dodaj(new CennikItem(title, genre, regularPrice, abonamentPrice, upToCountPrice, deviceCount));
    }

    public void dodaj(String genre, String title, int deviceCount, int upToCountPrice, int regularPrice) {
        dodaj(new CennikItem(title, genre, regularPrice, null, upToCountPrice, deviceCount));
    }

    public void dodaj(String genre, String title, int regularPrice, int abonamentPrice) {
        dodaj(new CennikItem(title, genre, regularPrice, abonamentPrice, null, 0));
    }

    public void dodaj(String genre, String title) {
        dodaj(new CennikItem(title, genre, null, 0, null, 0));
    }

    // A private method that adds a given CennikItem object to the map
    // If the map already contains the genre as a key, it adds the object to the existing list
    // Otherwise, it creates a new list with the object and puts it in the map with the genre as a key
    private void dodaj(CennikItem a) {
        if (cennik.containsKey(a.getGenre())) {
            cennik.get(a.getGenre()).add(a);
        } else {
            cennik.put(a.getGenre(), List.of(a));
        }
    }
}
