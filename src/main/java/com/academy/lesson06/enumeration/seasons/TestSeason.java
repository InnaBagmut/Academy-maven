package com.academy.lesson06.enumeration.seasons;

public class TestSeason {
    public static void main(String[] args) {
        System.out.println("All seasons: ");
        Season[] seasonsArray = {Season.WINTER, Season.SPRING, Season.SUMMER, Season.AUTUMN};
        for (int i = 0; i < seasonsArray.length; i++) {
            System.out.println(seasonsArray[i]);
        }

        System.out.println("Let's define the next season: ");
        Season today1 = Season.AUTUMN;
        System.out.println("The " + today1.next() + " comes after the " + today1);

        System.out.println("Let's define the previous season: ");
        Season today2 = Season.SUMMER;
        System.out.println("The " + today2.next() + " is before the " + today2);
    }
}
