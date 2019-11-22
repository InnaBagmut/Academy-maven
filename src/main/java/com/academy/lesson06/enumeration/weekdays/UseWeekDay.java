package com.academy.lesson06.enumeration.weekdays;

public class UseWeekDay {
    protected WeekDay today;

    public WeekDay getToday() {
        return today;
    }

    public void setToday(WeekDay today) {
        this.today = today;
    }

    @Override
    public String toString() {
        return "UseWeekDays{" +
                "today=" + today +
                '}';
    }

    public void tryingToResolveTheDayBeforeYesterday(WeekDay direction) {
        //getOneDay() += oneDay;
/*        switch (direction) {
            case MONDAY:
                return "Суббота";
            break;
        }*/
    }

    //trying to implement task through simple if else - you can find more profesional solution in WeekDay file
    public void dayAfterTomorrowOption1() {
        if (today == WeekDay.MONDAY) System.out.println("The day after tomorrow is Wednesday");
        else if (today == WeekDay.TUESDAY) System.out.println("The day after tomorrow is Thursday");
        else System.out.println("The day after tomorrow is undefined");
    }
}
