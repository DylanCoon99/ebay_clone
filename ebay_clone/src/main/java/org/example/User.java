package org.example;

public class User {

    // user attributes
    private String username;
    private String email;
    private String password; // eventually store hashed version of the password for security purposes
    private String cardNo;

    // no need for a constructor at the moment

    // set username
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardNo() {
        return this.cardNo;
    }





}
