package com.academy.lesson04;

public class TestCurrency {
/*    Реализовать класс TestCurrency, который тестирует функционал класса Currency из предыдущей задачи:
            - проверить работу конструкторов
	- проверить работу методов сложения, вычитаня, деления и умножения
	- проверить работу метода isEqual
    Напр. метод тестирования сложения может иметь следующую сигнатуру:
    public boolean testSum() {
        // код теста...
        return true; // eсли тест успешный или 'false', если не успешный
    }

	- все тесты запускаются в функции main
	- каждые тест - отдельная функция - void testIsEqual(), void testDefaultConstructor() и т.д.
	- в процессе тестирования выводить информацию о ходе теста на консоль: какие данные тестируем и результат, напр.:
    test sum '25грн' and '10грн'
    expected '35грн' actual '35грн' - passed
            или
    expected '35грн' actual '25грн' - fail

	- в конце вывести отчет:
    passed: 10
    failure: 0

            - * реализовать возможность запускать выборочно тесты в диалоговом режиме (или через аргумент командной строки)*/

    public static void main(String[] args) {
        Currency myObject1 = new Currency(10, "$");
        myObject1.print();
        Currency myObject2 = new Currency(5, "$");
        myObject2.print();
        myObject1.sum(myObject2);
        myObject1.print();
        Currency myObject3 = new Currency(5, "hrn");
        myObject3.print();
        myObject1.sum(myObject3);
    }
}
