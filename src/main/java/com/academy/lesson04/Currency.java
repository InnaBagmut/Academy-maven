package com.academy.lesson04;

public class Currency {
    /*    Класс Currency для работы с денежными суммами.
        - Класс должен быть представлен двумя private полями:
        double value; для хранения значания суммы
        String name; для хранения названия валюты ("грн", "руб", "$")

        Реализовать 2 конструктора:
            - без параметров
            - и с двумя параметрами, которые принимает (double value, String name);
            - конструктор копирования: (Currency currency)

            - Реализовать метод отображения суммы на экран print();
        Напр. в виде: 154.65руб // отображать не более 2 знаков после запятой

            - Реализовать операцию сравнения:
        boolean isEqual(Currency currency); // вернет true, если и значение и строка - совпадают

            - Реализовать методы:
        void sum(Currency currency); // метод сложения
                (если name отличается от текущего поля 'name', то сложение не производить,
        а вывести сообщение об ошибке ("Error: currency names are differ 'грн' - 'руб')

                void substract(Currency currency); // метод вычитания ...
                void divide(double factor); // деление суммы на число
                void multiply(double factor); // умножение суммы на число*/
    private double value;
    private String name;

    public Currency() {
    }

    public Currency(double value, String name) {
        this.value = value;
        this.name = name;
    }

    Currency(Currency currency) {
        this.value = currency.value;
        this.name = currency.name;
    }

    public void print() {
        System.out.println(String.format("%.2f ", value) + name);
    }

    boolean isEqual(Currency currency) {
        if (!this.name.equalsIgnoreCase(currency.name))
            return false;
        String strValue = String.format("%.2f ", this.value);
        String strCurrValue = String.format("%.2f ", currency.value);
        if (!strValue.equalsIgnoreCase(strCurrValue))
            return false;
        return true;
    }

    public void sum(Currency currency) {
        if (!this.name.equalsIgnoreCase(currency.name)) {
            System.out.println("Error 01: sum, currency names are differ " +  this.name + " and " +  currency.name);
            return;
        }
        this.value += currency.value;
    }

    void substract(Currency currency) {
        if (!this.name.equalsIgnoreCase(currency.name)) {
            System.out.println("Error 02: currency names are differ:" + "'" + this.name + "'" + " and " + "'" + currency.name + "'");
            return;
        }
        this.value -= currency.value;
    }

    void divide(double factor) {
        this.value /= factor;
    }

    public void multiply(double factor) {
        this.value *= factor;
    }
}
