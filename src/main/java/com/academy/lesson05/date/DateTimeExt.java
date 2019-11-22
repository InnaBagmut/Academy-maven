package com.academy.lesson05.date;

import java.util.Objects;

public class DateTimeExt extends DateTime {
    /*    c) Реализовать класс DateTimeExt, который наследуется от класса DateTime
        у него есть дополнительное поле с модификатором private
        int ms миллисекунды

        реализовать конструкторы:
        DateTimeExt() - по умолчанию
        DateTimeExt(int year, int month, int day, int hour, int minute, int second, int ms) со всеми параметрами
        DateTimeExt(DateTimeExt dateTimeExt)копирования

            - добавить возможность задавать расширенное время с помощью конструкторов и метода set
            - переопределить методы toString, equals и hashCode
            - реализовать метод print, который выводит время на консоль в формате: 25.01.2017 15:05:35.357*/
    private int milliseconds;

    public DateTimeExt() {
        this.milliseconds = 0;
    }

    public DateTimeExt(int day, int month, int year, int hour, int minute, int second, int milliseconds) {
        super(day, month, year, hour, minute, second);
        this.milliseconds = milliseconds;
    }

    public DateTimeExt(DateTimeExt dateTimeExt) {
        //super(dateTimeExt);
        this.milliseconds = dateTimeExt.milliseconds;
    }

    public int getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    public void print() {
        System.out.println(String.format("Date, time and even ms: %d.%d.%d %d:%d:%d.%d",
                getDay(), getMonth(), getYear(), getHour(), getMinute(), getSecond(), milliseconds));
    }

    @Override
    public String toString() {
        return "DateTimeExt{" +
                "day=" + getDay() +
                ", month=" + getMonth() +
                ", year=" + getYear() +
                ", hour=" + getHour() +
                ", minute=" + getMinute() +
                ", second=" + getSecond() +
                ", milliseconds=" + milliseconds +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DateTimeExt)) return false;
        if (!super.equals(o)) return false;
        DateTimeExt that = (DateTimeExt) o;
        return milliseconds == that.milliseconds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), milliseconds);
    }
}
