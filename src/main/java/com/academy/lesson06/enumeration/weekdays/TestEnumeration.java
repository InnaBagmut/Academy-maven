package com.academy.lesson06.enumeration.weekdays;

import static com.academy.lesson06.enumeration.weekdays.WeekDay.*;

public class TestEnumeration {
    public static void main(String[] args) {
        UseWeekDay myObject = new UseWeekDay();
        myObject.setToday(WEDNESDAY);
        System.out.println(myObject);
        System.out.println(myObject.getToday());
        System.out.println("Day After Tomorrow Option1:");
        myObject.dayAfterTomorrowOption1();


        System.out.println("Day After Tomorrow Option2:");
        WeekDay day1 = SUNDAY;
        //WEDNESDAY.dayAfterTomorrowOption2();
        WeekDay dayAfterTomorrow = day1.dayAfterTomorrowOption2();
        System.out.println("2 days after " + day1 + " is " + dayAfterTomorrow);

        System.out.println("Day Before Yesterday:");
        WeekDay day2 = MONDAY;
        //TUESDAY.dayBeforeYesterday();
        WeekDay dayBeforeYesterday = day2.dayBeforeYesterday();
        System.out.println("2 days before " + day2 + " is " + dayBeforeYesterday);

        System.out.println("This is an array filled by days of the week:");
        WeekDay[] daysArray = {SUNDAY, THURSDAY, MONDAY, FRIDAY, TUESDAY};
        for (int i = 0; i < daysArray.length; i++) {
            System.out.println(daysArray[i]);
        }

        System.out.println("This is demo of the name:");
        System.out.println(WeekDay.SATURDAY.getName());
    }
}
