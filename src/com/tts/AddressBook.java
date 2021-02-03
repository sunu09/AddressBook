package com.tts;

import java.io.*;
import java.util.*;

import static com.tts.Main.main;


public class AddressBook {

    //field: an ArrayList of generic type Entries

    static List<Entry> entryList = new ArrayList<>();

    //methods: ways to manipulate the array list

    //add method

    public static void addEntry(Entry entry) {
        // for loop, essentially
        // this returns true if my email is not unique
        boolean isNotUnique = entryList.stream()
                .anyMatch(e -> e.getEmailAddress().equals(entry.getEmailAddress()));

        if (isNotUnique) {
            System.out.print("Please add an entry with a unique email!\n");
        } else {
            entryList.add(entry);
            System.out.println(entry);
            System.out.print("Entry added! Sending you to main screen...\n");
        }

    }
    //remove method
    public static void removeEntry(String email) {
        System.out.println(findEntry(email));
        entryList.removeIf(entry -> entry.getEmailAddress().equals(email));
    }
    // find method for remove method
         public static Entry  findEntry(String email) {
            return entryList.stream()
                .filter(entry -> entry.getEmailAddress().equals(email))
                .findAny()
                .get();

         }

    //search method (by type selection, then by typed string)

    public static Entry searchEntry(String selection, String selectSearch) {
        switch (selection) {
            case "1":
                return entryList.stream()
                        .filter(entry -> entry.getFirstName().contains(selectSearch))
                        .findAny()
                        .orElseGet(() -> new Entry("", "", "", ""));

            case "2":
                return entryList.stream()
                        .filter(entry -> entry.getLastName().contains(selectSearch))
                        .findAny()
                        .orElseGet(() -> new Entry("", "", "", ""));

            case "3":
                return entryList.stream()
                        .filter(entry -> entry.getPhoneNumber().contains(selectSearch))
                        .findFirst()
                        .orElseGet(() -> new Entry("", "", "", ""));

            case "4":
                return entryList.stream()
                        .filter(entry -> entry.getEmailAddress().contains(selectSearch))
                        .findFirst()
                        .get();
    //                  .orElseThrow();   --- .orElseThrow() doesn't work in my computer, so replaced with .get()

            default :
                new Entry("", "", "", "");
        }
        return new Entry("", "", "", "");
            }


    //Print address book by get and set method()
    public static List<Entry> getEntryList() {
        return entryList;
        }

        public static void setEntryList(List<Entry> entryList) {
            AddressBook.entryList = entryList;
            }


    public static void deleteEntryList() {
        entryList.clear();
    }
}









