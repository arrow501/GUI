public class Samochod implements Comparable<Samochod> {
    private int price;
    private String brand;

    public Samochod(int price, String brand) {
        this.price = price;
        this.brand = brand;
    }

    @Override
    public int compareTo(Samochod o) {
        // TODO Auto-generated method stub
        return this.price - o.getPrice();
    }

    public Samochod(String price, String brand) {
        this(Integer.parseInt(price), brand);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

}
