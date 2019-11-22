package com.academy.lesson04;

public class TestSomeNumber {
    /*2) Создайте класс TestSomeNumber, в котором продемонстрируйте работу класса SomeNumber
        на нескольких тестовых данных [-10, -1, 0, 1, 15]
        a) проверить работу конструкторов
        b) проверить работу метода setN();
        c) проверить работу метода isPositive();*/
    public static void main(String[] args) {
        SomeNumber myObject = new SomeNumber();
        myObject.print();
        myObject.setN(-10);
        myObject.print();
        boolean x = myObject.isPozitive();
        System.out.println(x);
        System.out.println("");
        myObject.setN(-1);
        myObject.print();
        x = myObject.isPozitive();
        System.out.println(x);
        System.out.println("");
        myObject.setN(0);
        myObject.print();
        x = myObject.isPozitive();
        System.out.println(x);
        System.out.println("");
        myObject.setN(1);
        myObject.print();
        x = myObject.isPozitive();
        System.out.println(x);
        System.out.println("");
        myObject.setN(15);
        myObject.print();
        x = myObject.isPozitive();
        System.out.println(x);
    }
}
