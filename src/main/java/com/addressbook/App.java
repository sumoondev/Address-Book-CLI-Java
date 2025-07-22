package com.addressbook;

import sun.nio.ch.Util;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Utility util = new Utility();
        Contact persons = util.loadContacts();

        Service serv = new Service(persons);
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
            Utility.clearConsole();
            System.out.println("=== Address Book CLI ===\n");
            System.out.println("1) Add Contact\n2) List All Contacts\n3) Search Contacts\n4) Edit Contact\n5) Delete Contact\n0) Exit");
            System.out.print("Enter Choice: ");
            String choice = sc.nextLine();
            switch(choice) {
                case "1":
                    serv.addContact(sc);
                    break;
                case "2":
                    serv.listContact();
                    Utility.pressEnterToContinue();
                    break;
                case "3":
                    serv.searchContact(sc);
                    Utility.pressEnterToContinue();
                    break;
                case "4":
                    serv.editContact(sc);
                    break;
                case "5":
                    serv.deleteContact(sc);
                    break;
                case "0":
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
            util.saveContacts(serv.contacts());
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
