package com.academy.lesson06.enumeration.seasons;

public enum Season {

/*2) Перечисление для представления сезона*
    Создать перечисление "Сезон".
    Описать метод получения предыдущего и последующего сезона.
    Протестировать перечисление в функции main() тестового класса.*/

    SPRING,
    SUMMER,
    AUTUMN,
    WINTER;

    Season next() {
        int index = ordinal() + 1;
        Season season = values()[index];
        return season;
    }

    Season previous() {
        int index = ordinal() - 1;
        Season season = values()[index];
        return season;
    }
}
