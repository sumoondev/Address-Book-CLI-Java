package com.addressbook;

//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//
//import java.io.*;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

public class Service {
    private static Contact root = null;
    public Service(Contact persons) {
        root = persons;
    }

    private static void printInvalid(int t) {
        try {
            Thread.sleep(100);
            System.out.print("I");
            Thread.sleep(100);
            System.out.print("n");
            Thread.sleep(100);
            System.out.print("v");
            Thread.sleep(100);
            System.out.print("a");
            Thread.sleep(100);
            System.out.print("l");
            Thread.sleep(100);
            System.out.print("i");
            Thread.sleep(100);
            System.out.print("d ");
            Thread.sleep(100);
            System.out.print("!");
            Thread.sleep(100);
            System.out.print("!");

            System.out.print("      Try " + t + " / 3");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static boolean isNameValid(String name) {
        String nameRegex = "^[a-zA-Z-'\\s]+ [a-zA-Z-'\\s]+$";
        return name.matches(nameRegex);
    }

    public static boolean isValidGmail(String email) {
        String validate = "@gmail.com";
        if(email.length() <= validate.length()) {
            return false;
        }

        if(email.substring(email.length() - validate.length()).equals(validate)) {
            return true;
        }

        return false;
    }

    public static void display(int t) {
        Utility.clearConsole();
        System.out.println("=== Add Contact ===\n");
        System.out.print("Full Name : ");

        printInvalid(t);

        Utility.clearConsole();
        System.out.println("=== Add Contact ===\n");
        System.out.print("Full Name : ");
    }

    public static void display(String name, int t) {
        Utility.clearConsole();
        System.out.println("=== Add Contact ===\n");
        System.out.println("Full Name : " + name);
        System.out.print("Mobile : ");

        printInvalid(t);

        Utility.clearConsole();
        System.out.println("=== Add Contact ===\n");
        System.out.println("Full Name : " + name);
        System.out.print("Mobile : ");
    }

    public static void display(String name, long mobile, int t) {
        Utility.clearConsole();
        System.out.println("=== Add Contact ===\n");
        System.out.println("Full Name : " + name);
        System.out.println("Mobile : " + mobile);
        System.out.print("Address : ");

        printInvalid(t);

        Utility.clearConsole();
        System.out.println("=== Add Contact ===\n");
        System.out.println("Full Name : " + name);
        System.out.println("Mobile : " + mobile);
        System.out.print("Address : ");
    }

    public static void display(String name, long mobile, String address, int t) {
        Utility.clearConsole();
        System.out.println("=== Add Contact ===\n");
        System.out.println("Full Name : " + name);
        System.out.println("Mobile : " + mobile);
        System.out.println("Address : " + address);
        System.out.print("Gmail : ");

        printInvalid(t);

        Utility.clearConsole();
        System.out.println("=== Add Contact ===\n");
        System.out.println("Full Name : " + name);
        System.out.println("Mobile : " + mobile);
        System.out.println("Address : " + address);
        System.out.print("Gmail : ");
    }

    public void addContact(Scanner sc) {

        String name = null, address = null , email = null;
        long mobile = -1;

        Utility.clearConsole();
        System.out.println("=== Add Contact ===\n");
        int i = 1;

        System.out.print("Full Name : ");
//        name = sc.nextLine();

        do {
            name = sc.nextLine();
            if(!isNameValid(name)) {
                if(i > 3) {
                    return;
                }
                display(i++);
            }
        } while(!isNameValid(name));
        i = 1;

        name = name.substring(0,1).toUpperCase() + name.substring(1);

        Contact exists = searchContactUtil(root, name);
        if(exists != null) {
            Utility.clearConsole();
            System.out.println(exists.toString());
        }

        System.out.print("Mobile : ");

        do {
            mobile = sc.nextLong();
            if(String.valueOf(mobile).length() != 10) {
                if(i > 4) {
                    return;
                }
                display(name, i++);
            }
        } while(String.valueOf(mobile).length() != 10);
        i = 1;

        System.out.print("Address : ");
        address = sc.nextLine();

        do {
            address = sc.nextLine();
            if(address.equals("")) {
                if(i > 2) {
                    return;
                }
                display(name, mobile, i++);
            }
        } while(address.equals(""));
        i = 1;

        System.out.print("Gmail : ");

        do {
            email = sc.nextLine();
            if(!isValidGmail(email)) {
                if(i > 3) {
                    return;
                }
                display(name, mobile, address, i++);
            }
        } while(!isValidGmail(email));

        root = addContactUtil(root, new Contact(name, mobile, address, email));

        try {
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.println(".");
            System.out.println("\n=== New Contact Added ===");
            Utility.pressEnterToContinue();
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private Contact addContactUtil(Contact current, Contact newContact) {
        if(current == null) {
            Contact.count++;
            return newContact;
        }
        if(current.compareTo(newContact) > 0) {
            current.left = addContactUtil(current.left, newContact);
        }
        else if(current.compareTo(newContact) < 0) {
            current.right = addContactUtil(current.right, newContact);
        }
        return current;
    }

    public void searchContact(Scanner sc) {
        Utility.clearConsole();
        System.out.println("=== Add Contact ===\n");

        System.out.print("Full Name : ");
//        sc.nextLine();
        String newName = sc.nextLine();
        Contact exists = searchContactUtil(root, newName);
        if(exists != null){
            System.out.println(exists.toString());
            return;
        }
        System.out.println(newName + " doesnot exist");
    }

    private Contact searchContactUtil(Contact current, String newName) {
        if(current == null) {
            return null;
        }
        if(current.compareTo(newName) == 0) {
            return current;
        }
        if(current.compareTo(newName) < 0) {
            return searchContactUtil(current.right, newName);
        }
        else{
            return searchContactUtil(current.left, newName);
        }
    }

    public void listContact() {
        listContactUtil(root);
    }

    private void listContactUtil(Contact current) {
        if(current == null) {
            // System.out.println("null");
            return;
        }
        listContactUtil(current.left);
        System.out.println(current.toString());
        listContactUtil(current.right);
    }

    public Contact contacts() {
        return root;
    }
}
