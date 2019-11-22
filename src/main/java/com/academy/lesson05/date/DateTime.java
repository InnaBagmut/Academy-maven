/*    b) Реализовать класс DateTime, который наследуется от класса Date.
    В нем должны быть дополнительные поля
			- hour (часы)
			- minute (минута)
			- second (секунда)

    Все поля должны быть помечены модификатором private
		- добавить конструкторы:
    DateTime() - по умолчанию
    DateTime(int year, int month, int day, int hour, int minute, int second) со всеми параметрами
    DateTime(DateTime dateTime)копирования

		- реализовать доступ к полям через методы set и get

		- реализовать метод print();
    который отображает время и дату: 25.01.2017 15:05:35

            - реализовать перегруженный метод print(boolean isTimeFormat12);
    который отображает время и дату в зависимости от флага isTimeFormat12:
            25.01.2017 3:05 p.m.  // isTimeFormat12 is true
				25.01.2017 15:05  	  // isTimeFormat12 is false

                        - переопределить методы toString, equals и hashCode

		- реализовать метод checkTime(int hour, int minute, int second), который проверяет существование введенного времени
		- использовать метод checkTime(...) при попытке изменть инициализировать класс с помощью конструктора, или при попытке
    модифицировать поля с помощью методов set

		- реализовать методы
    nextSecond();
    nextMinute();
    nextHour();
    которые увелечивают на единицу значение секунды, минуты и часа соответственно, при чем если кол-во часов достигается
			24, то должно увеличиться на единицу значение поля day из базового класса

		-* реализовать метод addSeconds(int seconds), который добавляет указанное кол-во секунд к текущей дате

		- переопределить метод toString();
    который возвращает строковое представление времени: 15:05:35
            - переопределить метод equals(Object obj) и hashCode() // использовать автогенерацию
            - реализовать метод printTime(), который отображает на консоле полное время в формате: 15:05:35
            - реализовать перегруженный метод printTime(boolean isTimeFormat12);
    который выводит время в 12 часовом формате, если isTimeFormat12 равно true:  3:05 p.m.
    выводит время в 24 часовом формате, если isTimeFormat12 равно false: 15:05*/

package com.academy.lesson05.date;

import java.util.Objects;

public class DateTime extends Date {

    private int hour;
    private int minute;
    private int second;

    public DateTime() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    //@SuppressWarnings("deprecation")
    public DateTime(int day, int month, int year, int hour, int minute, int second) {
        super(day, month, year);
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public DateTime(int hour, int minute, int second) {    // this constructor uses in \com\academy\lesson08\CorrectTime.java
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public DateTime(DateTime dateTime) {
        super(dateTime);
        this.hour = dateTime.hour;
        this.minute = dateTime.minute;
        this.second = dateTime.second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    //@SuppressWarnings("deprecation")
    public void print() {
        System.out.println(String.format("Date and time: %d.%d.%d %d:%d:%d", super.getDay(), super.getMonth(), super.getYear(), hour, minute, second)); //не хочет подхватывать day, month, year
    }

    public int nextSecond() {
        return second++;
    }

    public int nextMinute() {
        return minute++;
    }

    public int nextHour() {
        //hour++;
       // if (hour == 24) super.getDay(setDay()++;
        //if (hour > 24)
            return hour++;
    }

    @Override
    public String toString() {
        return "DateTime{" +
                "day=" + getDay() +
                ", month=" + getMonth() +
                ", year=" + getYear() +
                ", hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DateTime)) return false;
        if (!super.equals(o)) return false;
        DateTime dateTime = (DateTime) o;
        return hour == dateTime.hour &&
                minute == dateTime.minute &&
                second == dateTime.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hour, minute, second);
    }
}
