package com.academy.lesson02;

import java.util.Scanner;
import static java.text.MessageFormat.format;

public class MinMaxAvgValues {
      /*    1) Написать программу ввода с клавиатуры последовательно 3 чисел. Вывести
    минимальное максимальное и средние значения*/
    public static void getMinMaxAvg() {
        System.out.println("=============================================================================");
        System.out.println("Программа определения max, min и middle числа");
        System.out.println("Введите 3 числа:");
        Scanner scanner = new Scanner(System.in);
        //создаём массив:
        double[] array = new double[3];
        //наполняем массив 3мя элементами:
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextDouble();
        }
        //System.out.println(array[2]);

        //определяем максимальное:
        double max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        System.out.println("Максимум: " + max);
        //определяем минимальное:
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
        }
        System.out.println("Минимум: " + min);
        //определяем среднее:
        double avr = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != max && array[i] != min)
                System.out.println("Среднее: " + array[i]);
        }
    }
}
