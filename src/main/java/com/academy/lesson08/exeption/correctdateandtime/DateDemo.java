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

public class DateDemo {
    public static void main(String[] args) {
            try {
            CorrectDate date1 = new CorrectDate(15, 12, 2019);
            date1.print();
            CorrectDate date2 = new CorrectDate(-1, 22, 2000);
            date2.print();
            CorrectDate date3 = new CorrectDate(1, 1, 2012);
            date3.print();
            CorrectDate date4 = new CorrectDate(17, 2, 2019);
            CorrectDate date5 = new CorrectDate(29, 2, 2020);
            CorrectDate date6 = new CorrectDate(31, 1, 1999);
            CorrectDate date7 = new CorrectDate(13, 6, 1681);
            CorrectDate date8 = new CorrectDate();
            CorrectDate date9 = new CorrectDate(-1, 1, 2012);
            CorrectDate date10 = new CorrectDate(31, 2, 2019);
            CorrectDate date11 = new CorrectDate(29, 2, 2019);
            CorrectDate date12 = new CorrectDate(0, 6, 1681);
            date12.print();
        } catch (IllegalDateException e) {
            //System.out.println("Enter valid data");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Continue the executing");
        //date12.print();
    }
}
