package com.academy.lesson05.date;

public class TestDate {
    /*    2) Протестировать классы Date, DateTime и DateTimeExt:
                - все конструкторы
            - метод toString()
            - метод equals()
            - все методы next...()
                - checkData, checkTime*/
    public static void main(String[] args) {
        testDate();
        testDateTime();
        testDateTimeExt();
    }

    public static void testDate() {
        System.out.println("======================================================");
        System.out.println("Data tests: ");
        Date myObject1 = new Date();
        myObject1.print();
        System.out.println(myObject1);

        Date myObject2 = new Date(24, 02, 1990);
        myObject2.print();
        System.out.println("myObject2: " + myObject2);
        Date myObject3 = new Date(24, 02, 1990);
        Date myObject4 = new Date(25, 02, 1990);
        System.out.println("Compare 2 and 3: " + myObject2.equals(myObject3));
        System.out.println("Compare 2 and 4: " + myObject2.equals(myObject4));

        myObject4.setDay(24);
        int dayActual = myObject4.getDay();
        int dayExpected = 25;
        if(dayActual == dayExpected) System.out.println("Test passed");
        else System.out.println("Test failed");
    }

    public static void testDateTime() {
        System.out.println("======================================================");
        System.out.println("Data + Time tests: ");
        DateTime myObject1 = new DateTime();
        myObject1.print();
        System.out.println(myObject1);

        DateTime myObject2 = new DateTime(23, 12, 1993, 12, 44, 55);
        myObject2.print();
        System.out.println("myObject2: " + myObject2);
        DateTime myObject3 = new DateTime(23, 12, 1993, 12, 44, 55);
        DateTime myObject4 = new DateTime(23, 12, 1993, 12, 44, 56);
        System.out.println("Compare 2 and 3: " + myObject2.equals(myObject3));
        System.out.println("Compare 2 and 4: " + myObject2.equals(myObject4));
    }

    public static void testDateTimeExt() {
        System.out.println("======================================================");
        System.out.println("Data + Time + Milliseconds tests: ");
        DateTimeExt myObject1 = new DateTimeExt();
        myObject1.print();
        System.out.println(myObject1);

        DateTimeExt myObject2 = new DateTimeExt(23, 12, 1993, 12, 44, 55, 789);
        myObject2.print();
        System.out.println("myObject2: " + myObject2);
        DateTimeExt myObject3 = new DateTimeExt(23, 12, 1993, 12, 44, 55, 789);
        DateTimeExt myObject4 = new DateTimeExt(23, 12, 1993, 12, 44, 55, 788);
        System.out.println("Compare 2 and 3: " + myObject2.equals(myObject3));
        System.out.println("Compare 2 and 4: " + myObject2.equals(myObject4));

        System.out.println("Compare actual and expected MS:");
        myObject2.setMilliseconds(788);
        int msActual = myObject2.getMilliseconds();
        int msExpected = 788;
        if(msActual == msExpected) System.out.println("Test passed");
        else System.out.println("Test failed");

    }
}
