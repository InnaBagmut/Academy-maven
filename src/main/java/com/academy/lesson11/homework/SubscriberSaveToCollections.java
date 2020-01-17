package com.academy.lesson11.homework;

import com.academy.lesson06.Gender;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class SubscriberSaveToCollections {
    private Long id;
    private String firstname;
    private String lastname;
    private Gender gender;
    private int age;
    private String phoneNumber;

    //Map<Long, Subscriber> = new
    public static void main(String[] args) throws IOException {
        // Path to properties:
        File file = new File("d:/autotesting/auto-projects/Academy-maven/src/main/resources/java-part.properties");
        Properties prop = new Properties();
        prop.load(new FileInputStream(file));
        // Read XSL file
        FileInputStream fis = new FileInputStream(prop.getProperty("subscriber.exc"));  //OR prop.getProperty("subscriber.exc"))
        Workbook workbook = new XSSFWorkbook(fis);
        // Get first sheet from the workbook
        Sheet firstSheet = workbook.getSheetAt(0);

        List<String> dataFromFile = new ArrayList<>();

        workbook.close();
        fis.close();
    }
}

