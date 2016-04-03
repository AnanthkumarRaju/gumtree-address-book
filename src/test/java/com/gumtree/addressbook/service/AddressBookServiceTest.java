package com.gumtree.addressbook.service;

import org.junit.Before;
import org.junit.Test;

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

}