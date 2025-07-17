package com.addressbook;

import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Service serv = new Service();
        Utility util = new Utility();
        @SuppressWarnings("unchecked")
        Contact persons[] = new Contact[26];
        
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
