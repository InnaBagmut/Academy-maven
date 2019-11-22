package com.academy.lesson07.interfacehomework;

public class Button extends Component {
    //Object object = new Button();
    //Component component = new Button();

    @Override
    public void draw() {
        System.out.println("Draw Button");
    }
    public void push() {
        System.out.println("I can be pushed by user");
    }
}
