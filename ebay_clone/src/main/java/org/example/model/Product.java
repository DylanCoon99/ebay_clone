package org.example.model;
import java.sql.Blob;

public class Product {

    private int productID;
    private String name;
    private float price;
    private String description;

    // think about how to display an image for each product
    // private ____ image;
    private Blob image;


    // set productID
    public void setProductID(int productID) {
        this.productID = productID;
    }

    // get productID
    public int getProductID() {
        return this.productID;
    }

    // set name
    public void setName(String name) {
        this.name = name;
    }

    // get name
    public String getName() {
        return this.name;
    }

    // set price
    public void setPrice(float price) {
        this.price = price;
    }

    // get price
    public double getPrice() {
        return this.price;
    }

    // set description
    public void setDescription(String description) {
        this.description = description;
    }

    // get description
    public String getDescription() {
        return this.description;
    }

    public void setImage(Blob image) { this.image = image;}

    public Blob getImage() { return this.image;}
}
