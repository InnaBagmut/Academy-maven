package com.academy.lesson10.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionsContinue {
    public static void main(String[] args) {
        List<String> listOfNames = new ArrayList<>(Arrays.asList("fabian", "den"));
        listOfNames.add("phillipp");
        listOfNames.add("joseph");
        listOfNames.add("leon");
        listOfNames.add("bayan");
        listOfNames.add("kate");
        listOfNames.add("ben");
        listOfNames.add(3, "ашот");
        System.out.println("Step 1: " + listOfNames);

        for (int i = 0; i < listOfNames.size(); i++) {
            String name = listOfNames.get(i);
            String modifiedName = convertFirstLetterToUppercase(name);
            listOfNames.set(i, modifiedName);

/*            char firstLetter = preparedNames[i].charAt(0);
            firstLetter = Character.toUpperCase(firstLetter);
            String lastLetters = preparedNames[i].substring(1);
            preparedNames[i] = firstLetter + lastLetters;*/
        }

        System.out.println("" + listOfNames);
    }

    public static String convertFirstLetterToUppercase(String value) {
        char firstLetter = value.charAt(0);
        firstLetter = Character.toUpperCase(firstLetter);
        String restLetters = value.substring(1);
        String result = firstLetter + restLetters;
        return result;
    }
}
