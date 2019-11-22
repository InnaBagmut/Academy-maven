package com.academy.lesson03;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetWordsWithDReturn {
    public static List<String> getWordsStartingWithD() throws IOException {
        System.out.println("=============================================================================");
        System.out.println("The program outputs the number of words that begin with 'd' letter:");
        System.out.println("Enter phrase or random words: ");
        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);
        String phrase = reader.readLine();
        System.out.println("You entered: " + phrase);
        List<String> separateWords = Arrays.asList(phrase.split(" "));
        List<String> dwords = new ArrayList<>();
        for (int i = 0; i < separateWords.size(); i++) {
            if (separateWords.get(i).startsWith("d"))
                dwords.add(separateWords.get(i));
            System.out.println(separateWords.get(i));
        }
        System.out.println("Number of words started with d: " + dwords.size());

        return dwords;
    }
}