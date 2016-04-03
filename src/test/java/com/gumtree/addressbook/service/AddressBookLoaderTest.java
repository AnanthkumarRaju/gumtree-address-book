package com.gumtree.addressbook.service;

import com.gumtree.addressbook.dto.Person;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class AddressBookLoaderTest {

    private AddressBookLoader addressBookLoader = new AddressBookLoader();

    @Test
    public void testLoadAddressBook_WhenValidAddressBookGiven_ShouldReturnCorrectResults() throws Exception {
        Set<Person> persons = addressBookLoader.doLoad("/ValidAddressBook");

        assertThat(persons, hasSize(5));
    }

    @Test
    public void testLoadAddressBook_WhenEmptyAddressBookGiven_ShouldReturnEmptySet() throws Exception {
        Set<Person> persons = addressBookLoader.doLoad("/EmptyAddressBook");

        assertThat(persons, hasSize(0));
    }

    @Test(expected = RuntimeException.class)
    public void testLoadAddressBook_WhenInValidAddressBookGiven_ShouldThrowRunTimeException() throws Exception {
        addressBookLoader.doLoad("/InValidAddressBook");
    }

}