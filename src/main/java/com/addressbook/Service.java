package com.addressbook;

//import java.io.IOException;
import java.util.Scanner;

public class Service {
    private static Contact root = null;
    public Service(Contact persons) {
        root = persons;
    }

    private static void printInvalid() {
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
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
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

    private static boolean isNameValid(String name) {
        String nameRegex = "^[a-zA-Z-'\\s]+ [a-zA-Z-'\\s]+$";
        return name.matches(nameRegex);
    }

    private static boolean isValidGmail(String email) {
        String validate = "@gmail.com";
        if(email.length() <= validate.length()) {
            return false;
        }

        if(email.substring(email.length() - validate.length()).equals(validate)) {
            return true;
        }

        return false;
    }

    private static void display(int t) {
        Utility.clearConsole();
        System.out.println("=== Add Contact ===\n");
        System.out.print("Full Name : ");

        printInvalid(t);

        Utility.clearConsole();
        System.out.println("=== Add Contact ===\n");
        System.out.print("Full Name : ");
    }

    private static void display(String name, int t) {
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

    private static void display(String name, long mobile, int t) {
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

    private static void display(String name, long mobile, String address, int t) {
        Utility.clearConsole();
        System.out.println("=== Add Contact ===\n");
        System.out.println("Full Name : " + name);
        System.out.println("Mobile : " + mobile);
        System.out.println("Address : " + address);
        System.out.print("Email : ");

        printInvalid(t);

        Utility.clearConsole();
        System.out.println("=== Add Contact ===\n");
        System.out.println("Full Name : " + name);
        System.out.println("Mobile : " + mobile);
        System.out.println("Address : " + address);
        System.out.print("Gmail : ");
    }

    private static void display(Contact curr) {
        System.out.println("1) Full Name : " + curr.getName());
        System.out.println("2) Mobile : " + curr.getMobile());
        System.out.println("3) Address : " + curr.getAddress());
        System.out.println("4) Email : " + curr.getEmail());
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

        System.out.print("Email : ");

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

    private static int height(Contact curr) {
        if(curr == null) {
            return 0;
        }
        return curr.height;
    }

    private static Contact rightRotate(Contact critNode) {
        Contact x = critNode.left;
        Contact y = x.right;

        x.right = critNode;
        critNode.left = y;

        critNode.height = Math.max(height(critNode.left), height(critNode.right))+1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    } 

    private static Contact leftRotate(Contact critNode) {
        Contact y = critNode.right;
        Contact x = y.left;

        y.left = critNode;
        critNode.right = x;

        critNode.height = Math.max(height(critNode.left), height(critNode.right))+1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    } 

    private static int getBalance(Contact curr) {
        if(curr == null) {
            return 0;
        }
        return height(curr.left) - height(curr.right);
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
        else {
            return current;
        }

        current.height = 1 + Math.max(height(current.left), height(current.right));

        int bf = getBalance(current);

        if(bf > 1 && current.left.compareTo(newContact) > 0) {
            return rightRotate(current);
        }

        if(bf < -1 && current.right.compareTo(newContact) < 0) {
            return leftRotate(current);
        }

        if(bf > 1 && current.left.compareTo(newContact) < 0) {
            current.left = leftRotate(current.left);
            return rightRotate(current);
        }

        if(bf < -1 && current.right.compareTo(newContact) > 0) {
            current.right = rightRotate(current.right);
            return leftRotate(current);
        }

        return current;
    }

    public void searchContact(Scanner sc) {
        Utility.clearConsole();
        System.out.println("=== Search Contact ===\n");

        System.out.print("Full Name : ");
//        sc.nextLine();
        String newName = sc.nextLine();
        Utility.clearConsole();
        System.out.println("=== Searched Contact ===\n");
        searchContactUtilA(root, newName);
//        System.out.println(newName + " does not exist");
    }

    private void searchContactUtilA(Contact current, String search) {
        if(current == null) {
            return;
        }
        searchContactUtilA(current.left, search);
        if(current.compareToUtil(search)) {
            display(current);
            System.out.println("-------------------------------");
        }
        searchContactUtilA(current.right, search);
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
        Utility.clearConsole();
        System.out.println("=== List of Contact ===\n");
        listContactUtil(root);
    }

    private void listContactUtil(Contact current) {
        if(current == null) {
            return;
        }
        listContactUtil(current.left);
        display(current);
        System.out.println("-------------------------------");
        listContactUtil(current.right);
    }

    public Contact contacts() {
        return root;
    }

    public void editContact(Scanner sc) {
        Utility.clearConsole();
        System.out.println("=== Edit Contact ===");
        System.out.print("Full Name: ");
        String name = sc.nextLine();

        Contact ptr = searchContactUtil(root, name);
        if(ptr != null) {
            editContactUtil(sc, ptr);
            return;
        }
        System.out.println(name + " doesnot exist");
        Utility.pressEnterToContinue();
    }

    private void editContactUtil(Scanner sc, Contact curr) {
        Utility.clearConsole();
        System.out.println("=== Edit Contact ===");
        display(curr);
        System.out.print("\nWhat to Edit(eg : 1, 2, 3, 4, 5) : ");
        String choice = sc.nextLine();
        switch(choice) {
            case "1":
                Utility.clearConsole();
                System.out.println("Mobile : " + curr.getMobile());
                System.out.println("Email : " + curr.getEmail());
                System.out.println("Address : " + curr.getAddress());
                System.out.print("Full Name : ");
                String name = sc.nextLine();
                if(!isNameValid(name)) {
                    System.out.println("Name Invalid!!!\nName Unchanged");
                } else {
                    Contact newContact = new Contact(name, curr.getMobile(), curr.getAddress(), curr.getEmail());
                    root = deleteContactUtil(root, curr);
                    addContactUtil(root, newContact);
                    Utility.clearConsole();
                    System.out.println("=== Updated Contact ===");
                    display(curr);
                }
                Utility.pressEnterToContinue();
                break;
            case "2":
                Utility.clearConsole();
                System.out.println("Full Name : " + curr.getName());
                System.out.println("Address : " + curr.getAddress());
                System.out.println("Email : " + curr.getEmail());
                System.out.println("Mobile: ");
                long mobile = sc.nextLong();
                if(String.valueOf(mobile).length() != 10) {
                    System.out.println("Mobile number invalid!!!\nMobile number Unchanged");
                } else {
                    curr.setMobile(mobile);
                    Utility.clearConsole();
                    System.out.println("=== Updated Contact ===");
                    display(curr);
                }
                Utility.pressEnterToContinue();
                break;
            case "3":
                Utility.clearConsole();
                System.out.println("Full Name : " + curr.getName());
                System.out.println("Mobile : " + curr.getMobile());
                System.out.println("Email : " + curr.getEmail());
                System.out.println("Address : ");
                String address = sc.nextLine();
                if(address.equals("")) {
                    System.out.println("Address empty invalid!!!\nAddress Unchanged");
                } else {
                    curr.setAddress(address);
                    Utility.clearConsole();
                    System.out.println("=== Updated Contact ===");
                    display(curr);
                }
                Utility.pressEnterToContinue();
                break;
            case "4":
                Utility.clearConsole();
                System.out.println("Full Name : " + curr.getName());
                System.out.println("Mobile : " + curr.getMobile());
                System.out.println("Address : " + curr.getAddress());
                System.out.println("Email : ");
                String email = sc.nextLine();
                if(!isValidGmail(email)) {
                    System.out.println("Email invalid!!!\nEmail Unchanged");
                } else {
                    curr.setEmail(email);
                    Utility.clearConsole();
                    System.out.println("=== Updated Contact ===");
                    display(curr);
                }
                Utility.pressEnterToContinue();
                break;
            default:
                Utility.clearConsole();
                display(curr);
                System.out.print("\nWhat to Edit(eg : 1, 2, 3, 4, 5) : ");
                printInvalid();
                Utility.pressEnterToContinue();
                Utility.clearConsole();
        }
    }

    public void deleteContact(Scanner sc) {
        Utility.clearConsole();
        System.out.println("=== Delete Contact ===");
        System.out.print("Full Name: ");
        String name = sc.nextLine();

        Contact ptr = searchContactUtil(root, name);
        if(ptr != null) {
            deleteContactUtil(root,ptr);
            Contact.count--;
            return;
        }
        System.out.println(name + " doesnot exist");
        Utility.pressEnterToContinue();
    }

    private static Contact getMinContact(Contact current) {
        Contact ptr = current;

        while(ptr.left != null) {
            ptr = ptr.left;
        }
        return ptr;
    }

    private Contact deleteContactUtil(Contact curr, Contact del) {
        if(curr.compareTo(del) > 0) {
            curr.left = deleteContactUtil(curr.left, del);
        }
        else if(curr.compareTo(del) < 0) {
            curr.right = deleteContactUtil(curr.right, del);
        }
        else {
            if(curr.left == null || curr.right == null) {
                Contact temp = null;
                if(temp == curr.left) {
                    temp = curr.right;
                } else {
                    temp = curr.left;
                }
                if(temp == null) {
                    curr = null;
                } else {
                    curr = temp;
                }
            } else {
                Contact temp = getMinContact(curr.right);

                curr.setData(temp);

                curr.right = deleteContactUtil(curr.right, temp);
            }
        }

        if(curr == null) {
            return curr;
        }

        curr.height = Math.max(height(curr.left), height(curr.right))+1;

        int bf = getBalance(curr);

        if(bf > 1 && getBalance(curr.left) >= 0) {
            return rightRotate(curr);
        }

        if(bf > 1 && getBalance(curr.left) < 0) {
            curr.left = leftRotate(curr.left);
            return rightRotate(curr);
        }

        if(bf < -1 && getBalance(curr.right) <= 0) {
            return leftRotate(curr);
        }

        if(bf < -1 && getBalance(curr.right) > 0) {
            curr.right = rightRotate(curr.right);
            return leftRotate(curr);
        }

        return curr;
    }
}
