import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class InvoiceGUIFrame extends JFrame {
    JPanel mainPanel;
    JPanel invoicePanel;
    JPanel controlsPanel;

    JTextArea invoiceTextArea;
    JScrollPane invoiceScrollPane;

    JComboBox productComboBox;
    JSpinner quantitySpinner;
    JButton addButton;
    JButton quitButton;

    ArrayList<Product> products;
    Customer customer;
    Invoice invoice;

    public InvoiceGUIFrame() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        createInvoicePanel();
        mainPanel.add(invoicePanel, BorderLayout.CENTER);
        controlsPanel = new JPanel();

        createControlsPanel();
        mainPanel.add(controlsPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createInvoicePanel() {
        invoicePanel = new JPanel();
        invoicePanel.setBorder(new TitledBorder(new EtchedBorder(), "Invoice"));
        invoiceTextArea = new JTextArea(20, 38);
        invoiceScrollPane = new JScrollPane(invoiceTextArea);

        customer = new Customer("Some Stuff", "Clifton Avenue", "Cincinnati", "OH", "12345");
        invoice = new Invoice(customer);

        invoicePanel.add(invoiceScrollPane);
    }

    private void createControlsPanel() {
        controlsPanel = new JPanel();
        controlsPanel.setBorder(new TitledBorder(new EtchedBorder(), "Controls"));
        productComboBox = new JComboBox();
        populateProductComboBox();
        for (Product product : products) {
            productComboBox.addItem(product.GetName());
        }
        quantitySpinner = new JSpinner();

        addButton = new JButton("Add Item");
        addButton.addActionListener(e -> {
            addInvoiceItem();
            displayInvoice();
        });
        quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> System.exit(0));

        controlsPanel.setLayout(new GridLayout(2, 2));
        controlsPanel.add(productComboBox);
        controlsPanel.add(quantitySpinner);
        controlsPanel.add(addButton);
        controlsPanel.add(quitButton);
    }

    private void populateProductComboBox() {
        products = new ArrayList<Product>();
        products.add(new Product("A bus", 29.95));
        products.add(new Product("Candy Corn", 24.95));
        products.add(new Product("Car", 19.99));
    }

    private void addInvoiceItem() {
        Product selectedProduct = products.get(productComboBox.getSelectedIndex());
        int quantity = (int) quantitySpinner.getValue();
        LineItem item = new LineItem(selectedProduct, quantity);
        invoice.addLineItem(item);
    }

    private void displayInvoice() {
        String invoiceString = "";
        invoiceString = "\t\t" + invoice.getTitle() + "\n\n";

        invoiceString += customer.GetName() + "\n";
        invoiceString += customer.GetStreetAddress() + "\n";
        invoiceString += customer.GetCity() + ", " + customer.GetState() + " " + customer.GetZipCode() + "\n\n";
        invoiceString += "====================================\n";
        invoiceString += "Item\tQty\tPrice\tTotal\n";
        for (LineItem item : invoice.getLineItems()) {
            Product product = item.GetProduct();
            invoiceString += product.GetName() + "\t" + item.GetQuantity() + "\t" + product.GetPrice() + "\t" + item.CalculateTotal() + "\n";
        }

        invoiceString += "====================================\n";
        invoiceString += "AMOUNT DUE: $" + invoice.getTotalAmountDue() + "\n";

        invoiceTextArea.setText(invoiceString);
    }
}