package com.tts;


import java.util.*;


public class AddressBook {

    //field: an ArrayList of generic type Entries

    static List<Entry> entryList = new ArrayList<>();

    //methods: ways to manipulate the array list

    //add method

    public static void addEntry(Entry entry) {
        entryList.add(entry);
        System.out.println(entry);
    }


    public static void removeEntry(String email) {
        System.out.println(searchEntry(email));
        entryList.removeIf(entry -> entry.getEmailAddress().equals(email));
//        System.out.println(entry);
    }



    //delete
    //finding

    public static Optional<Entry> searchEntry(String email) {
        return entryList.stream()
                .filter(entry -> entry.getEmailAddress().equals(email))
                .findFirst();
//                .orElseThrow();
    }
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








