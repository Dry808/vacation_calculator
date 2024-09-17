package ru.neostudy.neoflex.util;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Утилитарный класс для определения рабочих дней
 */
public class DateUtil {

    public static boolean isWorkingDay(LocalDate date) {
        return date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY;
    }
}