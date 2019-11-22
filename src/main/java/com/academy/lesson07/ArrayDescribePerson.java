package com.academy.lesson07;

import java.sql.ClientInfoStatus;
import java.util.Arrays;

import static com.academy.lesson07.Gender.FEMALE;
import static com.academy.lesson07.Gender.MALE;

public class ArrayDescribePerson {
    public static void main(String[] args) {
        Object[] describePerson = {"Peter", MALE, 25};
        System.out.println("Name: " + describePerson[0] + ", gender " + describePerson[1] + ", age: " + describePerson[2]);

        Object[][] listOfPersons = new Object[4][3];
        //listOfPersons = {{}, {}, {}, {}};
        listOfPersons[0] = describePerson;
        listOfPersons[1] = new Object[]{"Boris", MALE, 26};
        listOfPersons[2] = new Object[]{"Helen", FEMALE, 23};
        listOfPersons[3] = new Object[]{"Ben", MALE, 34};

        System.out.println(listOfPersons[0][0]);
        System.out.println(listOfPersons[0][1]);
        System.out.println(listOfPersons[0][2]);

        for (int row = 0; row < listOfPersons.length; row++) {
            System.out.println();
            for (int column = 0; column < listOfPersons[row].length; column++) {
                System.out.print(listOfPersons[row][column] + " ");
            }
        }
        System.out.println();
        System.out.println("***");
        System.out.println(Arrays.deepToString(listOfPersons));
    }
}
