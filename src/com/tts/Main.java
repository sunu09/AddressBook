package com.tts;
import java.util.*;
import java.io.*;

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
                System.out.print("First Name: ");
                String firstName = input.next();
                System.out.print("Last Name: ");
                String lastName = input.next();
                System.out.print("Phone Number: ");
                String phoneNumber = input.next();
                System.out.print("Email Address: ");
                String emailAddress = input.next();
                System.out.print("Added the following new entry:");
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
                System.out.println("What do you like to search?");
                System.out.println("1) First Name\n2) Last Name\n3) Phone Number\n4) Email Address");
                System.out.print("Chose a search type: ");
                String selection = input.next();
                System.out.println("Enter your search: ");
                String selectSearch = input.next();
                Entry entry = AddressBook.searchEntry(selection, selectSearch);
                System.out.println(entry);
                break;

         case 4:
                System.out.println("Print Address Book");
                System.out.println(AddressBook.getEntryList());
                break;

            case 5:
                System.out.println("deleting entry");
                AddressBook.deleteEntryList();
                System.out.println("Address book cleared!\n");
                break;

            case 6:
                System.out.println("Quit");
                System.exit(0);
                break;

            default:
                main(args);
        }
        main(args);

        }
    }

