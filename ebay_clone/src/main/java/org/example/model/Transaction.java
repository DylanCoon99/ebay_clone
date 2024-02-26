package org.example.model;

public class Transaction {

    private int transactionId;
    private int buyerID;
    private int sellerID;
    private int productID;
    private float bid;

    public Transaction(int transaction_id, int seller_id, int buyer_id, int product_id, float bid) {
        setTransactionID(transaction_id);
        setBuyerID(buyer_id);
        setSellerID(seller_id);
        setProductID(product_id);
        setBid(bid);
    }

    public void setTransactionID(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getTransactionID() {return this.transactionId; }

    public void setBuyerID(int buyerID) {
        this.buyerID = buyerID;
    }

    public int getBuyerID() {
        return this.buyerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public int getSellerID() {
        return this.sellerID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getProductID() {
        return this.productID;
    }

    public void setBid(float bid) {this.bid = bid; }

    public float getBid() {return this.bid; }

}
