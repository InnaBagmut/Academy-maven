package com.academy.lesson02;

import java.util.Scanner;

public class TriangleAgain {
    public static void triangleAgain() {
        /* 13)    Нарисовать треугольник заданной размерности. Пример для размера 6:
         *
         **
         ***
         ****
         *****
         ******                 */
        System.out.println("==========================================================");
        System.out.println("Рисуем треугольник: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задайте размерность для равностороннего треугольника: ");
        int size = scanner.nextInt();
        System.out.println("Введите один символ для наполнения треугольника: ");
        String symbol = scanner.next();
        for (int i = 0; i <= size; i++) {
            for (int k = 0; k < i; k++) {
                System.out.print(symbol);
            }
            System.out.println(symbol);
        }

    }
}
