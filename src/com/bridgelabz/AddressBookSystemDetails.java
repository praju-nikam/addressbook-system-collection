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

    // This method is used to display the added information
    public void display() {
        System.out.println(personDetails);
    }
}
