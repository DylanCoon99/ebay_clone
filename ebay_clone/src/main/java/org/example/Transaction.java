package org.example;

public class Transaction {

    private Integer buyerID;
    private Integer sellerID;
    private Integer productID;

    public void setBuyerID(Integer buyerID) {
        this.buyerID = buyerID;
    }

    public Integer getBuyerID() {
        return this.buyerID;
    }

    public void setSellerID(Integer sellerID) {
        this.sellerID = sellerID;
    }

    public Integer getSellerID() {
        return this.sellerID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getProductID() {
        return this.productID;
    }

}
