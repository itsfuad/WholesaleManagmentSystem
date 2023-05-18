package Types;

public class Product {
    public String productID;
    public String productName;
    public String productPrice;
    public String productQuantity;
    public String productManufacturer;
    public String manufacturingDate;
    public String expiryDate;

    public Product(String productID, String productName, String productPrice, String productQuantity, String productManufacturer, String manufacturingDate, String expiryDate){
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productManufacturer = productManufacturer;
        System.out.println(this.productManufacturer + " " + productManufacturer);
        this.manufacturingDate = manufacturingDate;
        this.expiryDate = expiryDate;
    }
}
