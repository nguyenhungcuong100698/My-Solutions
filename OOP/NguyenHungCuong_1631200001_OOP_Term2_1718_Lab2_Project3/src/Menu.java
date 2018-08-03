
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
    Scanner scan = new Scanner(System.in);
    
    private Account account = null;

    public Menu() {
        account = new Account();
    }
    
    public void displayMenu(){
    do {
            System.out.println("1.Show the balance");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Exit");
            System.out.println("What do you want?");
            int temp = scan.nextInt();
            switch (temp)
            {
                case 1 : System.out.println("Your balance is: "+account.getBalance());
                            break;
                case 2 : account.deposit();
                            break;
                case 3 : account.withdraw();
                            break;
                default : break;
            }
            if (temp == 4) break;
        } while (true);
    }
}
