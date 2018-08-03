
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author TOSHIBA
 */
public class AccountManager {

    ArrayList<Account> accountArray;

    public AccountManager() {
        accountArray = new ArrayList<>();
    }

    Scanner scan = new Scanner(System.in);

    public boolean addAccount(int accountID, String name, double balance) {
            accountArray.add(new Account(accountID, name, balance));
            return true; 
    }

    public ArrayList showAllAccount() {
        return accountArray;
    }

    public int findAccount(int ID) {
        int i;
        for (i = 0; i < accountArray.size(); i++) {
            if (accountArray.get(i).getAccountID() == ID) {
                break;
            }
        }
        return (i==accountArray.size())?-1:i;
    }

    public void showAccount(int i) {
        if (i == -1) {
            System.out.println("------------------------------------");
            System.out.println("Cannot find!");
        } else {
            System.out.println("----------------------------------------");
            System.out.println("Name:\t\t" + accountArray.get(i).getAccountName());
            System.out.println("Account ID:\t\t" + accountArray.get(i).getAccountID());
            System.out.println("Balance:\t\t" + accountArray.get(i).getBalance());
            System.out.println("-----------------------------------");
        }
    }
    public void doDelete(int i){
        accountArray.remove(accountArray.get(i));
    }
    
    
}
