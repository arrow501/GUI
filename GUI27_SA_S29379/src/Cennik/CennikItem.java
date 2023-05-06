package Cennik;

// A class that represents an item in the price list with a title, genre and different prices
public class CennikItem {
    private String title;
    private String genre;
    private Integer deviceCount;
    private Integer regularPrice;
    private Integer upToCountPrice;
    private Integer abonamentPrice;

    public CennikItem(String title, String genre, Integer regularPrice, Integer abonamentPrice, Integer upToCountPrice,
            int deviceCount) {
        this.title = title;
        this.genre = genre;
        this.deviceCount = deviceCount;
        this.regularPrice = regularPrice;
        this.upToCountPrice = upToCountPrice;
        this.abonamentPrice = abonamentPrice;
    }

    // A method that returns a string representation of the item with its fields
    @Override
    public String toString() {
        return "CennikItem [title=" + title + ", genre=" + genre + ", deviceCount=" + deviceCount + ", regularPrice="
                + regularPrice + ", upToCountPrice=" + upToCountPrice + ", abonamentPrice=" + abonamentPrice + "]";
    }

    // Getters for the fields
    public Integer getRegularPrice() {
        return regularPrice;
    }

    public Integer getUpToCountPrice() {
        return upToCountPrice;
    }

    public Integer getAbonamentPrice() {
        return abonamentPrice;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDeviceCount() {
        return deviceCount;
    }


}