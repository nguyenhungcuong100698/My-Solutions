package Main;

import GUI.MainFrame;
import manager.managerCD;
import entity.CD;
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

    managerCD myManager;
    Scanner scan;
    MainFrame myMainFrame;

    public Menu() {
        myManager = new managerCD();
        scan = new Scanner(System.in);
        myMainFrame = new MainFrame(myManager, "Information");
    }

    public void displayMenu() {
        do {
            System.out.println("-----------------------------------------");
            System.out.println("0. Restore data from file");
            System.out.println("1. Add CD:");
            System.out.println("2. Search CD by CD title");
            System.out.println("3. Search CDs by collection(game/movie/music) ");
            System.out.println("4. Search CDs by type(audio/video)");
            System.out.println("5. Delete CD by CD id");
            System.out.println("6. Edit CD information by CD id");
            System.out.println("7. Display all CDs");
            System.out.println("8. Show GUI");
            System.out.println("9. Exist");
            System.out.println("What do you want?");
            int choice = scan.nextInt();
            System.out.println("-----------------------------------------");
            switch (choice) {
                case 0:
                    displayRestore();
                    break;
                case 1:
                    displayAddCD();
                    break;
                case 2:
                    displaySearchCdByInfo();
                    break;
                case 3:
                    displaySearchCdByCollection();
                    break;
                case 4:
                    displaySearchCdByType();
                    break;
                case 5:
                    displayDeleteByID();
                    break;
                case 6:
                    displayEditByID();
                    break;
                case 7:
                    displayShowAll(myManager.showAll());
                    break;
                case 8:
                    this.myMainFrame.Create();
                    break;
                default:
                    break;
            }
            if (choice == 9) {
                System.out.println("Do you want to save the data?");
                if (scan.next().equalsIgnoreCase("YES")) {
                    myManager.saving();
                }
                break;
            }
        } while (true);
    }

    public void displayRestore() {
        int num = this.myManager.restore();
        System.out.println("Restore sucessful, there are " + num + " objects.");
    }

    public void displayShowAll(ArrayList CdArray) {
        CD temp;
        for (int i = 0; i < CdArray.size(); i++) {
            temp = (CD) CdArray.get(i);
            displayShowOne(temp);
        }
    }

    public void displayShowOne(CD cd) {
        System.out.println("-------------------------------------");
        System.out.println("ID:\t\t\t" + cd.getId());
        System.out.println("Collection:\t\t" + cd.getCollection());
        System.out.println("Type:\t\t\t" + cd.getType());
        System.out.println("Title:\t\t\t" + cd.getTitle());
        System.out.println("Price:\t\t\t" + cd.getPrice());
        System.out.println("Year of release:\t" + cd.getYearRelease());
        System.out.println("-----------------------------------");

    }

    public void displayAddCD() {
        scan.nextLine();
        System.out.println("Enter new CD id: ");
        String id = scan.nextLine();
        System.out.println("Enter the CD collection (game/movie/music): ");
        String collection = scan.nextLine();
        System.out.println("Enter the CD type (audio/video): ");
        String type = scan.nextLine();
        System.out.println("Enter the CD title: ");
        String title = scan.nextLine();
        System.out.println("Enter the CD price: ");
        double price = scan.nextDouble();
        System.out.println("Enter the CD year of release: ");
        int yearRelease = scan.nextInt();
        if (myManager.addCD(id, collection, type, title, price, yearRelease)) {
            System.out.println("Sucessful");
            displayShowOne(this.myManager.showAll().get(this.myManager.showAll().size() - 1));
        } else {
            System.out.println("Unsucessful");
        }
    }

    public void displaySearchCdByInfo() {
        System.out.print("Enter the title:");
        ArrayList temp = myManager.searchByInfo(scan.nextLine());
        if (temp.isEmpty()) {
            System.out.println("Unsucessful");
        } else {
            System.out.println("Sucessful");
            displayShowAll(temp);
        }
    }

    public void displaySearchCdByCollection() {
        System.out.print("Enter the collection(game/movie/music):");
        ArrayList temp = myManager.searchByInfo(scan.nextLine());
        if (temp.isEmpty()) {
            System.out.println("Unsucessful");
        } else {
            System.out.println("Sucessful");
            displayShowAll(temp);
        }
    }

    public void displaySearchCdByType() {
        System.out.print("Enter the type(audio/video):");
        ArrayList temp = myManager.searchByInfo(scan.next());
        if (temp.isEmpty()) {
            System.out.println("Unsucessful");
        } else {
            System.out.println("Sucessful");
            displayShowAll(temp);
        }
    }

    public void displayDeleteByID() {
        System.out.print("Enter the ID: ");
        int res = myManager.searchByID(scan.nextLine());
        if (res != -1) {
            displayShowOne(myManager.showAll().get(res));
            System.out.print("Enter YES to confirm:");
            if (scan.next().equalsIgnoreCase("YES")) {
                myManager.deleteByID(myManager.showAll().get(res));
                System.out.println("Deleted");
            }
        } else {
            System.out.println("Cannot find CD");
        }
    }

    public void displayEditByID() {
        System.out.print("Enter the ID:");
        int temp = myManager.searchByID(scan.nextLine());
        if (temp != -1) {
            int choice;
            do {
                displayShowOne(myManager.showAll().get(temp));
                System.out.println("Choose what to edit: ");
                System.out.println("1. Colletion");
                System.out.println("2. Type");
                System.out.println("3. Title");
                System.out.println("4. Price");
                System.out.println("5. Year of release");
                System.out.println("6. Exist");
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("The current collection is: " + myManager.showAll().get(temp).getCollection());
                        System.out.print("Enter the new collection: ");
                        String collection = scan.nextLine();
                        if (myManager.checkCollection(collection)) {
                            myManager.showAll().get(temp).setCollection(collection);
                            System.out.println("Sucessful");
                            displayShowOne(myManager.showAll().get(temp));
                        } else {
                            break;
                        }
                        break;
                    case 2:
                        System.out.println("The current type is: " + myManager.showAll().get(temp).getType());
                        System.out.print("Enter the new type: ");
                        String type = scan.nextLine();
                        if (myManager.checkType(type)) {
                            myManager.showAll().get(temp).setType(type);
                            System.out.println("Sucessful");
                            displayShowOne(myManager.showAll().get(temp));
                        } else {
                            break;
                        }
                        break;
                    case 3:
                        System.out.println("The current title is: " + myManager.showAll().get(temp).getTitle());
                        System.out.print("Enter the new title: ");
                        myManager.showAll().get(temp).setCollection(scan.nextLine());
                        System.out.println("Sucessful");
                        displayShowOne(myManager.showAll().get(temp));
                        break;
                    case 4:
                        System.out.println("The current price is: " + myManager.showAll().get(temp).getPrice());
                        System.out.print("Enter the new price: ");
                        myManager.showAll().get(temp).setPrice(scan.nextDouble());
                        System.out.println("Sucessful");
                        displayShowOne(myManager.showAll().get(temp));
                        break;
                    case 5:
                        System.out.println("The current year of release is: " + myManager.showAll().get(temp).getYearRelease());
                        System.out.print("Enter the new year: ");
                        myManager.showAll().get(temp).setYearRelease(scan.nextInt());
                        System.out.println("Sucessful");
                        displayShowOne(myManager.showAll().get(temp));
                        break;
                    default:
                        break;
                }
            } while (choice != 6);
        } else {
            System.out.println("Cannot find CD");
        }
    }
}
