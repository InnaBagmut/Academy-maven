/*1) Дан массив имен: {"Peter", "Helen", "Andry", "Abdel", "Kate", "Veronica", "Leonid", "Alex", "max} - имена можно свои
        a) Создать список List из элементов массива и вывести на экран
        b) Добавить 3 новых имени в список (Philip, Joseph, Leon) и вывести весь список на экран
        c) Удалить из списка все имена: Veronica, Leonid и вывести на экран
        d) Поменять имя Helen на Elizabet
        e) Отсортировать имена по алфавиту и вывести на экран
        f) Отсортировать имена в обратном порядке и вывести имена на экран
        g) Перевести все первые символы в верхний регистр
        h) Вывести все имена, начинающиеся на букву A
        i) Проверить, содержит ли список имя Andry
        j) Удалить из списка все имена кроме Kate и Helen*/

package com.academy.lesson09.homework.collection;

import java.util.*;

public class NamesCollectionDemo {
    public static void main(String[] args) {
        String[] names = {"Fabian", "Enya", "Joseph", "Rose", "Artur", "rain", "Amanda", "Mary", "Mike"};
        //System.out.println("Step 0:" + Arrays.toString(names));
        List<String> listOfNames = new ArrayList<>(Arrays.asList(names));
        System.out.println("Step a:" + listOfNames);
        listOfNames.add("Phillipp");
        listOfNames.add("Joseph");
        listOfNames.add("Leon");
        System.out.println("Step b:" + listOfNames);
        listOfNames.remove("Fabian");
        listOfNames.remove("Daniel");
        System.out.println("Step c:" + listOfNames);
        //меняем Enya на Elizabeth, вычислив индекс ячейки со значением "Enya":
        listOfNames.set(0, "Elizabeth");
        System.out.println("Step d:" + listOfNames + "(Option 1)");
        //меняем Joseph на Pedro, c помощью значения "Joseph":
        ListIterator<String> iterator = listOfNames.listIterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals("Joseph")) {
                //Replace element
                iterator.set("Pedro");
            }
        }
        System.out.println("Step d:" + listOfNames + "(Option 2)");
        Collections.sort(listOfNames);
        System.out.println("Step e:" + listOfNames);
        //Arrays.sort(listOfNames, Collections.reverseOrder());
        //простой способ отсортировать в обратном порядке. Работает ТОЛЬКО после сортировки в прямом порядке, т.е. массив просто переворачивается:
        Collections.reverse(listOfNames);
        System.out.println("Step f:" + listOfNames);
        //String s = listOfNames.get(0).substring(0, 1).toUpperCase();
        //int s = listOfNames.get(0).indexOf(0);
        //System.out.println(listOfNames.get(0).indexOf(0));
        System.out.println(listOfNames.get(0).charAt(0));
        char c =  listOfNames.get(0).charAt(0);

        String listOfNamesString = listOfNames.toString();
        System.out.println(listOfNamesString);



    }
}