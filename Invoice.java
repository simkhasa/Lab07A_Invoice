import java.util.ArrayList;

public class Invoice {
    //attributes
    private String title = "Invoice";
    private Customer customer;
    private ArrayList<LineItem> lineItems;

    //constructor
    public Invoice(Customer customer){
        this.customer = customer;
        lineItems = new ArrayList<LineItem>();
    }

    //methods
    public String getTitle() {
        return title;
    }

    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void addLineItem(LineItem item){
        lineItems.add(item);
    }

    public double getTotalAmountDue(){
        double total = 0;
        for (LineItem item : lineItems){
            total += item.CalculateTotal();
        }
        return total;
    }
}