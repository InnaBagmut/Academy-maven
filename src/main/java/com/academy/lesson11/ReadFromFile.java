package com.academy.lesson11;

import java.io.*;

public class ReadFromFile {
    public static void main(String[] args) throws IOException {
        System.out.println("Read 10 names from the file");
        String inPath = "d:\\!!!Autotesting\\!Telesens_Academy\\lesson11\\женские имена.txt";
        String inPathNewFile = "d:\\!!!Autotesting\\!Telesens_Academy\\lesson11\\женские имена new.txt";
        BufferedReader br = new BufferedReader(new FileReader(inPath));
        PrintWriter pw = new PrintWriter(new PrintWriter(inPathNewFile));
        String name = br.readLine();
        System.out.println(name);
        String name2 = br.readLine();
        System.out.println(name2);

        System.out.println("Read all names from file:");
        String nextName;
        while ((nextName = br.readLine()) != null) {
            System.out.println(nextName);
        }

        System.out.println("Output first 10:");
        br.lines() // returns Stream
                .limit(10)
                .forEach(System.out::println);
        br.close();

        System.out.println("Write to other file:");

        BufferedReader brNew1 = new BufferedReader(new FileReader(inPath));
        brNew1.lines()
                .limit(10)
                .peek(pw::println)
                .forEach(System.out::println);
        brNew1.close();
        pw.close();
    }
}
