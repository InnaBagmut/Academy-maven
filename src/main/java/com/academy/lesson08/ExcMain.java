package com.academy.lesson08;

public class ExcMain {
    public static void main(String[] args) {


        Object[] array = {"Kolya", 45, 56, "Ivan", "Helen", 34, 18, "Peter", "Boris", 15};
        // только строки
        for (int i = 0; i < array.length; i++) {
            if (array[i] instanceof String)
                System.out.println(array[i]);
        }

        // только числа
        for (int i = 0; i < array.length; i++) {
          if (array[i].getClass() == Integer.class)
              System.out.println(array[i]);
        }
        System.out.println("2Dim array: ");
        Object[][] array2D = {{"Ivan", 34}, {"Kolya", 56}, {"Boris", 18}, {"Kolya", 18}, {"Peter", 15}, {"Helen", 45}, {"Kolya", 32}};

        // только строки
       // System.out.println("2Dim array: ");
        for (int row = 0; row < array2D.length; row++) {
            for (int column = 0; column < array2D[row].length; column++)
                System.out.println(array2D[row][0]);
        }

        // только числа

    }
}
