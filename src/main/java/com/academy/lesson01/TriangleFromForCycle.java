package com.academy.lesson01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class TriangleFromForCycle {
    /*    10)
    a) Написать Java программу, которая выводит на консоль следующую фигуру:
            *
            **
            ***
            ****
            *****
            ******
    b) скомпилировать программу
    с) запустить
    d) упаковать в jar
    e) запустить из jar архива*/
    public static String triangleFromSymbols() throws IOException {
        System.out.println("=============================================================================");
        System.out.println("The program outputs the triangle with predefined size and filling:");
        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);
        System.out.println("Enter size for equilateral triangle (only integer number allowed): ");
        int size = Integer.parseInt(reader.readLine());
        System.out.println("Enter any symbol: ");
        String symbol = reader.readLine();
        for (int i = 0; i <= size; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(symbol);
            }
            System.out.println(symbol);
        }
        return symbol;
    }
}
