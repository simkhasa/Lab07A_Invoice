public class Customer {
    //attributes
    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;

    //constructor
    public Customer(String name, String streetAddress, String city, String state, String zipCode){
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    //methods
    public String GetName(){
        return name;
    }

    public String GetStreetAddress(){
        return streetAddress;
    }

    public String GetCity(){
        return city;
    }

    public String GetState(){
        return state;
    }

    public String GetZipCode(){
        return zipCode;
    }
}