
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
public class Menu {

    private Scanner scan;
    private AccountManager myAccountManager;

    public Menu() {
        scan = new Scanner(System.in);
        myAccountManager = new AccountManager();
    }

    public void displayMenu() {
        do {
            System.out.println("-----------------------------------------");
            System.out.println("1. Add account:");
            System.out.println("2. Show all account");
            System.out.println("3. Find account ");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Exist");
            System.out.println("What do you want?");
            int temp = scan.nextInt();
            System.out.println("-----------------------------------------");
            switch (temp) {
                case 1:
                    displayAddAccount();
                    break;
                case 2:
                    displayShowAllAccount();
                    break;
                case 3:
                    displayFindAccount();
                    break;
                case 4:
                    displayUpdate();
                    break;
                case 5:
                    displayDelete();
                    break;
                default:
                    break;
            }
            if (temp == 6) {
                break;
            }
        } while (true);
    }

    private void displayDelete() {
        System.out.println("Enter the account ID: ");
        int temp = myAccountManager.findAccount(scan.nextInt());
        if (temp != 1) {
            myAccountManager.showAccount(temp);
            System.out.println("Enter YES to confirm ");
            if (scan.next().equalsIgnoreCase("YES")) {
                myAccountManager.doDelete(temp);
                System.out.println("Deleted");
            }
        } else {
            System.out.println("Cannot find the account");
        }
    }

    private void displayFindAccount() {
        System.out.println("Enter the account ID: ");
        int temp = myAccountManager.findAccount(scan.nextInt());
        if (temp != -1) {
            System.out.println("Sucessful");
            myAccountManager.showAccount(temp);
        } else {
            System.out.println("Cannot find");
        }
    }

    private void displayAddAccount() {
        System.out.println("Enter new account name: ");
        String name = scan.next();
        System.out.println("Enter new account ID: ");
        int accountID = scan.nextInt();
        System.out.println("Enter new account balance: ");
        double balance = scan.nextDouble();
        if (myAccountManager.addAccount(accountID, name, balance)) {
            System.out.println("Sucessful");
            myAccountManager.showAccount(myAccountManager.findAccount(accountID));
        } else {
            System.out.println("Unsucessful");
        }
    }

    private void displayShowAllAccount() {
        ArrayList accountArray = this.myAccountManager.showAllAccount();
        for (int i = 0; i < accountArray.size(); i++) {
            Account temp = (Account) accountArray.get(i);
            System.out.println("-------------------------------------");
            System.out.println("Name:\t\t" + temp.getAccountName());
            System.out.println("Account ID:\t\t" + temp.getAccountID());
            System.out.println("Balance:\t\t" + temp.getBalance());
            System.out.println("-----------------------------------");
        }
    }

    private void displayUpdate() {
        System.out.println("Enter the ID that you want to update: ");
        int updateAccount = myAccountManager.findAccount(scan.nextInt());
        if (updateAccount != -1) {
            System.out.println("Choose the properties: ");
            System.out.println("1. Name");
            System.out.println("2. Balance");
            System.out.println("3. Both");
            int choose = scan.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("The current name is: "+myAccountManager.accountArray.get(updateAccount).getAccountName());
                    System.out.println("....................................");
                    System.out.println("Enter the new name: ");
                    myAccountManager.accountArray.get(updateAccount).setAccountName(scan.next());
                    System.out.println("Sucessful");
                    myAccountManager.showAccount(updateAccount);
                    break;
                case 2:
                    System.out.println("The current balance is: "+myAccountManager.accountArray.get(updateAccount).getBalance());
                    System.out.println("....................................");
                    System.out.println("Enter the new balance: ");
                    myAccountManager.accountArray.get(updateAccount).setBalance(scan.nextInt());
                    System.out.println("Sucessful");
                    myAccountManager.showAccount(updateAccount);
                    break;
                case 3:
                    System.out.println("The current name is: "+myAccountManager.accountArray.get(updateAccount).getAccountName());
                    System.out.println("....................................");
                    System.out.println("Enter the new name: ");
                    myAccountManager.accountArray.get(updateAccount).setAccountName(scan.next());
                    System.out.println("The current balance is: "+myAccountManager.accountArray.get(updateAccount).getBalance());
                    System.out.println("....................................");
                    System.out.println("Enter the new balance: ");
                    myAccountManager.accountArray.get(updateAccount).setBalance(scan.nextInt());
                    System.out.println("Sucessful");
                    myAccountManager.showAccount(updateAccount);
                    break;
            }
        } else {
            System.out.println("Cannot find");
        }

    }
}
