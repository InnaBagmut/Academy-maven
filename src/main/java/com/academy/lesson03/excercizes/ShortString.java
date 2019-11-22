package com.academy.lesson03.excercizes;

public class ShortString {
    public static void main(String[] args) {
        String longStr = "Hello World, wqsdwyyqdfwq";
        String shortStr = "Hello...";
        // longStr = shortStr;
        String result = longStr.substring(0, 5) + "...";
        System.out.println(result + "..."); // ещё один вариант поставить в конце три точки
    }
}
