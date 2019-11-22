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
import com.academy.lesson05.date.DateTime;

public class CorrectTime extends DateTime {

    public CorrectTime(int hour, int minute, int second) throws IllegalDateException {
        super(hour, minute, second);
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59 || second < 0 || second > 59) throw new IllegalDateException("Incorrect value");
    }
}
