
package GUI27_ZJ_S28486;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Projekt {

    static int cena(Koszyk k, String typ) {
        int suma = 0;
        boolean maAbonament = k.getKlient().maAbonament();
        List<Program> koszyk = k.getKoszyk();

        for (Program program : koszyk) {
            String programTyp = program.getTyp();

            if (typ.equals(programTyp)) {
                suma += program.pobierzCene(maAbonament);
            }
        }
        return suma;
    }

    public static void main(String[] args) {

        // cennik
        Cennik cennik = Cennik.pobierzCennik();

        // dodawanie nowych cen do cennika
        cennik.dodaj("dramat", "Król lew", 6, 12, 3, 5); // jeśli klient ma abonament: 5 zł/urządzenie (z dowolną liczbą
                                                         // urządzeń)
        // jeśli klient nie ma abonamentu: do 3 urządzeń za 12 zł/urządzenie,
        // w przeciwnym przypadku (wpp.) 6 zł/urządzenie

        cennik.dodaj("obyczaj", "Król Lear", 2, 10, 15); // niezależnie od tego, czy klient posiada abonament czy nie
        // do 2 urządzeń za 15 zł/urządzenie, wpp. 10 zł/urządzenie

        cennik.dodaj("komedia", "Królowa", 14, 7); // 7 zł/urządzenie jeśli klient ma abonament, wpp. 14 zł/urządzenie

        cennik.dodaj("sensacja", "Król Artur"); // tylko dla abonamentów: darmowy dostęp

        // Klient Kinoman deklaruje kwotę 70 zł na zamównienia; true oznacza, że klient
        // posiada abonament w serwisie
        Klient kinoman = new Klient("Kinoman", 70, true);

        // Klient Kinoman dodaje do listy życzeń różne programy:
        // "Król Lear" typu obyczajowego na 4 urządzeniach,
        // "Król Artur" typu sensacyjnego na 3 urządzeniach,
        // "Król lew" typu "dramat" na 2 urządzeniach,
        // "Korona" typu komediowego na 2 urządzeniach,
        kinoman.dodaj(new Obyczaj("Król Lear", 4));
        kinoman.dodaj(new Sensacja("Król Artur", 3));
        kinoman.dodaj(new Dramat("Król lew", 2));
        kinoman.dodaj(new Komedia("Korona", 2));

        // Lista życzeń klienta Kinoman
        ListaZyczen listaKinomana = kinoman.pobierzListeZyczen();

        System.out.println("Lista życzeń klienta " + listaKinomana);

        // Przed płaceniem, klient przepakuje programy z listy życzeń do koszyka.
        // Możliwe, że na liście życzeń są programy niemające ceny w cenniku,
        // w takim przypadku zostałyby usunięte z koszyka (ale nie z listy życzeń)
        Koszyk koszykKinomana = new Koszyk(kinoman);
        kinoman.przepakuj(koszykKinomana);

        // Co jest na liście życzeń klienta Kinomana
        System.out.println("Po przepakowaniu, lista życzeń klienta " + kinoman.pobierzListeZyczen());

        // Co jest w koszyku klienta Kinoman
        System.out.println("Po przepakowaniu, koszyk klienta " + koszykKinomana);

        // Ile wynosi cena wszystkich programów typu obyczajowego w koszyku klienta
        // Kinoman
        System.out.println(
                "Programy obyczajowe w koszyku klienta Kinoman kosztowały:  " + cena(koszykKinomana, "obyczaj"));

        // Klient zapłaci...
        kinoman.zaplac("karta", false); // płaci kartą płatniczą, prowizja 2%
        // true oznacza, że w przypadku braku środków aplikacja sam odłoży nadmiarowe
        // programy,
        // wpp. rezygnacja z płacenia razem z czyszczeniem koszyka i listy życzeń

        // Ile klientowi Kinoman zostało pieniędzy?
        System.out.println("Po zapłaceniu, klientowi Kinoman zostało: " + kinoman.pobierzPortfel() + " zł");

        // Mogło klientowi zabraknąć srodków, wtedy opcjonalnie programy mogą być
        // odkładane,
        // wpp. koszyk jest pusty po zapłaceniu
        System.out.println("Po zapłaceniu, koszyk klienta " + kinoman.pobierzKoszyk());
        System.out.println("Po zapłaceniu, koszyk klienta " + koszykKinomana);

        // Teraz przychodzi klient Krytyk,
        // deklaruje 60 zł na zamówienia
        Klient krytyk = new Klient("Krytyk", 60, false);

        // Zamówił za dużo jak na tę kwotę
        krytyk.dodaj(new Dramat("Król lew", 2));
        krytyk.dodaj(new Komedia("Królowa", 3));

        // Co klient Krytyk ma na swojej liście życzeń
        System.out.println("Lista życzeń klienta " + krytyk.pobierzListeZyczen());

        Koszyk koszykKrytyka = new Koszyk(krytyk);
        krytyk.przepakuj(koszykKrytyka);

        // Co jest na liście życzeń klienta Krytyk
        System.out.println("Po przepakowaniu, lista życzeń klienta " + krytyk.pobierzListeZyczen());

        // A co jest w koszyku klienta Krytyk
        System.out.println("Po przepakowaniu, koszyk klienta " + krytyk.pobierzKoszyk());

        // klient Krytyk płaci
        krytyk.zaplac("przelew", true); // płaci przelewem, bez prowizji

        // Ile klientowi Krytyk zostało pieniędzy?
        System.out.println("Po zapłaceniu, klientowi Krytyk zostało: " + krytyk.pobierzPortfel() + " zł");

        // Co zostało w koszyku klienta Krytyk (za mało pieniędzy miał)
        System.out.println("Po zapłaceniu, koszyk klienta " + koszykKrytyka);

    }

}

