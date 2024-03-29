package Programy;

import Cennik.*;

// An abstract class that represents a program with a title, genre, device count and price
public abstract class Program {
    private String title;
    private String genre; 
    private int deviceCount;

    public Program(String title, String genre, int deviceCount) {
        this.title = title;
        this.genre = genre;
        this.deviceCount = deviceCount;
    }

    // A method that returns the price of the program based on the genre, title and
    // device count
    // It uses the Cennik class to get the matching item for the given title and
    // genre
    // It returns null if no matching item is found or if the regular price is null
    // It returns 0 if the program is part of a subscription and has no regular
    // price
    // It returns the appropriate price based on the device count and whether it is
    // below or above a certain threshold
    public Integer getCena(boolean abonament, int deviceCount) {

        CennikItem x = Cennik.pobierzCennik()
                .getGenreList(genre)
                .stream()
                .filter(item -> item.getTitle().equals(this.getTitle()))
                .findFirst()
                .orElse(null);

        if (x == null)
            return null;

        if (x.getRegularPrice() == null)
            return abonament
                    ? 0 // abonament: true
                    : null; // abonament: false

        if (x.getUpToCountPrice() == null)
            return abonament
                    ? x.getAbonamentPrice()
                    : x.getRegularPrice();

        if (deviceCount <= x.getDeviceCount()) {
            if (x.getAbonamentPrice() == null)
                return x.getUpToCountPrice();
            else
                return abonament
                        ? x.getAbonamentPrice()
                        : x.getUpToCountPrice();
        }
        return x.getRegularPrice();
    }

    public Integer getCena(boolean abonament) {
        return getCena(abonament, this.deviceCount);
    }

    // A method that returns a string representation of the program with its fields
    @Override
    public String toString() {
        return title + ", typ: " + genre + ", ile: " + deviceCount + " urządzeń";
    }

    // Getters and setters for the fields

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(int deviceCount) {
        this.deviceCount = deviceCount;
    }
}
