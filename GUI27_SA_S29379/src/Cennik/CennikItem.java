package Cennik;

class CennikItem {
    private String title;
    private String genre;
    private int deviceCount;
    private int regularPrice;
    private int upToCountPrice;
    private int abonamentPrice;

    public CennikItem(String title, String genre, int regularPrice, int abonamentPrice, int upToCountPrice,
            int deviceCount) {
        this.title = title;
        this.genre = genre;
        this.deviceCount = deviceCount;
        this.regularPrice = regularPrice;
        this.upToCountPrice = upToCountPrice;
        this.abonamentPrice = abonamentPrice;
    }

    public int getRegularPrice() {
        return regularPrice;
    }

    public int getUpToCountPrice() {
        return upToCountPrice;
    }

    public int getAbonamentPrice() {
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