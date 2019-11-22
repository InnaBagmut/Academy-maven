package com.academy.lesson05.figure;

public class TestFigure {
    public static void main(String[] args) {
        testSquare();
        testTriangle();
        testCircle();
        testTrapezoid();

        System.out.println("=================================================");
        System.out.println("This is an array:");
        Figure[] figuresArray = {new Ttriangle(23, 55, "White"),
                new Trapezoid(34, 12, 65.234, "Purple"),
                new Square(45.56765, "Black"),
                new Circle(77, " Yellow"),
                new Trapezoid(12, 45, 76, "Transparent"),
                new Ttriangle(23, 54, "Green"),
                new Circle(56, "Pink")};
        for (int i = 0; i < figuresArray.length; i++) {
            if (figuresArray[i] instanceof Circle)
                figuresArray[i].draw();
        }
    }

    @Override
    public String toString() {
        return "TestFigure{}";
    }

    public static void testSquare() {

        System.out.println("==================================================");
        System.out.println("Test Square:");
        Square myObject1 = new Square(3); // black
        Square myObject2 = new Square(5, "Orange");
        Square myObject3 = new Square(5, "Orange");
        myObject2.getColor();  // Этот метод берется из базового класса

        double sideActual = myObject1.getSide();
        double sideExpected = 5;
        double areaActual = myObject1.area();
        double areaExpected = 9;

        if (areaActual == areaExpected)
            System.out.println("Test passed");
        else System.out.println("Test failed");

        myObject1.setSide(6);
        myObject1.draw();

        System.out.println(myObject2);
        System.out.println(myObject2.equals(myObject3));
    }

    public static void testTriangle() {

        System.out.println("==================================================");
        System.out.println("Test Triangle:");
        Ttriangle myObject1 = new Ttriangle(23.55, 563.43, "Brown");
        myObject1.draw();

    }

    public static void testCircle() {

        System.out.println("==================================================");
        System.out.println("Test Circle:");

        Circle myObject1 = new Circle(5);
        double areaActual = myObject1.area();
        double areaExpected = Math.PI * 25;
        System.out.println(areaActual == areaExpected);
        Circle myObject2 = new Circle(5); // ссылки у проектов разные

        System.out.println(myObject1);
        System.out.println(myObject1.equals(myObject2));
        Circle myObject3 = new Circle(10, "Violet");
        myObject3.draw();

    }

    public static void testTrapezoid() {

        System.out.println("==================================================");
        System.out.println("Test Trapezoid:");
        Trapezoid myObject1 = new Trapezoid("Blue");
        myObject1.setUpperBase(10);
        myObject1.setLowerBase(10);
        myObject1.setHeight(10);
        System.out.println(myObject1);
        System.out.println(myObject1.area());
        double heightActual = myObject1.getHeight();
        double heightExpected = 10;
        if (heightActual == heightExpected) System.out.println("Test passed");
        else System.out.println("Test failed");
        System.out.println("HeightActual: " + heightActual);

        Trapezoid myObject2 = new Trapezoid(23.34253, 4534.32432, 324.234, "Grey");
        myObject2.draw();
    }
}
