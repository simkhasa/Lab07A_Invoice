public class Product {
    //attributes

    private String name;
    private double price;

    //constructor
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //methods
    public String GetName() {
        return name;
    }

    public double GetPrice() {
        return price;
    }
}