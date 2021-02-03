package com.tts;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("What action do you want to perform?");
        System.out.println("1. Add an entry \n2. Remove an entry \n3. Search for a specific entry \n4. Print Address Book \n5. Delete Book \n6. Quit");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Please provide the following information to add an entry");
                System.out.println("First Name");
                String firstName = input.next();
                System.out.println("Last Name");
                String lastName = input.next();
                System.out.println("Phone Number");
                String phoneNumber = input.next();
                System.out.println("Email Address");
                String emailAddress = input.next();
                System.out.println("Added the following new entry:");
                AddressBook.addEntry(new Entry(firstName, lastName, phoneNumber, emailAddress));
                break;

            case 2:

                System.out.println("Enter the email address of person you wish to remove");

                String emailAdd = input.next();
                System.out.println("Deleted the following entry:");
                //AddressBook.removeEntry(new Entry(fName, lName, phoneNum, emailAdd));
                AddressBook.removeEntry(emailAdd);
                break;

            case 3:
                System.out.println("Let's search by email address");
                String email = input.next();
                Optional<Entry> found = AddressBook.searchEntry(email);
                //             AddressBook.searchEntry(new Entry(fName, lName, phoneNum, emailAdd));
                System.out.println(found);
                break;

         case 4:
                System.out.println("Print Address Book");
                System.out.print(AddressBook.getEntryList());

                break;

            case 5:
//                System.out.println("Are you sure you want to delete an entry?");
//                System.out.println("Y/N: ");
//                String decision = input.next();
//
//                if (decision=="y" || decision =="Y"){
//                AddressBook.deleteEntryList();
//                }
                AddressBook.deleteEntryList();
                break;

            case 6:
                System.out.println("Quit");
                System.exit(0);
//                input.close();
                break;

            default:
                main(args);
        }
        main(args);

        }
    }

