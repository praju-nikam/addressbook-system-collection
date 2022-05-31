package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookSystemDetails
{
    ArrayList<Contact> personDetails = new ArrayList<>();
    Contact contacts = new Contact();
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
    public void display() {
        System.out.println(personDetails);
    }
}
