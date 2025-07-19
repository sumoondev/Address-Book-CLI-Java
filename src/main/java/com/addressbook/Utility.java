package com.addressbook;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;

public class Utility {
    private static final String EXTERNAL_FILE_PATH = "addressbook.json";
    private Gson gson = new Gson();

    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

//    public void loadContacts(Contact[] persons) {
//
//    }

    public void saveContacts(Contact[] persons) {
        if (persons == null) {
            System.out.println("No contacts to save (array is null).");
            return;
        }
        try (Writer writer = new FileWriter(EXTERNAL_FILE_PATH)) {
            gson.toJson(persons, writer);
            System.out.println("Contacts saved to " + EXTERNAL_FILE_PATH);
        } catch (IOException e) {
            System.err.println("Could not save contacts");
        }
    }
}
