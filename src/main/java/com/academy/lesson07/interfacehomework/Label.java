package com.academy.lesson07.interfacehomework;

public class Label extends Component {
    @Override
    public void draw() {
        System.out.println("Draw Label");
    }
    @Override
     public void draw3D() {
        System.out.println("3D draw of the label");
    }
}
