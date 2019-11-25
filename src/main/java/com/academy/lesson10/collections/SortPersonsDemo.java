package com.academy.lesson10.collections;

import com.academy.lesson06.Person;
import com.academy.lesson06.Gender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortPersonsDemo {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1L, "Peter", Gender.FEMALE));
        persons.add(new Person(2L, "Gena", Gender.MALE));
        persons.add(new Person(10L, "Tim", Gender.MALE));
        persons.add(new Person(6L, "Viktor", Gender.FEMALE));
        persons.add(new Person(34L, "Sandra", Gender.FEMALE));
        persons.add(new Person(156L, "Nina", Gender.FEMALE));
        persons.add(new Person(2L, "Moon", Gender.MALE));
        persons.add(new Person(43L, "Sun", Gender.FEMALE));

        //Sorting up by id - by default
       // Collections.sort(persons);
        System.out.println("Sorted Persons: " + persons);

        //Sorting down:
    }
}
