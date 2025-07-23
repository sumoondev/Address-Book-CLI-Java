import java.util.*;
public class test {
    public static void main(String[] args) {
        // Contact persons[] = new Contact[26];
        // for(int i = 0; i < 26; i++) {
        //     persons[i] = null;
        // }
//         long number1 = 98;
//         long number2 = 99;
//         String name = "Ale";
//         Contact person = new Contact("Suh", number1, "place1", "suh@gmail.com");
//         Contact person2 = new Contact("Sum", number2, "place2", "sum@gmail.com");
        // // Contact nameCheck = new Contact(name, 0,null,null);
        // System.out.println("Suh < Sum  " + person.compareTo(person2));
        // System.out.println("Sum > Suh   " + person2.compareTo(person));
        // System.out.println("Suh > Ale  " + person.compareTo(name));
        // System.out.println(person.toString());
        // person = person2;
        // System.out.println(person.toString());
        // Service serv = new Service(person);
        // serv.listContact();

        String name1 = new String("Suhan");
        String name2 = new String("Sumoon");
        String test = new String("Su");

        System.out.println(name1.equals(name2));
        System.out.println(name1.substring(0,test.length()).equals(test));
        System.out.println(name2.equals(test));



//        Contact persons = null;
//        // Utility util = new Utility();
//        // Contact persons = util.loadContact();
//        Service serv = new Service(persons);
//
//        Scanner sc = new Scanner(System.in);
//        boolean loop = true;
//        while(loop) {
//            Utility.clearConsole();
//            System.out.println("=== Address Book CLI ===\n");
//            System.out.println("1) Add Contact\n2) List All Contacts\n3) Search Contacts\n4) Edit Contact\n5) Delete Contact\n0) Exit");
//            System.out.print("Enter Choice: ");
//            int choice = sc.nextInt();
//            switch(choice) {
//                case 1:
//                    serv.addContact(sc);
//                    break;
//                case 2:
//                     serv.listContact();
//                     sc.nextInt();
//                    break;
//                case 3:
//                    serv.searchContact(sc);
//                    sc.nextInt();
//                    break;
//                case 4:
//
//                    break;
//                case 5:
//
//                    break;
//                case 0:
//                    loop = false;
//                    break;
//                default:
//                    System.out.println("Invalid command. Please try again");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        Thread.currentThread().interrupt();
//                    }
//            }
//        }
//
//        try {
//            // util.saveContacts(persons);
//            Thread.sleep(500);
//            System.out.print(".");
//            Thread.sleep(500);
//            System.out.print(".");
//            Thread.sleep(500);
//            System.out.println(".");
//            System.out.println("Contact saved");
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//        sc.close();
    }
}
class Contact implements Comparable<Contact>{
    @Override
    public int compareTo(Contact c2) {
        return this.name.compareToIgnoreCase(c2.name);
    }