abstract class Program {
    private String tytul;
    private int liczbaUrzadzen;

    public Program(String tytul, int liczbaUrzadzen) {
        this.tytul = tytul;
        this.liczbaUrzadzen = liczbaUrzadzen;
    }

    public String getTytul() {
        return tytul;
    }

    public int getLiczbaUrzadzen() {
        return liczbaUrzadzen;
    }

    public abstract String getTyp();

    public int pobierzCene(boolean maAbonament) {
        Cennik cennik = Cennik.pobierzCennik();
        CenyProgramu cenyProgramu = cennik.pobierzCenyProgramu(getTyp(), tytul);
        if (cenyProgramu == null) {
            return -1;
        }
        return cenyProgramu.getCena(maAbonament, liczbaUrzadzen);
    }

    @Override
    public String toString() {
        return tytul + ", typ: " + getTyp() + ", ile: " + liczbaUrzadzen + " urządzenia";
    }
}

class Obyczaj extends Program {

    public Obyczaj(String tytul, int iloscUrzadzen) {
        super(tytul, iloscUrzadzen);
    }

    @Override
    public String getTyp() {
        return "obyczaj";
    }
}

class Dramat extends Program {
    public Dramat(String tytul, int iloscUrzadzen) {
        super(tytul, iloscUrzadzen);
    }

    @Override
    public String getTyp() {
        return "dramat";
    }
}

class Komedia extends Program {
    public Komedia(String tytul, int iloscUrzadzen) {
        super(tytul, iloscUrzadzen);
    }

    @Override
    public String getTyp() {
        return "komedia";
    }
}

class Sensacja extends Program {

    public Sensacja(String tytul, int iloscUrzadzen) {
        super(tytul, iloscUrzadzen);
    }

    @Override
    public String getTyp() {
        return "sensacja";
    }
}

class Cennik {

    private static Cennik instance = null;
    private Map<String, Map<String, CenyProgramu>> ceny;

    private Cennik() {
        ceny = new HashMap<>();
    }

    public static Cennik pobierzCennik() {
        if (instance == null) {
            instance = new Cennik();
        }
        return instance;
    }

    public void dodaj(String typ, String tytul, int cenaZaWiecejNiz3Urzadzenia, int cenaDo3urzadzen, int liczbaUrzadzen,
            int cenaZAbonamentem) {
        if (!ceny.containsKey(typ)) {
            ceny.put(typ, new HashMap<>());
        }
        ceny.get(typ).put(tytul,
                new CenyProgramu(cenaZaWiecejNiz3Urzadzenia, cenaDo3urzadzen, liczbaUrzadzen, cenaZAbonamentem));
    }

