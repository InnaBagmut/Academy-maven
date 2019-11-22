/*2)
	a) Создать класс IllegalTimeException, который является
		наследником класса Exception.

	b) Модифицировать класс DateTime, добавив в конструктор
		выбрасывания исключения IllegalTimeException при
		попытки создать некорректную (не существующее время)

	c)  протестировать работу конструктора на позитивных кейсах:
		- new DateTime(12, 12, 12);
		- new DateTime(23, 1, 1);
		- new DateTime(0, 0, 0);
		- new DateTime(23, 59, 59);


		протестировать работу конструктора на негативных кейсах, т.е.
			ожидаем выбрасывания исключения:

		- new DateTime(-12, 12, 12); 	// отрицательный минуты не суще-ет
		- new DateTime(23, 1, 60); 		// большое значение для секунды
		- new DateTime(23, 1, 60); 		// большое значение для часа
		- new DateTime(23, 1, 60); 		// большое значение для минуты*/

package com.academy.lesson08.exeption.correctdateandtime;

public class TimeDemo {
    public static void main(String[] args) throws IllegalDateException {
        try {
            CorrectTime time1 = new CorrectTime(12, 12, 12);
            time1.print();
            CorrectTime time2 = new CorrectTime(0, 0, 0);
            time2.print();
            CorrectTime time3 = new CorrectTime(-12, 12, 12);
            CorrectTime time4 = new CorrectTime(23, 1, 60);
            CorrectTime time5 = new CorrectTime(23, 60, 6);
            CorrectTime time6 = new CorrectTime(23, 1, 60);
            CorrectTime time7 = new CorrectTime(24, 1, 6);
            CorrectTime time8 = new CorrectTime(1, 2, 3);
            time8.print();
        }
        catch (IllegalDateException e) {
            System.out.println(e.getMessage());
        }
    }
}
