package com.academy.lesson03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

public class CountOfSubStrings {
    /*    3) Напишите программу, которая:
        - считывает строку
        - считывает подстроку
        - выводит исходные строку и подстроку и выводит кол-во вхождений строки в подстроку*/

    public static void countOfStrings() throws IOException {
        System.out.println("============================================================================");
        System.out.println("The program counts the numbers of congruences:");
        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);
        System.out.println("Enter string: ");
        String string = reader.readLine();
        System.out.println("Enter substring: ");
        String substring = reader.readLine();
        int count = 0;
        int i = 0;
        while (true) {
            i = string.indexOf(substring, i);
            if (i == -1)
                break;
            count++;
            i++;
        }
        System.out.println("Count = " + count);
    }

    public static void countOfStringsOption2() throws IOException {
        // 2 способ неудобный
        String str2 = "sdawadfadhellosdfaHellodshellohellohelloasdfads";
        String sub2 = "hello";
        int count2 = 0;

        for (int j = 0; ; j++) {
            j = str2.indexOf(sub2, j);
            if (j == -1)
                break;
            count2++;
        }
        System.out.println("Count: " + count2);
    }

    public static void countOfStringsOption3() throws IOException {
        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);
        System.out.println("Enter string: ");
        String str = reader.readLine();
        System.out.println("Enter substring: ");
        String substr = reader.readLine();

        System.out.println("echo string: " + str);
        System.out.println("echo substring: " + substr);

        int substrCount = 0;
        int substrPos = 0;
        do {
            substrPos = str.indexOf(substr, substrPos);
            System.out.println("substrPos: " + substrPos);
            if (substrPos > -1) {
                //substrPos += substr.length();
                substrPos++;
                ++substrCount;
            }
        } while (substrPos > -1);
        System.out.println("substring count: " + substrCount);
    }

    public static void countOfStringsOption4() throws IOException {
        //этот способ не правильный
        String str = "adfadhellosdfaHellodshellohellohelloasdfads";
        String sub = "hello";
        int i = str.indexOf(sub, 28);
        System.out.println(i);

        String[] split = str.split(sub);
        System.out.println(Arrays.toString(split));
        System.out.println(split.length);
    }
}
