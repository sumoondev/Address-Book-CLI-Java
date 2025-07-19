package com.addressbook;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
//     private List<Contact> contacts;
//     private static final String RESOURCE_FILE_PATH = "/data/addressbook.json";
//     private static final String EXTERNAL_FILE_PATH = "addressbook.json";
//     private Gson gson;

//     public Service() {
//         contacts = new ArrayList<>();
//         gson = new Gson();
//     }

//     public void loadContacts() {
//         File externalFile = new File(EXTERNAL_FILE_PATH);
//         if(externalFile.exists()) {
//             try (Reader reader = new FileReader(externalFile)) {
//                 Type contactListType = new TypeToken<List<Contact>>() {}.getType();
//                 contacts = gson.fromJson(reader, contactListType);
//                 if (contacts == null) {
//                     contacts = new ArrayList<>();
//                 }
//                 System.out.println("Contacts loaded from external file.");
//                 return; // Loaded from external, so no need to load from resource
//             } catch (IOException e) {
//                 System.out.println("Could not load contacts: " + e.getMessage());
//             }
//         }

//         // If no external file, or external file failed, try loading from the bundled resource
//         try (InputStream inputStream = getClass().getResourceAsStream(RESOURCE_FILE_PATH);
//              Reader reader = new InputStreamReader(inputStream)) { // Use InputStreamReader for character stream

//             if (inputStream == null) {
//                 System.out.println("Resource not found: " + RESOURCE_FILE_PATH + ". Starting with empty contacts.");
//                 contacts = new ArrayList<>(); // Initialize empty if resource not found
//                 return;
//             }

//             Type contactListType = new TypeToken<List<Contact>>() {}.getType();
//             contacts = gson.fromJson(reader, contactListType);
//             if (contacts == null) {
//                 contacts = new ArrayList<>();
//             }
//             System.out.println("Contacts loaded from bundled resource.");

//         } catch (Exception e) { // Catch Exception to cover NullPointerException from getResourceAsStream if resource is null
//             System.out.println("Could not load contacts from bundled resource: " + e.getMessage());
//             contacts = new ArrayList<>(); // Ensure contacts is initialized even on error
//         }
//     }

//     public void saveContacts() {
// //        try (Writer writer = new FileWriter(FILE_PATH)) {
// //            gson.toJson(contacts, writer);
// //        } catch (IOException e) {
// //            System.out.println("Could not save contacts: " + e.getMessage());
// //        }

//         // When saving, you generally want to save to a location that can be written to
//         // This usually means the current working directory, or a specified data directory.
//         // It's not advisable to try to write back into the bundled JAR resource.
//         File externalFile = new File(EXTERNAL_FILE_PATH);
//         try (Writer writer = new FileWriter(externalFile)) {
//             gson.toJson(contacts, writer);
//             System.out.println("Contacts saved to " + externalFile.getAbsolutePath());
//         } catch (IOException e) {
//             System.out.println("Could not save contacts to external file: " + e.getMessage());
//         }
//     }

//     public void addContact(Scanner scanner) {
//         System.out.print("Enter name: ");
//         String name = scanner.nextLine();
//         System.out.print("Enter mobile: ");
//         String mobile = scanner.nextLine();
//         System.out.print("Enter address: ");
//         String address = scanner.nextLine();
//         System.out.print("Enter email: ");
//         String email = scanner.nextLine();

//         contacts.add(new Contact(name, mobile, address, email));
//         System.out.println("Contact added successfully.");
//     }

//     public void viewContacts() {
//         if (contacts.isEmpty()) {
//             System.out.println("No contacts available.");
//             return;
//         }
//         for (Contact contact : contacts) {
//             System.out.println(contact);
//         }
//     }

//     public void updateContact(Scanner scanner) {
//         System.out.print("Enter the name of the contact to update: ");
//         String name = scanner.nextLine();
//         for (Contact contact : contacts) {
//             if (contact.getName().equalsIgnoreCase(name)) {
//                 System.out.print("Enter new mobile: ");
//                 contact.setMobile(scanner.nextLine());
//                 System.out.print("Enter new address: ");
//                 contact.setAddress(scanner.nextLine());
//                 System.out.print("Enter new email: ");
//                 contact.setEmail(scanner.nextLine());
//                 System.out.println("Contact updated successfully.");
//                 return;
//             }
//         }
//         System.out.println("Contact not found.");
//     }

//     public void deleteContact(Scanner scanner) {
//         System.out.print("Enter the name of the contact to delete: ");
//         String name = scanner.nextLine();
//         contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
//         System.out.println("Contact deleted successfully.");
//     }

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

    public void addContact(Scanner sc, Contact persons[]) {

        String name = null, address = null , email = null;
        long mobile = -1;

        Utility.clearConsole();
        System.out.println("=== Add Contact ===\n");
        int i = 1;

        System.out.print("Full Name : ");
        name = sc.nextLine();

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

        int var = name.charAt(0) - 'a';

        Contact newContact = new Contact(name, mobile, address, email);

        System.out.println("\n=== New Contact Added ===");

    }
}
