package com.academy.lesson02;

import java.util.Scanner;

public class DivisionWithReminder {
    public static void divisionWithReminder() {
               /*        7)
        В переменных q и w хранятся два натуральных числа. Создайте программу, выводящую на экран результат деления q на w с остатком.
                Пример вывода программы (для случая, когда в q хранится 21, а в w хранится 8): 21 / 8 = 2 и 5 в остатке

        - прочитать число q
        - прочитать число w

        - вывести число q
        - вывести число w

        - вывести результат целочисленного деления
                - вывести остаток от деления

        Пример:
        q = 21;
        w = 8;
        q/w = 2;
        r = 5 (остаток)

                числа (q и w) передать в программу извне любым способом:
                - как аргументы метода main.
                - предложить пользователю ввести значения
                -* проверить, если не заданы в аргументах в метода main, только в этом случае предложить ввести с консоли*/
        System.out.println("==========================================================");
        System.out.println("А теперь, деление и остаток от деления:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 2 целых числа: ");
        int q = scanner.nextInt();
        int w = scanner.nextInt();
        System.out.printf(" q = %d,%n w = %d,%n q/w = %d,%n r = %d (остаток)%n", q, w, q / w, q % w);
        /*     11) Проинициализировать одномерный массив произвольными целыми числами
        Вывести массив в виде, например:
		[3, 4, 9, 10, 34, 239, 8, 0, -3, 19, 17]
        a) используя цикл for
        b) используя цикл while*/
        System.out.println("==========================================================");
        System.out.println("Random filling up array via For cycle: ");
        int[] randomeArray = new int[10];
        System.out.print("[");
        for (int i = 0; i < randomeArray.length; i++) {
            randomeArray[i] = (int) Math.round(Math.random() * 30 - 15);
            System.out.print(randomeArray[i] + ", ");
        }
        System.out.println("]");

        System.out.println("Random filling up array via While cycle: ");
        System.out.print("[");
        int j = 0;
        while (j < randomeArray.length) {
            randomeArray[j] = (int) Math.round(Math.random() * 100 - 5);
            System.out.print(randomeArray[j] + ", ");
            j++;
        }
        System.out.println("]");
    }
}
