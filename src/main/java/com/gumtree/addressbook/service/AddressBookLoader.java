package com.gumtree.addressbook.service;

import com.gumtree.addressbook.dto.Gender;
import com.gumtree.addressbook.dto.Person;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.joda.time.format.DateTimeFormat.forPattern;

public class AddressBookLoader {

    private DateTimeFormatter DATE_OF_BIRTH_PATTERN = forPattern("dd/MM/yy");

    public Set<Person> doLoad(String addressBookFile) throws IOException, URISyntaxException {
        Stream<String> stream = Files.lines(Paths.get(getClass().getResource(addressBookFile).toURI()));
        return stream.map(this::parserLine).collect(toSet());
    }

    private Person parserLine(String line) {
        try {
            String[] part = StringUtils.split(line, ",");
            String name = part[0];
            Gender gender = Gender.valueOf(part[1].trim());
            LocalDate dateOfBirth = DATE_OF_BIRTH_PATTERN.parseLocalDate(part[2].trim());
            return new Person(name, gender, dateOfBirth);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
