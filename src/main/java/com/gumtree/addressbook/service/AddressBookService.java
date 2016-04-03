package com.gumtree.addressbook.service;

import com.gumtree.addressbook.dto.Gender;
import com.gumtree.addressbook.dto.Person;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.Set;

import static java.util.Collections.emptySet;

public class AddressBookService {
    
    private static final String ADDRESS_BOOK_FILE = "/AddressBook";
    private AddressBookLoader addressBookLoader = new AddressBookLoader();
    private Set<Person> persons = emptySet();

    public void loadAddressBook() {
        try {
            persons = addressBookLoader.doLoad(ADDRESS_BOOK_FILE);
        } catch (IOException | URISyntaxException e) {
            System.out.println("unable to load the address book. " + e.getMessage());
        }
    }

    public long findGenderCount(Gender gender) {
        return persons.stream().filter(person -> person.getGender() == gender).count();
    }

    public Person findOldestPerson() {
        Optional<Person> oldestPerson = persons.stream().min((p1, p2) -> p1.getDateOfBirth().compareTo(p2.getDateOfBirth()));
        return oldestPerson.get();
    }

    public Person findPersonByName(String name) {
        return persons.stream().filter(person -> person.getName().equals(name)).findFirst().get();
    }
}
