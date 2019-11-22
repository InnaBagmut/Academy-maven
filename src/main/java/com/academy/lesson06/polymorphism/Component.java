package com.academy.lesson06.polymorphism;

public class Component {
/*    1)
    a) Создать массив типа Component (10 элементов), элементы которого могут любые потомки этого класса
		(Button, Label, CheckBox, RoundButton - см. иерархию в презентации)
    Component[] components = ...


    b) Наполнить массив:
            (экземплярами классов Button, Label, CheckBox, RoundButton)

    с) В цикле вывести все элемены Componentы на экран
    d) В цикле перебрать массив Component и вывести только Button и его потомков


    Для реализации иерархии классов Component:
            - не использовать abstract (т.е. класс Component и метод draw() - обычный)
            - во всех классах потомках от Component - нужно переопределить метод draw();
	- реализация метода draw() во всех классах, в т.ч. и в Component - вывод на консоль название класса:
    public class Component {
        public void draw() {
            System.out.println("Component");
        }
    }
    public class Button {
        @Override
        public void draw() {
            System.out.println("Button");
        }
    }*/

    public void draw() {
        System.out.println("Component");
    }
    public void show() {
        System.out.println("Display on the screen");
    }
}
