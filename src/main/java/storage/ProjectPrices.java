package storage;

public class ProjectPrices {
    private int id;
    private int price;

    public ProjectPrices(int id, int price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProjectPrices{" +
                "id='" + id + '\'' +
                ", price=" + price +
                '}';
    }
}

