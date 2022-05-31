package com.bridgelabz;

import java.util.Scanner;

public class AddressBookSystemMain {
    public static void main(String[] args) {
        System.out.println("*-*-*-*-*-*-*-*-*-*-*- Wel to AddressBook System -*-*-*-*-*-*-*-*-*-*-*-*-*");

        Scanner scanner = new Scanner(System.in);

        AddressBookSystemDetails details = new AddressBookSystemDetails();
        details.createAddressBook();
        int choice = 1;
        while (choice == 1){
            System.out.println("Choose One of the Given Choices as per Requirement: ");
            System.out.println("1.Add Details\n 2.Edit Details\n 3.Delete Details\n 4.Display Details\n 0.Exit");

            switch (scanner.nextInt()){
                case 1:
                    details.addDetails();
                    break;
                case  2:
                    details.editDetails();
                    break;
                case 3:
                    details.deleteDetails();
                    break;
                case 4:
                    details.displayDetails();
                    break;
                default:
                    choice = 0;
            }

        }
    }

}
