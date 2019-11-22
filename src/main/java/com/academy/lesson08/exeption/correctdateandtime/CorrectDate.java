/*1)
        a) Создать класс IllegalDateException, который является
        наследником класса Exception.

        b) Модифицировать класс Date, добавив в конструктор
        выбрасывания исключения IllegalDateException при
        попытки создать некорректную (не существующую дату)

        c)  протестировать работу конструктора на позитивных кейсах:
        - new Date(1, 1, 2012);
        - new Date(17, 2, 2019);
        - new Date(29, 2, 2020);
        - new Date(31, 1, 1999);
        - new Date(13, 6, 1681);


        протестировать работу конструктора на негативных кейсах, т.е.
        ожидаем выбрасывания исключения:

        - new Date(-1, 1, 2012); 	// отрицательный день
        - new Date(31, 2, 2019); 	// большое значение для дня
        - new Date(29, 2, 2019); 	// не высокосный год
        - new Date(31, 13, 1999); 	// 13 месяца не существует
        - new Date(0, 06, 1681); 	// нулевого дня не существует*/
package com.academy.lesson08.exeption.correctdateandtime;
import com.academy.lesson05.date.Date;

public class CorrectDate extends Date {
    public CorrectDate() {
    }

    public CorrectDate(int day, int month, int year) throws IllegalDateException{
        super(day, month, year);

        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1 || year > 3000) throw new IllegalDateException("Incorrect value");
    }

    public CorrectDate(Date date) {
        super(date);
    }
}
