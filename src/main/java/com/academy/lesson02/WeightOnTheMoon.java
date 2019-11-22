package com.academy.lesson02;

import java.util.Scanner;

public class WeightOnTheMoon {
    public static void weightOnTheMoon() {
        /*    5) Сила тяжести на Луне составляет около 17% земной. Напишите программу, которая
    вычислила бы ваш вес на Луне.
         - запросить земной вес с консоли
		 - вывести ваш вес на Земле
		 - вывести ваш вес на Луне*/
        System.out.println("==========================================================");
        System.out.println("Узнай, сколько ты весишь на Луне!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какой твой земной вес?");
        double weight = scanner.nextDouble();
        System.out.printf("Твой вес на Земле %f кг, это значит, что на Луне ты будешь весить %f кг %n", weight, weight * 17 / 100);

    }
}
