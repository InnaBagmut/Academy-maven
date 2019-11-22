package com.academy.lesson06.polymorphism;

public class ComponentDemo {
    public static void main(String[] args) {
        System.out.println("Test component: ");
        Component testComponent = new Component();
        testComponent.show();
        testComponent.draw();

        System.out.println("Test button: ");
        Button testButton1 = new Button();
        testButton1.push();

        System.out.println("==================================");
        System.out.println("Full array: ");

        Component[] componentsArray = {new Button(), new RoundButton(), new CheckBox(), new Label()};
        componentsArray[1].draw();

        for (int i = 0; i < componentsArray.length; i++) {
            componentsArray[i].draw();
        }

        System.out.println("==================================");
        System.out.println("And only Button and her inheritors in array:");
        for (int i = 0; i < componentsArray.length; i++) {
            if (componentsArray[i] instanceof Button) componentsArray[i].draw();
        }
        Object object = new Object();
        Object objectButton = new Button();

        System.out.println("==================================");
        System.out.println("Solution what to do: ");

        if (componentsArray[3] instanceof Button)
            ((Button) componentsArray[3]).push();
        else componentsArray[3].show();
    }
}
