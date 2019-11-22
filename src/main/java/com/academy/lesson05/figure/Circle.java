package com.academy.lesson05.figure;

import java.util.Objects;

public class Circle extends Figure {
    private double radius;
    // private String color;

    public Circle(double radius) {
        super("green");
        this.radius = radius;
    }

    public Circle(int radius, String color) {
        super(color);
        this.radius = radius;
    }


    /*   public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }*/

    public double getRadius() {
        return radius;
    }

    /*    public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }*/
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println(String.format("This is a Circle with radius %.2f and color is %s", radius, color));
    }



/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius);
    }
}
