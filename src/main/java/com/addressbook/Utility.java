package com.addressbook;

import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.*;

public class Utility {
    private static final String EXTERNAL_FILE_PATH = "addressbook.json";
    private Gson gson = new Gson();

    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static void pressEnterToContinue() {
        System.out.println("Press Enter to continue...");
        try {
            System.in.read(); // Reads a single byte, which will be the newline character after Enter
            // Optionally, clear the rest of the line if using a Scanner later
            // if (System.in.available() > 0) {
            //     System.in.skip(System.in.available());
            // }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Contact loadContacts() {
        try (FileReader reader = new FileReader(EXTERNAL_FILE_PATH)){
            Container loadC = gson.fromJson(reader, Container.class);
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.println(".");
            if(loadC == null) {
                System.out.println("No Contacts to load");
                Thread.sleep(1000);
                return null;
            }
            else {
                Contact.count = loadC.count;
                System.out.println(loadC.count + " contacts loaded");
                Thread.sleep(1000);
                return loadC.persons;
            }

        } catch (IOException e){
            System.out.println("File not found : " + EXTERNAL_FILE_PATH);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return null;
    }

    public void saveContacts(Contact persons) {
        Container data = new Container(persons, Contact.count);
        if (persons == null) {
            System.out.println("No contacts to save (array is null).");
            return;
        }
        try (Writer writer = new FileWriter(EXTERNAL_FILE_PATH)) {
            gson.toJson(data, writer);
            System.out.println("Contacts saved to " + EXTERNAL_FILE_PATH);
        } catch (IOException e) {
            System.err.println("Could not save contacts");
        }
    }
}

class Container {
    public Contact persons;
    public int count;

    public Container(Contact root, int count) {
        persons = root;
        this.count = count;
    }
}
