package com.academy.lesson01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class AppMain {
    public static void main(String[] args) throws IOException {
        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);
        System.out.print("What is your name? ");
        String name = reader.readLine();
        System.out.println("Hello, " + name);
    }
}
