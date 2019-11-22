package com.academy.lesson07.lambdahomework;

public class CheckRange {
    public static void main(String[] args) {
        checkRange();
        CheckInterface myObject1 = new CheckInterface() {
            @Override
            public boolean getTrueOrFalse(double check) {
                //check = 15;
                boolean checkRange1 = false;
                if (check >= 10 && check <= 20)
                    checkRange1 = true;
                else checkRange1 = false;
                return checkRange1;
            }
        };
        System.out.println("My first anonymous method: " + myObject1.getTrueOrFalse(20));

        CheckInterface lambda = d -> d >= 10 && d <= 20;
        boolean checkRange2 = lambda.getTrueOrFalse(20);
        System.out.println("My lambda result: " + checkRange2);

        //System.out.println(lambda.getTrueOrFalse(12));
    }

    public static void checkRange() {
        double x = 25.70076;
        boolean checkRange2 = false;
        if (x >= 10 && x <= 20)
            checkRange2 = true;
        System.out.println(checkRange2);
    }
}
