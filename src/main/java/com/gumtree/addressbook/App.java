package com.gumtree.addressbook;

import com.gumtree.addressbook.service.AddressBookService;

import static com.gumtree.addressbook.dto.Gender.Male;

public class App {
    public static void main(String s[]) {
        AddressBookService addressBookService = new AddressBookService();
        addressBookService.loadAddressBook();
        System.out.println("\n\n\n");
        System.out.println("How many males are in the address book? " + addressBookService.findGenderCount(Male));
        System.out.println("Who is the oldest person in the address book? " + addressBookService.findOldestPerson().toString());
        System.out.println("How many days older is Bill than Paul? " + addressBookService.findAgeDifferenceInDays("Bill McKnight", "Paul Robinson") + " days");
        System.out.println("\n\n\n");
    }
}
