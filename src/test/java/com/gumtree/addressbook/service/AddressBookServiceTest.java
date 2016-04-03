package com.gumtree.addressbook.service;

import com.gumtree.addressbook.dto.Person;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.gumtree.addressbook.dto.Gender.Female;
import static com.gumtree.addressbook.dto.Gender.Male;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AddressBookServiceTest {
    private AddressBookService addressBookService = new AddressBookService();

    @Before
    public void setUp() throws Exception {
        addressBookService.loadAddressBook();
    }

    @Test
    public void testNumberOfMales() throws Exception {
        assertThat("Wrong number of Male count", addressBookService.findGenderCount(Male), is(3L));
    }
    
    @Test
    public void testFindPersonByName() {
        Person expectedPersonByName = new Person("Sarah Stone", Female, new LocalDate(1980, 9, 20));

        Person actualPersonByName = addressBookService.findPersonByName(expectedPersonByName.getName());

        assertThat(actualPersonByName, is(expectedPersonByName));
    }

    @Test
    public void testFindOldestPerson() throws IOException, URISyntaxException {
        Person expectedOldestPerson = addressBookService.findPersonByName("Wes Jackson");

        Person actualOldestPerson = addressBookService.findOldestPerson();

        assertThat(actualOldestPerson, is(expectedOldestPerson));
    }
}