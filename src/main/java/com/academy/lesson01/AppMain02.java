package com.academy.lesson01;

public class AppMain02 {
    public static void main(String[] args) {
        if (args.length == 1) {
            String name = args[0];
            System.out.println("Hello " + name + "!");
        } else
            System.out.println("Hello!");
    }
}
// не ясна логика задачи, и команда java -cp ./out/ com.academy.lesson01.AppMain02 Peter не сработала по инструкции в директории task
// выполнилась команда java -cp ./out/ com.academy.lesson01.AppMain02 и при запуске jar файла просто вывелось Hello!
