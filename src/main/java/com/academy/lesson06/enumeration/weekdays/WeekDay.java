package com.academy.lesson06.enumeration.weekdays;

public enum WeekDay {

/*    1)  Перечисление для представления дней недели
    Реализовать перечисление "День недели": Понедельник, Вторник, ...
    В перечислении "День недели" добавить функции получения дня "позавчера" и "послезавтра".
    Протестировать перечисление в функции main() тестового класса.*/

    SUNDAY("Воскресенье"),
    MONDAY("Понедельник"),
    TUESDAY("Вторник"),
    WEDNESDAY("Среда"),
    THURSDAY("Четверг"),
    FRIDAY("Пятница"),
    SATURDAY("Суббота");

    private String name;

    WeekDay(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

/*    @Override
    public String toString() {
        return name() + " " + ordinal();
    }*/

    WeekDay next() {
        //WeekDay day = values()[(ordinal() + 1) % values().length];
        int index = ordinal() + 1;
        if (index > 6)
            index = 0;
        WeekDay day = values()[index];
        return day;
    }

    public WeekDay dayAfterTomorrowOption2() {  // Option1 in UseWeekDay class
        return this.next().next();
    }

    WeekDay previous() {
        int index = ordinal() - 1;
        if (index < 0)
            index = 6;
        WeekDay day = values()[index];
        return day;
    }

    public WeekDay dayBeforeYesterday() {
        return this.previous().previous();
    }

    //this is just training:
    boolean isWeekend() {
        switch (this) {
            case SATURDAY:
            case SUNDAY:
                return true;
            default:
                return false;
        }
    }
}

