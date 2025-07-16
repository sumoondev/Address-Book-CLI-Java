package com.addressbook.main;

// import com.addressbook.model.Contact;
import com.addressbook.service.Service;
// import com.addressbook.util.Utility;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Service serv = new Service();
        // Utility util = new Utility();
        // Contact persons[] = new Contact[26];

        Scanner sc = new Scanner(System.in);
        
        boolean isExit = false;
        System.out.println("Loading state ");
        // util.readJson(persons);

        while(!isExit) {
            try {
                Thread.sleep(500);
                System.out.print(".");
                Thread.sleep(500);
                System.out.print(".");
                Thread.sleep(500);
                System.out.println(".");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("=== Address Book CLI ===\n");
            System.out.println("1) Add Contact\n2) List All Contacts\n3) Search Contacts\n4) Edit Contact\n5) Delete Contact\n6) Import vCard (.vcf)\n7) Export Contact to vCard\n8) Undo Last Action\n9) Redo Last Action\n0) Exit");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    serv.addContact(sc);
                    break;
                case 2:
                    
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 0:
                    isExit = true;
                    break;
                default:
                    System.out.println("Invalid input!!");
            }
        }
        System.out.print("Saving state and Exiting ");
        try {
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.println(".");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        sc.close();
    }
}
