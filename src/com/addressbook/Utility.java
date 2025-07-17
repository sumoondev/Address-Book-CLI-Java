package com.addressbook;

import java.io.File;
import java.io.IOException;

// import com.google.gson.Gson;

public class Utility {
    private String path = "address-book-cli/data/addressbook.json";
    public boolean readJson(Contact persons[]) {
        try {
            File file = new File(path);
            if(file.exists()) {
                if(file.length() != 0) {
                    // ObjectMapper objectmapper = new ObjectMapper();

                    System.out.println("Contact(s) found !!");
                    Thread.sleep(1000);
                    return true;
                }
                System.out.println("Contact found 0");
                for(int i = 0; i < persons.length; i++) {
                    persons[i] = null;
                }
                Thread.sleep(1000);
                return true;
            }
            System.out.println("No file found to read!!");
            file.createNewFile();
            Thread.sleep(1000);
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.!!!");
            e.printStackTrace();
        } catch (InterruptedException f) {
            Thread.currentThread().interrupt();
        }
        
        return false;
    }
}
