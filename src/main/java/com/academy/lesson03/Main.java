package com.academy.lesson03;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> dwords = GetWordsWithDReturn.getWordsStartingWithD();
        System.out.println(dwords);
        CountOfSubStrings.countOfStrings();
        CountOfSubStrings.countOfStringsOption2();
    }
}
