package com.company.Person;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private String firstName;
    private String lastName;
    private Short birthYear;

    private static Scanner scanner = new Scanner(System.in);
    private static PrintStream printStream = System.out;

    private Person() {}

    private Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void changeName(String firstName, String lastName) {
        this.lastName = lastName;
        changeName(firstName);
    }

    public void changeName(String firstName) {
        this.firstName = firstName;
    }

    public static Person input() {
        Person.printStream.println("please enter information about person with format fieldName:FieldValue;");
        String inputString = Person.scanner.nextLine();
        String[] parts = inputString.split(";");

        HashMap<String, String> inputInformation = new HashMap<String, String>();
        for (String part: parts) {
            String[] subParts = part.split(":");
            if (subParts.length == 2) {
                inputInformation.put(subParts[0], subParts[1]);
            }
        }

        String firstName = null;
        String lastName = null;
        Short birthYear = null;

        if (inputInformation.containsKey("firstName")) {
            firstName = inputInformation.get("firstName");
        }
        if (inputInformation.containsKey("lastName")) {
            lastName = inputInformation.get("lastName");
        }
        if (inputInformation.containsKey("birthYear")) {
            birthYear = Short.parseShort(inputInformation.get("birthYear"));
        }
        Person person;
        if (firstName != null) {
            if (lastName != null) {
                person = new Person(firstName, lastName);
            } else {
                person = new Person();
                person.changeName(firstName);
            }
        } else {
            person = new Person();
        }
        if (birthYear != null) {
            person.setBirthYear(birthYear);
        }

        return person;
    }

    public void output() throws Exception {
        printStream.println(String.format("firstName: %s, lastName: %s: age: %d", firstName, lastName, getAge()));
    }

    public Short getAge() throws Exception {
        if (birthYear == null) {
            throw new Exception("birthYear is null");
        }
        LocalDate birthYear = LocalDate.ofYearDay(this.birthYear, 1/*dayOgYear*/);
        LocalDate currentDate = LocalDate.now();

        return (short) Period.between(birthYear, currentDate).getYears();
    }

    private void setBirthYear(Short birthYear) {
        this.birthYear = birthYear;
    }
}
