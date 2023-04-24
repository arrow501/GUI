package Cennik;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cennik {
    private static Cennik instance = null;

    private Map<String, List<CennikItem>> mapa;

    public Cennik() {
        this.mapa = new HashMap<>();
    }

    public static Cennik pobierzCennik() {
        if (instance == null)
            instance = new Cennik();

        return instance;
    }

    public void dodaj(String genre, String title, int regularPrice, int upToCountPrice, int deviceCount,
            int abonamentPrice) {

    }

    public void dodaj(String genre, String title, int upToCountPrice, int deviceCount, int regularPrice) {
        dodaj(new CennikItem(title, genre, regularPrice, -1, upToCountPrice, deviceCount));
    }

    public void dodaj(String genre, String title, int abonamentPrice, int regularPrice) {
        dodaj(new CennikItem(title, genre, regularPrice, abonamentPrice, 0, 0));
    }

    public void dodaj(String genre, String title) {
        dodaj(new CennikItem(title, genre, -1, 0, -1, 0));
    }

    private void dodaj(CennikItem a) {
        if (mapa.containsKey(a.getGenre())) {
            mapa.get(a.getGenre()).add(a);
        } else {
            mapa.put(a.getGenre(), List.of(a));
        }
    }
}
