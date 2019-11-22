package com.academy.lesson05.figure;

public class Ttriangle extends Figure {

    private double side1;
    private double side2;
    private double side3;
    private double height;

    public Ttriangle(String color) {
        super(color);
    }

    public Ttriangle(double side1, double height, String color) {
        super(color);
        this.side1 = side1;
        this.height = height;
    }

    public Ttriangle(String color, double side1, double side2, double side3, double height) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.height = height;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double area() {
        return side1 * height / 2;
    }

    @Override
    public void draw() {
        System.out.println(String.format("This is a Triangle with sides %.2f, %.2f, %.2f and color is %s", side1, side2, side3, color));
    }
}
