package AddressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public Contact(String firstName, String lastName, String address, String city, String state, String zip,
                   String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void updateContact(String newAddress, String newCity, String newState, String newZip, String newPhoneNumber,
                              String newEmail) {
        this.address = newAddress;
        this.city = newCity;
        this.state = newState;
        this.zip = newZip;
        this.phoneNumber = newPhoneNumber;
        this.email = newEmail;
    }

    public String getFirstName() {
        return firstName;
    }
}

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("\n...Welcome to Address Book Program...\n");

        List<Contact> addressBook = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Add a new contact");
            System.out.println("2. Update a contact");
            System.out.println("3. Delete a contact");
            System.out.println("4. Display all contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nEnter details for a new contact:");
                    System.out.print("First Name: ");
                    String newFirstName = sc.nextLine();
                    System.out.print("Last Name: ");
                    String newLastName = sc.nextLine();
                    System.out.print("Address: ");
                    String newAddress = sc.nextLine();
                    System.out.print("City: ");
                    String newCity = sc.nextLine();
                    System.out.print("State: ");
                    String newState = sc.nextLine();
                    System.out.print("Zip: ");
                    String newZip = sc.nextLine();
                    System.out.print("Phone Number: ");
                    String newPhoneNumber = sc.nextLine();
                    System.out.print("Email: ");
                    String newEmail = sc.nextLine();

                    Contact newContact = new Contact(newFirstName, newLastName, newAddress, newCity, newState, newZip,
                            newPhoneNumber, newEmail);
                    addressBook.add(newContact);
                    System.out.println("\nNew contact added successfully!");
                    break;

                case 2:
                    System.out.print("\nEnter the first name of the contact to edit: ");
                    String searchFirstName = sc.nextLine();
                    boolean contactFound = false;
                    for (Contact contact : addressBook) {
                        if (contact.getFirstName().equalsIgnoreCase(searchFirstName)) {
                            System.out.println("Enter new details:");
                            System.out.print("Address: ");
                            String updatedAddress = sc.nextLine();
                            System.out.print("City: ");
                            String updatedCity = sc.nextLine();
                            System.out.print("State: ");
                            String updatedState = sc.nextLine();
                            System.out.print("Zip: ");
                            String updatedZip = sc.nextLine();
                            System.out.print("Phone Number: ");
                            String updatedPhoneNumber = sc.nextLine();
                            System.out.print("Email: ");
                            String updatedEmail = sc.nextLine();

                            contact.updateContact(updatedAddress, updatedCity, updatedState, updatedZip,
                                    updatedPhoneNumber, updatedEmail);
                            System.out.println("\nContact updated successfully!");
                            contactFound = true;
                            break;
                        }
                    }
                    if (!contactFound) {
                        System.out.println("\nContact not found.");
                    }
                    break;

                case 3:
                    System.out.print("\nEnter the first name of the contact to delete: ");
                    String deleteFirstName = sc.nextLine();
                    boolean contactDeleted = false;
                    for (int i = 0; i < addressBook.size(); i++) {
                        Contact contact = addressBook.get(i);
                        if (contact.getFirstName().equalsIgnoreCase(deleteFirstName)) {
                            addressBook.remove(i);
                            contactDeleted = true;
                            break;
                        }
                    }
                    if (contactDeleted) {
                        System.out.println("\nContact deleted successfully!");
                    } else {
                        System.out.println("\nContact not found.");
                    }
                    break;

                case 4:
                    System.out.println("\nAddress Book:");
                    for (Contact contact : addressBook) {
                        System.out.println(contact);
                    }
                    break;

                case 5:
                    System.out.println("\nExiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}