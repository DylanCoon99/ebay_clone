package org.example.model;

public class User {

    // user attributes
    private Integer userID;
    private String username;
    private String email;
    private String password; // eventually store hashed version of the password for security purposes
    private String cardNo;


    // set userID
    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    // get userIDmy
    public Integer getUserID() {
        return this.userID;
    }

    // set username
    public void setUsername(String username) {
        this.username = username;
    }

    // get username
    public String getUsername() {
        return this.username;
    }

    //set password
    public void setPassword(String password) {
        this.password = password;
    }

    // get password
    public String getPassword() {
        return this.password;
    }

    // set email
    public void setEmail(String email) {
        this.email = email;
    }

    // get email
    public String getEmail() {
        return this.email;
    }

    // set cardNo
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    // get cardNo
    public String getCardNo() {
        return this.cardNo;
    }

}