    public void dodaj(String typ, String tytul, int liczbaUrzadzen, int cenaDo2Urzadzen,
            int cenaZaWiecejniz2Urzadzenia) {
        if (!ceny.containsKey(typ)) {
            ceny.put(typ, new HashMap<>());
        }
        ceny.get(typ).put(tytul, new CenyProgramu(liczbaUrzadzen, cenaDo2Urzadzen, cenaZaWiecejniz2Urzadzenia));
    }

    public void dodaj(String typ, String tytul, int cenaZAbonamentem, int cenaBezAbonamentu) {
        if (!ceny.containsKey(typ)) {
            ceny.put(typ, new HashMap<>());
        }
        ceny.get(typ).put(tytul, new CenyProgramu(cenaZAbonamentem, cenaBezAbonamentu));
    }

    public void dodaj(String typ, String tytul) {
        if (!ceny.containsKey(typ)) {
            ceny.put(typ, new HashMap<>());
        }
        ceny.get(typ).put(tytul, new CenyProgramu());
    }

    public CenyProgramu pobierzCenyProgramu(String typ, String tytul) {
        if (ceny.containsKey(typ)) {
            Map<String, CenyProgramu> programy = ceny.get(typ);
            if (programy.containsKey(tytul)) {
                return programy.get(tytul);
            }
        }

        return null;
    }
}

class CenyProgramu {

    private Integer cenaZaWiecejNiz3Urzadzenia;
    private Integer cenaDo3Urzadzen;
    private Integer liczbaUrzadzen;
    private Integer cenaZAbonamentem;
    private Integer cenaDo2Urzadzen;
    private Integer cenaZaWiecejniz2Urzadzenia;
    private Integer cenaBezAbonamentu;

    public CenyProgramu(int cenaZaWiecejNiz3Urzadzenia, int cenaDo3Urzadzen, int liczbaUrzadzen, int cenaZAbonamentem) {
        this.cenaZaWiecejNiz3Urzadzenia = cenaZaWiecejNiz3Urzadzenia;
        this.cenaDo3Urzadzen = cenaDo3Urzadzen;
        this.liczbaUrzadzen = liczbaUrzadzen;
        this.cenaZAbonamentem = cenaZAbonamentem;
    }

    public CenyProgramu(int liczbaUrzadzen, int cenaDo2Urzadzen, int cenaZaWiecejniz2Urzadzenia) {
        this.liczbaUrzadzen = liczbaUrzadzen;
        this.cenaDo2Urzadzen = cenaDo2Urzadzen;
        this.cenaZaWiecejniz2Urzadzenia = cenaZaWiecejniz2Urzadzenia;
    }

    public CenyProgramu(int cenaZAbonamentem, int cenaBezAbonamentu) {
        this.cenaZAbonamentem = cenaZAbonamentem;
        this.cenaBezAbonamentu = cenaBezAbonamentu;
    }

    public CenyProgramu() {
        this.cenaZAbonamentem = 0;
        this.cenaBezAbonamentu = -1;
    }

    public Integer getCena(boolean maAbonament, int liczbaUrzadzen) {
        if (cenaZAbonamentem != null && cenaBezAbonamentu != null) {
            return maAbonament ? cenaZAbonamentem : cenaBezAbonamentu;
        }
        if (cenaDo2Urzadzen != null && cenaZaWiecejniz2Urzadzenia != null) {
            return liczbaUrzadzen <= 2 ? cenaDo2Urzadzen : cenaZaWiecejniz2Urzadzenia;
        }
        if (cenaZaWiecejNiz3Urzadzenia != null && cenaDo3Urzadzen != null && this.liczbaUrzadzen != null
                && cenaZAbonamentem != null) {
            if (maAbonament) {
                return cenaZAbonamentem;
            } else {
                return liczbaUrzadzen <= this.liczbaUrzadzen ? cenaDo3Urzadzen : cenaZaWiecejNiz3Urzadzenia;
            }
        }
        return -1;
    }
}

class ListaZyczen {
    private ArrayList<Program> lista;

    public ListaZyczen() {
        lista = new ArrayList<>();
    }

    public void dodaj(Program program) {
        lista.add(program);
    }

    public boolean usun(Program program) {
        return lista.remove(program);
    }

