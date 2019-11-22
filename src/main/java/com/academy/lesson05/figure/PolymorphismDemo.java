package com.academy.lesson05.figure;

public class PolymorphismDemo {
    public static void main(String[] args) {
        Figure[] figures = {new Circle(34, "green"),
                new Square(65, "Orange"),
                new Trapezoid(34, 76, 32, "Purple"),
                new Ttriangle(32, 12, "Transparent"),
                new Circle(43, "Blue")};
        figures[0].draw();
        for (int i = 0; i < figures.length; i++) {
            if(figures[i] instanceof Circle)
            figures[i].draw();
        }


    }

}
