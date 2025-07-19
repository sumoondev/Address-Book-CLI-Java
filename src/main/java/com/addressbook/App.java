package com.addressbook;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Contact persons[] = new Contact[26];
        Service serv = new Service();
        Utility util = new Utility();
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
            Utility.clearConsole();
            System.out.println("=== Address Book CLI ===\n");
            System.out.println("1) Add Contact\n2) List All Contacts\n3) Search Contacts\n4) Edit Contact\n5) Delete Contact\n0) Exit");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    serv.addContact(sc,persons);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid command. Please try again");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
            }
        }

        try {
            util.saveContacts(persons);
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.println(".");
            System.out.println("Contact saved");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        sc.close();
    }
}
