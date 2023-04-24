package Dane;

public abstract class Program {
    private String title;
    private String genre;
    private int deviceCount;

    public Program(String title, String genre, int deviceCount) {
        this.title = title;
        this.genre = genre;
        this.deviceCount = deviceCount;
    }

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
