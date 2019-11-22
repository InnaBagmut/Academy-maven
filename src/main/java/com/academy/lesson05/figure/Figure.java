package com.academy.lesson05.figure;

import java.util.Objects;
/*Необходимо описать задачу с применением принципов ООП.
        Условие тестовой задачи:
        Дано объекты-фигуры следующих видов: квадрат, треугольник, круг, трапеция. Каждую фигуру можно нарисовать, получить ее площадь и цвет.
        Также фигуры имеют уникальные методы, например: вернуть радиус, длину гипотенузы, длину стороны и т. д.
        Нам необходимо сгенерировать случайный набор фигур, количество объектов в наборе также заранее неизвестно.
        После генерации массива нужно вывести весь список объектов, которые у нас имеются, например:
        Фигура: квадрат, площадь: 25 кв. ед., длина стороны: 5 ед., цвет: синий
        Фигура: треугольник, площадь: 12,5 кв.ед., гипотенуза: 7.1 ед., цвет: желтый*/

public abstract class Figure {
    protected String color;

    public Figure(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double area();

    public void draw() {
        System.out.println("Figure ");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Figure)) return false;
        Figure figure = (Figure) o;
        //return color.equals(figure.color);
        return Objects.equals(color, figure.color);
    }

   @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return "Figure{" +
                "color='" + color + '\'' +
                '}';
    }
}
