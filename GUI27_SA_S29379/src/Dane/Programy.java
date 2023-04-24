package Dane;

import java.util.ArrayList;
import java.util.List;

public class Programy {
    private List<Program> items = new ArrayList<>();

    public Programy(List<Program> items) {
        this.items = items;
    }

    public Programy() {
    }

    public List<Program> getItems() {
        return items;
    }

    public void setItems(List<Program> items) {
        this.items = items;
    }

}