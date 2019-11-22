package com.academy.lesson05.figure;

public class Trapezoid extends Figure {
    private double upperBase;
    private double lowerBase;
    private double height;
    private double side1;
    private double side2;


    public Trapezoid(String color) {
        super(color);
    }

    public Trapezoid(double upperBase, double lowerBase, double height, String color) {
        super(color);
        this.upperBase = upperBase;
        this.lowerBase = lowerBase;
        this.height = height;
    }

    public Trapezoid(double upperBase, double lowerBase, double side1, double side2, double height, String color) {
        super(color);
        this.upperBase = upperBase;
        this.lowerBase = lowerBase;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;

    }

    public double getUpperBase() {
        return upperBase;
    }

    public void setUpperBase(double upperBase) {
        this.upperBase = upperBase;
    }

    public double getLowerBase() {
        return lowerBase;
    }

    public void setLowerBase(double lowerBase) {
        this.lowerBase = lowerBase;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
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

    @Override
    public double area() {
        return (upperBase + lowerBase) * height / 2;
    }

    @Override
    public void draw() {
        System.out.println(String.format("Trapezoid with bases %.2f, %.2f, height %.2f and color = %s", upperBase, lowerBase, height, color));
    }

    @Override
    public String toString() {
        return "Trapezoid{" +
                "upperBase=" + upperBase +
                ", lowerBase=" + lowerBase +
                ", height=" + height +
                ", side1=" + side1 +
                ", side2=" + side2 +
                ", color='" + color + '\'' +
                '}';
    }
}
