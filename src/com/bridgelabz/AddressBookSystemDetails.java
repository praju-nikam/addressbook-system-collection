package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookSystemDetails
{
    static AddressBookSystemDetails details = new AddressBookSystemDetails();
    ArrayList<Contact> personDetails = new ArrayList<>();
    Contact contacts = new Contact();
    static HashMap<String, ArrayList<Contact>> hashmap = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    //This method is used to add details to address book
    public void addDetails() {

        System.out.println("Enter the first name");
        String firstName = scanner.next();
        System.out.println("Enter the last name");
        String lastName = scanner.next();
        System.out.println("Enter the address");
        String address = scanner.next();
        System.out.println("Enter the city");
        String city = scanner.next();
        System.out.println("Enter the state");
        String state = scanner.next();
        System.out.println("Enter the email");
        String emailId = scanner.next();
        System.out.println("Enter the zip code");
        int zip = scanner.nextInt();
        System.out.println("Enter the phone number");
        long phoneNumber = scanner.nextLong();

        contacts = new Contact(firstName, lastName, address, city, state, emailId, zip, phoneNumber);
        personDetails.add(contacts);
        scanner.close();
    }


    // This method is used to edit the details in address book
    public void editDetails() {
        System.out.println("Confirm your first name to edit details: ");
        String confirmName = scanner.next();

        for (int i = 0; i < personDetails.size(); i++) {
            if (personDetails.get(i).getFirstName().equals(confirmName)) {
                System.out.println("Select mentioned detail to edit: ");
                System.out.println("\n1.First Name\n2.Last Name\n3.Address\n4.city\n5.State\n6.Zip \n7.Mobile number" +
                        "\n8.Email");
                int edit = scanner.nextInt();

                switch (edit) {
                    case 1:
                        System.out.println("Enter first name: ");
                        personDetails.get(i).setFirstName(scanner.next());
                        break;
                    case 2:
                        System.out.println("Enter Last name: ");
                        personDetails.get(i).setLastName(scanner.next());
                        break;
                    case 3:
                        System.out.println("Enter Address: ");
                        personDetails.get(i).setAddress(scanner.next());
                        break;
                    case 4:
                        System.out.println("Enter City: ");
                        personDetails.get(i).setCity(scanner.next());
                        break;
                    case 5:
                        System.out.println("Enter State: ");
                        personDetails.get(i).setState(scanner.next());
                        break;
                    case 6:
                        System.out.println("Enter Zip: ");
                        personDetails.get(i).setZip(scanner.nextInt());
                        break;
                    case 7:
                        System.out.println("Enter Mobile number: ");
                        personDetails.get(i).setPhoneNumber(scanner.nextLong());
                        break;
                    case 8:
                        System.out.println("Enter new E-mail: ");
                        personDetails.get(i).setEmailId(scanner.next());
                        break;
                }
                System.out.println("Edited list is: ");
                System.out.println(personDetails);
            } else
                System.out.println("Enter a valid First name");
        }
    }

    // This method is used to delete the contact details
    public void deleteDetails() {
        System.out.println("Confirm first name to delete contact details");
        String confirmName = scanner.next();
        for (int i = 0; i < personDetails.size(); i++) {

            if (personDetails.get(i).getFirstName().equals(confirmName)) {
                personDetails.remove(i);
            } else {
                System.out.println("Enter valid first name");
            }
        }
    }

    // This method is used to display the added information
    public void displayDetails() {
        System.out.println(personDetails);
    }

    //Method to check for duplicate entry before adding the person.

    public void duplicateCheck(String firstName) {
        for (int j = 0; j < personDetails.size(); j++) {
            String contactName = personDetails.get(j).getFirstName();

            if (firstName.equals(contactName)) {
                System.out.println("This Person is Already Present");
            } else {
                System.out.println("You can Add this Person");
                break;
            }
        }
    }

    public void createAddressBook() {
        int option = 1;
        while (option == 1) {
            System.out.println("Choose an Option According To Your Preference: ");
            System.out.println("1.Create new address book.\n2.Edit existing address book.\n3.Display all address books.\n4.exit");

            switch (scanner.nextInt()) {
                //Switch Case For Creating New Address Book
                case 1:
                    System.out.println("Enter the name of address book: ");
                    String address_name = scanner.next();

                    // condition to check for uniqueness of address book.
                    if (hashmap.containsKey(address_name)) {
                        System.out.println("Address book name exits, enter different name");
                        break;
                    }

                    ArrayList<Contact> newAddressBook = new ArrayList<>();
                    personDetails = newAddressBook;
                    int choice = 1;
                    while (choice == 1) {
                        System.out.println("Choose an Option According To Your Preference: ");
                        System.out.println("1.Add details.\n2.Edit details.\n3.Delete contact. \n4.Display Contact\n5.Exit");

                        switch (scanner.nextInt()) {
                            case 1:
                                details.addDetails();
                                break;
                            case 2:
                                details.editDetails();
                                break;
                            case 3:
                                details.deleteDetails();
                                break;
                            case 4:
                                details.displayDetails();
                                break;
                            default:
                                System.out.println("Exited From Address Book");
                                break;
                        }
                        hashmap.put(address_name, personDetails);
                        System.out.println(hashmap);
                        choice = 0;
                    }
                    break;

                //Switch Case For Editing Existing Address Book
                case 2:
                    System.out.println("Enter the name of address book: ");
                    String oldAddressBook = scanner.next();

                    // condition to check whether address book exists or no.
                    if (hashmap.containsKey(oldAddressBook)) {

                        ArrayList<Contact> old_address_book = new ArrayList<>();
                        personDetails = old_address_book;
                        personDetails = hashmap.get(oldAddressBook);
                        int choice1 = 1;
                        while (choice1 == 1) {
                            System.out.println("Choose an Option According To Your Preference: ");
                            System.out.println("1.Add details.\n2.Edit details.\n3.Delete contact. \n4.Display contact.\n5.Exit");
                            switch (scanner.nextInt()) {
                                case 1:
                                    details.addDetails();
                                    break;
                                case 2:
                                    details.editDetails();
                                    break;
                                case 3:
                                    details.deleteDetails();
                                    break;
                                case 4:
                                    details.displayDetails();
                                    break;
                                default:
                                    System.out.println("Exited From Address Book");
                                    break;
                            }
                            hashmap.put(oldAddressBook, personDetails);
                            System.out.println(hashmap);
                            choice1 = 0;
                        }
                    } else {
                        System.out.println("Enter valid address book name");
                    }
                    break;

                //Switch Case For Displaying All Address Book
                case 3:
                    System.out.println(hashmap);
                    break;

                default:
                    System.out.println("Exited From Address Book Management System");
                    option = 0;
            }
        }
    }
}
