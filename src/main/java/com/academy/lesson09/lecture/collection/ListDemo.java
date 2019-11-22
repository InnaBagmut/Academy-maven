package com.academy.lesson09.lecture.collection;

import java.util.*;

public class ListDemo {
    public static void main(String[] args) {


        List<String> names = new ArrayList<>();
        names.add("Ginger");
        names.add("Banny");
        names.add("Geely");
        System.out.println(names);

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
        System.out.println(names.contains("Ginger"));
        Collections.sort(names);
        System.out.println(names);

        //List from array:
        String[] brands = {"BMW", "Lexus", "Apple"};
        List<String> listBrands = new ArrayList<>(Arrays.asList(brands));
        System.out.println(listBrands);
        String[] brandsFromList = listBrands.toArray(new String[0]);
        System.out.println(Arrays.toString(brandsFromList));

    }
}