    public int compareTo(String cname) {
        return this.name.compareToIgnoreCase(cname);
    }
    private String name;
    private long mobile;
    private String address;
    private String email;
    public Contact left;
    public Contact right;
    public Contact(String name, long mobile, String address, String email) {
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.email = email;
        this.left = null;
        this.right = null;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setMobile(Long mb) {
        this.mobile = mb;
    }
    public Long getMobile() {
        return this.mobile;
    }
    public void setAddress(String add) {
        this.address = add;
    }
    public String getAddress() {
        return this.address;
    }
    public void setEmail(String em) {
        this.email = em;
    }
    public String getEmail() {
        return this.email;
    }
    @Override
	public String toString() {
        return "Person [name=" + name + ", address=" + address + ", mobile=" + mobile + ", email=" + email + "]";
    }
}
//
//class Service {
//    private static Contact root = null;
//    public Service(Contact persons) {
//        root = persons;
//    }
//
//    private static void printInvalid(int t) {
//        try {
//            Thread.sleep(100);
//            System.out.print("I");
//            Thread.sleep(100);
//            System.out.print("n");
//            Thread.sleep(100);
//            System.out.print("v");
//            Thread.sleep(100);
//            System.out.print("a");
//            Thread.sleep(100);
//            System.out.print("l");
//            Thread.sleep(100);
//            System.out.print("i");
//            Thread.sleep(100);
//            System.out.print("d ");
//            Thread.sleep(100);
//            System.out.print("!");
//            Thread.sleep(100);
//            System.out.print("!");
//
//            System.out.print("      Try " + t + " / 3");
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//    }
//
//    public static boolean isNameValid(String name) {
//        String nameRegex = "^[a-zA-Z-'\\s]+ [a-zA-Z-'\\s]+$";
//        return name.matches(nameRegex);
//    }
//
//    public static boolean isValidGmail(String email) {
//        String validate = "@gmail.com";
//        if(email.length() <= validate.length()) {
//            return false;
//        }
//
//        if(email.substring(email.length() - validate.length()).equals(validate)) {
//            return true;
//        }
//
//        return false;
//    }
//
//    public static void display(int t) {
//        Utility.clearConsole();
//        System.out.println("=== Add Contact ===\n");
//        System.out.print("Full Name : ");
//
//        printInvalid(t);
//
//        Utility.clearConsole();
//        System.out.println("=== Add Contact ===\n");
//        System.out.print("Full Name : ");
//    }
//
//    public static void display(String name, int t) {
//        Utility.clearConsole();
//        System.out.println("=== Add Contact ===\n");
//        System.out.println("Full Name : " + name);
//        System.out.print("Mobile : ");
//
//        printInvalid(t);
//
//        Utility.clearConsole();
//        System.out.println("=== Add Contact ===\n");
//        System.out.println("Full Name : " + name);
//        System.out.print("Mobile : ");
//    }
//
//    public static void display(String name, long mobile, int t) {
//        Utility.clearConsole();
//        System.out.println("=== Add Contact ===\n");
//        System.out.println("Full Name : " + name);
//        System.out.println("Mobile : " + mobile);
//        System.out.print("Address : ");
//
//        printInvalid(t);
//
//        Utility.clearConsole();
//        System.out.println("=== Add Contact ===\n");
//        System.out.println("Full Name : " + name);
//        System.out.println("Mobile : " + mobile);
//        System.out.print("Address : ");
//    }
//
//    public static void display(String name, long mobile, String address, int t) {
//        Utility.clearConsole();
//        System.out.println("=== Add Contact ===\n");
//        System.out.println("Full Name : " + name);
//        System.out.println("Mobile : " + mobile);
//        System.out.println("Address : " + address);
//        System.out.print("Gmail : ");
//
//        printInvalid(t);
//
//        Utility.clearConsole();
//        System.out.println("=== Add Contact ===\n");
//        System.out.println("Full Name : " + name);
//        System.out.println("Mobile : " + mobile);
//        System.out.println("Address : " + address);
//        System.out.print("Gmail : ");
//    }
//
//    public void addContact(Scanner sc) {
//
//        String name = null, address = null , email = null;
//        long mobile = -1;
//
//        Utility.clearConsole();
//        System.out.println("=== Add Contact ===\n");
//        int i = 1;
//
//        System.out.print("Full Name : ");
//        name = sc.nextLine();
//
//        do {
//            name = sc.nextLine();
//            if(!isNameValid(name)) {
//                if(i > 3) {
//                    return;
//                }
//                display(i++);
//            }
//        } while(!isNameValid(name));
//        i = 1;
//
//        name = name.substring(0,1).toUpperCase() + name.substring(1);
//
//        Contact exists = searchContactUtil(root, name);
//        if(exists != null) {
//            Utility.clearConsole();
//            System.out.println(exists.toString());
//        }
//
//        System.out.print("Mobile : ");
//
//        do {
//            mobile = sc.nextLong();
//            if(String.valueOf(mobile).length() != 10) {
//                if(i > 4) {
//                    return;
//                }
//                display(name, i++);
//            }
//        } while(String.valueOf(mobile).length() != 10);
//        i = 1;
//
//        System.out.print("Address : ");
//        address = sc.nextLine();
//
//        do {
//            address = sc.nextLine();
//            if(address.equals("")) {
//                if(i > 2) {
//                    return;
//                }
//                display(name, mobile, i++);
//            }
//        } while(address.equals(""));
//        i = 1;
//
//        System.out.print("Gmail : ");
//
//        do {
//            email = sc.nextLine();
//            if(!isValidGmail(email)) {
//                if(i > 3) {
//                    return;
//                }
//                display(name, mobile, address, i++);
//            }
//        } while(!isValidGmail(email));
//
//        root = addContactUtil(root, new Contact(name, mobile, address, email));
//
//        System.out.println("\n=== New Contact Added ===");
//        sc.nextInt();
//    }
//
//    private Contact addContactUtil(Contact current, Contact newContact) {
//        if(current == null) {
//            return newContact;
//        }
//        if(current.compareTo(newContact) > 0) {
//            current.left = addContactUtil(current.left, newContact);
//        }
//        else if(current.compareTo(newContact) < 0) {
//            current.right = addContactUtil(current.right, newContact);
//        }
//        return current;
//    }
//
//    public void searchContact(Scanner sc) {
//        Utility.clearConsole();
//        System.out.println("=== Add Contact ===\n");
//
//        System.out.print("Full Name : ");
//        sc.nextLine();
//        String newName = sc.nextLine();
//        Contact exists = searchContactUtil(root, newName);
//        if(exists != null){
//            System.out.println(exists.toString());
//            return;
//        }
//        System.out.println(newName + " doesnot exist");
//    }
//
//    private Contact searchContactUtil(Contact current, String newName) {
//        if(current == null || current.compareTo(newName) == 0) {
//            return current;
//        }
//        if(current.compareTo(newName) < 0) {
//            searchContactUtil(current.right, newName);
//        }
//        else if(current.compareTo(newName) > 0) {
//            searchContactUtil(current.left, newName);
//        }
//        return null;
//    }
//
//    public void listContact() {
//        listContactUtil(root);
//    }
//
//    private void listContactUtil(Contact current) {
//        if(current == null) {
//            // System.out.println("null");
//            return;
//        }
//        listContactUtil(current.left);
//        System.out.println(current.toString());
//        listContactUtil(current.right);
//    }
//}
//
//class Utility {
//    // private static final String EXTERNAL_FILE_PATH = "addressbook.json";
//    // private Gson gson = new Gson();
//
//    public static void clearConsole() {
//        for (int i = 0; i < 100; i++) {
//            System.out.println();
//        }
//    }
//
////    public void loadContacts(Contact[] persons) {
////
////    }
//
//    // public void saveContacts(Contact persons) {
//    //     if (persons == null) {
//    //         System.out.println("No contacts to save (array is null).");
//    //         return;
//    //     }
//    //     try (Writer writer = new FileWriter(EXTERNAL_FILE_PATH)) {
//    //         gson.toJson(persons, writer);
//    //         System.out.println("Contacts saved to " + EXTERNAL_FILE_PATH);
//    //     } catch (IOException e) {
//    //         System.err.println("Could not save contacts");
//    //     }
//    // }
//}