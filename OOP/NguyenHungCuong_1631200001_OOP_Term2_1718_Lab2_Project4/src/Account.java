/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TOSHIBA
 */
public class Account {
    private int accountID;
    private String accountName;
    private double balance;

    public Account(int accountID, String accountName, double balance) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.balance = balance;
    }

    public Account() {
        this.accountID = 0;
        this.accountName = "";
        this.balance = 0;
    }

    
    
    public int getAccountID() {
        return accountID;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
}
