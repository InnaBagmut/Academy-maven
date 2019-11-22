package com.academy.lesson06.polymorphism;

public class Button extends Component {
    //Object object = new Button();
    //Component component = new Button();

    @Override
    public void draw() {
        System.out.println("Button");
    }
    public void push() {
        System.out.println("I can be pushed by user");
    }
}
