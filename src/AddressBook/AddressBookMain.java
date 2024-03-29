package AddressBook;

import java.util.*;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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
}


public class AddressBookMain {
    private static Map<String, List<Contact>> addressBooks = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("\n...Welcome to Address Book Program...\n");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Create a new address book");
            System.out.println("2. Add a new contact to an address book");
            System.out.println("3. Update a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Display all contacts in an address book");
            System.out.println("6. Sort contacts by City");
            System.out.println("7. Sort contacts by State");
            System.out.println("8. Sort contacts by Zip");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    createAddressBook(sc);
                    break;

                case 2:
                    addContact(sc);
                    break;

                case 3:
                    updateContact(sc);
                    break;

                case 4:
                    deleteContact(sc);
                    break;

                case 5:
                    displayContacts(sc);
                    break;

                case 6:
                    sortContactsByCity(sc);
                    break;

                case 7:
                    sortContactsByState(sc);
                    break;

                case 8:
                    sortContactsByZip(sc);
                    break;

                case 9:
                    System.out.println("\nExiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void createAddressBook(Scanner sc) {
        System.out.print("\nEnter the name for the new address book: ");
        String addressBookName = sc.nextLine();
        addressBooks.put(addressBookName, new ArrayList<>());
        System.out.println("\nNew address book created successfully!");
    }

    private static void addContact(Scanner sc) {
        System.out.print("\nEnter the name of the address book to add the contact to: ");
        String selectedAddressBook = sc.nextLine();
        List<Contact> selectedBook = addressBooks.get(selectedAddressBook);
        if (selectedBook == null) {
            System.out.println("\nAddress book not found.");
            return;
        }

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
        selectedBook.add(newContact);
        System.out.println("\nNew contact added successfully!");
    }

    private static void updateContact(Scanner sc) {
        System.out.print("\nEnter the name of the address book to update a contact: ");
        String updateAddressBookName = sc.nextLine();
        List<Contact> updateAddressBook = addressBooks.get(updateAddressBookName);
        if (updateAddressBook == null) {
            System.out.println("\nAddress book not found.");
        } else {
            System.out.print("\nEnter the first name of the contact to update: ");
            String updateFirstName = sc.nextLine();
            boolean contactFound = false;
            for (Contact contact : updateAddressBook) {
                if (contact.getFirstName().equalsIgnoreCase(updateFirstName)) {
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
                    contact.setAddress(updatedAddress);
                    contact.setCity(updatedCity);
                    contact.setState(updatedState);
                    contact.setZip(updatedZip);
                    contact.setPhoneNumber(updatedPhoneNumber);
                    contact.setEmail(updatedEmail);
                    System.out.println("\nContact updated successfully!");
                    contactFound = true;
                    break;
                }
            }
            if (!contactFound) {
                System.out.println("\nContact not found.");
            }
        }
    }

    private static void deleteContact(Scanner sc) {
        System.out.print("\nEnter the name of the address book to delete a contact: ");
        String deleteAddressBookName = sc.nextLine();
        List<Contact> deleteAddressBook = addressBooks.get(deleteAddressBookName);
        if (deleteAddressBook == null) {
            System.out.println("\nAddress book not found.");
        } else {
            System.out.print("\nEnter the first name of the contact to delete: ");
            String deleteFirstName = sc.nextLine();
            boolean contactDeleted = false;
            for (int i = 0; i < deleteAddressBook.size(); i++) {
                Contact contact = deleteAddressBook.get(i);
                if (contact.getFirstName().equalsIgnoreCase(deleteFirstName)) {
                    deleteAddressBook.remove(i);
                    contactDeleted = true;
                    break;
                }
            }
            if (contactDeleted) {
                System.out.println("\nContact deleted successfully!");
            } else {
                System.out.println("\nContact not found.");
            }
        }
    }

    private static void displayContacts(Scanner sc) {
        System.out.print("\nEnter the name of the address book to display contacts: ");
        String displayAddressBookName = sc.nextLine();
        List<Contact> displayAddressBook = addressBooks.get(displayAddressBookName);
        if (displayAddressBook == null) {
            System.out.println("\nAddress book not found.");
        } else {
            System.out.println("\nContacts in Address Book '" + displayAddressBookName + "':");
            for (Contact contact : displayAddressBook) {
                System.out.println(contact);
            }
        }
    }

    private static void sortContactsByCity(Scanner sc) {
        System.out.print("\nEnter the name of the address book to sort contacts by City: ");
        String addressBookName = sc.nextLine();
        List<Contact> addressBook = addressBooks.get(addressBookName);
        if (addressBook == null) {
            System.out.println("\nAddress book not found.");
        } else {
            System.out.println("\nContacts in Address Book '" + addressBookName + "' sorted by City:");
            addressBook.stream()
                    .sorted(Comparator.comparing(Contact::getCity))
                    .forEach(System.out::println);
        }
    }

    private static void sortContactsByState(Scanner sc) {
        System.out.print("\nEnter the name of the address book to sort contacts by State: ");
        String addressBookName = sc.nextLine();
        List<Contact> addressBook = addressBooks.get(addressBookName);
        if (addressBook == null) {
            System.out.println("\nAddress book not found.");
        } else {
            System.out.println("\nContacts in Address Book '" + addressBookName + "' sorted by State:");
            addressBook.stream()
                    .sorted(Comparator.comparing(Contact::getState))
                    .forEach(System.out::println);
        }
    }

    private static void sortContactsByZip(Scanner sc) {
        System.out.print("\nEnter the name of the address book to sort contacts by Zip: ");
        String addressBookName = sc.nextLine();
        List<Contact> addressBook = addressBooks.get(addressBookName);
        if (addressBook == null) {
            System.out.println("\nAddress book not found.");
        } else {
            System.out.println("\nContacts in Address Book '" + addressBookName + "' sorted by Zip:");
            addressBook.stream()
                    .sorted(Comparator.comparing(Contact::getZip))
                    .forEach(System.out::println);
        }
    }
}
