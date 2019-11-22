package com.academy.lesson07.interfacehomework;

public class Component implements VisualComponent {
/*1) Добавить в иерархию классов Component новый интерфейс VisualComponent
	унаследовать класс Component от VisualComponent
	(Component implements VisualComponent)

	Интерфейс VisualComponent должен иметь один метод:
		- void draw();
		-продемонстрировать работу метода draw() у всех компонентов

2) Добавить новый метод по умолчанию в VisualComponent
		- default void draw3D(); //

	унаследовать класс Component от VisualComponent
		- перекрыть метод draw3D у Label
		- продемонстрировать работу метода draw3D() во всех компонентах */

    @Override
    public void draw() {
        System.out.println("Draw Component");
    }

    @Override
    public void draw3D() {
        System.out.println("3D draw component");
    }

    public void show() {
        System.out.println("Display on the screen");
    }
}
