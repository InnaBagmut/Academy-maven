package com.academy.lesson13;

import com.academy.lesson06.Gender;
import com.academy.lesson06.Person;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.stream.Collectors;

//import static sun.text.normalizer.UCharacter.HangulSyllableType.COUNT;

public class GenerateToDB {
    private final static int COUNT = 100;
    private final static String SQL_INSERT =
            "insert into abonent(first_name, last_name, gender, age) values (?, ?, ?, ?)";
    // Path to properties:
    File file = new File("d:/autotesting/auto-projects/Academy-maven/src/main/java/com/academy/lesson11/homework/java-part.properties");
    Properties prop = new Properties();

    // configs
    private static String dbUrl = "jdbc:mysql://localhost:3306/subscriber?user=root&password=root&serverTimezone=UTC";
    private static String pathMaleNames = "d:/autotesting/Telesens_Academy/lesson11/male_firstnames.txt";
    private static String pathFemaleNames = "d:/autotesting/Telesens_Academy/lesson11/male_lastnames.txt";
    private static String pathMaleLastNames = "d:/autotesting/Telesens_Academy/lesson11/female_firstnames.txt";
    private static String pathFemaleLastNames = "d:/autotesting/Telesens_Academy/lesson11/female_lastnames.txt";

    private static Random random = new Random();

    private static List<String> maleFirstNames;
    private static List<String> femaleFirstNames;
    private static List<String> maleLastNames;
    private static List<String> femaleLastNames;

    public static void main(String[] args) throws Exception {
        fillLists();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(dbUrl);
        PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
        for (int i = 1; i <= COUNT; i++) {
            Person person = nextPerson();
            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            // Тернарный оператор <условие> ? true : false
            ps.setString(3, person.getGender() == Gender.MALE ? "m" : "f");
//            if (person.getGender() == Gender.MALE)
//                ps.setString(3,  "m");
//            else
//                ps.setString(3, "f");
            ps.setInt(4, person.getAge());
            ps.execute();
        }
        ps.close();
        connection.close();
    }

    private static void fillLists() throws IOException {
        maleFirstNames = read(pathMaleNames);
        femaleFirstNames = read(pathFemaleNames);
        maleLastNames = read(pathMaleLastNames);
        femaleLastNames = read(pathFemaleLastNames);
    }

    private static Person nextPerson() throws IOException {
        Gender gender = random.nextBoolean() ? Gender.MALE : Gender.FEMALE;
        String firstName = gender == Gender.MALE ?
                maleFirstNames.get(random.nextInt(maleFirstNames.size())) :
                femaleFirstNames.get(random.nextInt(femaleFirstNames.size()));

        String lastName = gender == Gender.MALE ?
                maleLastNames.get(random.nextInt(maleLastNames.size())) :
                femaleLastNames.get(random.nextInt(femaleLastNames.size()));

        int age = 5 + random.nextInt(85);
        return new Person(firstName, lastName, gender, age);
    }

    private static List<String> read(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        List<String> result = br.lines()
                .collect(Collectors.toList());
        br.close();
        return result;
    }
}
