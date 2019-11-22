package com.academy.lesson04;

public class SomeNumber {
    /*    1) Предположим, имеется следующий класс.
        class SomeNumber {
            private int n; // единственное поле класса
            // ...
        }
        a) Реализуйте конструктор без параметров (по умолчанию инициализируем 0)
        b) Конструктор, с одним параметром (int n)
        c) Метод int getN();
        d) Метод int setN();
        e) Метод print();
        который выводит строку, напр: "Число: 5"
        f) Метод boolean isPositive(); // которые возвращает true, если число положительное и false, если число отрицательное*/

    private int n;

    public SomeNumber() {
        this.n = 0;
    }

    public SomeNumber(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void print() {
        System.out.println("Число: " + n);
    }

    public boolean isPozitive() {
        if (n >= 0)
            return true;
        return false;
    }
}