    public ArrayList<Program> getLista() {
        return lista;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Program program : lista) {
            sb.append(program).append("\n");
        }
        return sb.toString();
    }

    public void remove(Program p) {
        lista.remove(p);
    }

    public void usunWszystko() {
        lista.clear();
    }
}

class Klient {
    private String nazwa;
    private double portfel;
    private boolean abonament;
    private ListaZyczen listaZyczen;
    private Koszyk koszyk;

    public Klient(String nazwa, double portfel, boolean abonament) {
        this.nazwa = nazwa;
        this.portfel = portfel;
        this.abonament = abonament;
        this.listaZyczen = new ListaZyczen();
        this.koszyk = new Koszyk(this);
    }

    public void dodaj(Program program) {
        listaZyczen.dodaj(program);
    }

    public ListaZyczen pobierzListeZyczen() {
        return listaZyczen;
    }

    public Koszyk pobierzKoszyk() {
        return koszyk;
    }

    public void przepakuj(Koszyk koszykKinomana) {
        this.koszyk = koszykKinomana;

        for (Program p : listaZyczen.getLista()) {
            if (p.pobierzCene(abonament) != -1) {
                koszykKinomana.dodaj(p);
            }
        }

        for (Program p : koszyk.getKoszyk()) {
            listaZyczen.remove(p);
        }

    }

    private void odkladajProgramy() {
        System.out.println("Odkładam programy, które nie mieszczą się w dostępnym budżecie.");

        Map<String, List<Program>> nowyKoszyk = new HashMap<>();
        for (Map.Entry<String, List<Program>> entry : this.koszyk.getKoszyk().entrySet()) {
            String programTyp = entry.getKey();
            List<Program> programy = entry.getValue();
            List<Program> noweProgramy = new ArrayList<>();
            for (Program program : programy) {
                int cena = program.pobierzCene(this.abonament);
                if (cena <= this.portfel) {
                    noweProgramy.add(program);
                    this.portfel -= cena;
                } else {
                    this.listaZyczen.dodaj(program);
                }
            }
            if (!noweProgramy.isEmpty()) {
                nowyKoszyk.put(programTyp, noweProgramy);
            }
        }

    }

    public void zaplac(String typPlatnosci, boolean odkladanieProgramow) {
        int cena = 0;
        boolean maAbonament = this.maAbonament();
        List<Program> koszyk = this.koszyk.getKoszyk();

        for (Program program : koszyk) {
            cena += program.pobierzCene(maAbonament);
        }
        double prowizja = 0;
        if (typPlatnosci.equals("karta")) {
            prowizja = 0.02 * cena;
        }
        double oplata = cena + prowizja;
        if (this.portfel < oplata) {
            System.out.println("op" + oplata + " p" + portfel);
            if (odkladanieProgramow) {
                this.koszyk.usunWszystko();
                this.listaZyczen.usunWszystko();
            } else {
                this.koszyk.usunWszystko();
            }
            return;
        }
        this.portfel -= oplata;
        this.koszyk.usunWszystko();

    }

    public double pobierzPortfel() {
        return portfel;
    }

    public boolean czyMaAbonament() {
        return abonament;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "nazwa='" + nazwa + '\'' +
                ", portfel=" + portfel +
                ", abonament=" + abonament +
                '}';
    }

    public boolean maAbonament() {
        return abonament;
    }
}

class Koszyk {
    private List<Program> listaProgramow;
    private Klient klient;

    public Koszyk(Klient klient) {
        this.klient = klient;
        this.listaProgramow = new ArrayList<>();
    }

    public void dodajProgram(Program program) {
        listaProgramow.add(program);
    }

    public void dodajProgramy(List<Program> programy) {
        listaProgramow.addAll(programy);
    }

    public double obliczCene() {
        double suma = 0;
        for (Program program : listaProgramow) {
            suma += program.getCena();
        }
        return suma;
    }

    public void usunWszystkie() {
        listaProgramow.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Program program : getKoszyk()) {
            sb.append(program).append("\n");
        }
        return sb.toString();
    }

    public Klient getKlient() {
        return klient;
    }

    public List<Program> getKoszyk() {
        return listaProgramow;
    }

    public void dodaj(Program p) {
        listaProgramow.add(p);
    }

    public void usunWszystko() {
        listaProgramow.clear();
    }
}
