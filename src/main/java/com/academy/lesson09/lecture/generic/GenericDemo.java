package com.academy.lesson09.lecture.generic;

public class GenericDemo {
    public static void main(String[] args) {
        Pair pair = new Pair();
        pair.setValue1("Hello");
        pair.setValue2(123);

        String str = (String) pair.getValue1();
        int n = (int) pair.getValue2();

       // str = pair.getValue1();

        PairGeneric<String, Integer> pairGen1 = new PairGeneric<>();
        pairGen1.setValue1("Congratulation");
        pairGen1.setValue2(2354);

        System.out.println("str: " + str + "n: " + n);

        PairGeneric<String, String> pairGen2 = new PairGeneric<>();
        pairGen2.setValue1("Hello");
        pairGen2.setValue2("Worlsd");

        //pairGen2.setValue2(3423);

        print(pairGen1);
        print(pairGen2);

    }

    public static void print(PairGeneric<?, ?> pair) {
        System.out.println(pair);
    }
}
