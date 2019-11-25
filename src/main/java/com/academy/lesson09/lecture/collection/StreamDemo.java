package com.academy.lesson09.lecture.collection;

import com.academy.lesson05.date.Date;

import java.util.ArrayList;
import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {
        List<Date> dates = new ArrayList<>();
        dates.add(new Date(23, 12, 2019));
        dates.add(new Date(22, 3, 1987));
        dates.add(new Date(9, 9, 1999));

        dates.stream()
                .filter(d -> d.getMonth() == 12)
                .forEach(System.out::println);

        for (Date d : dates) {
            if (d.getYear() == 1999) {
                System.out.println(d);
            }
        }
    }
}