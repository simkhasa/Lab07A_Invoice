public class LineItem {
    //attributes
    private Product product;
    private double quantity;

    //constructor
    public LineItem(Product product, double quantity){
        this.product = product;
        this.quantity = quantity;
    }

    //methods
    public Product GetProduct(){
        return product;
    }

    public double GetQuantity(){
        return quantity;
    }

    public double CalculateTotal(){
        return product.GetPrice() * quantity;
    }
}