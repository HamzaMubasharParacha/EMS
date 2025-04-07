package com.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;

import org.springframework.stereotype.Component;

@Component
public class TimeRangeUtil {

    public static LocalDateTime[] getTodayRange() {
        LocalDate today = LocalDate.now();
        return new LocalDateTime[]{
                today.atStartOfDay(),
                today.atTime(LocalTime.MAX)
        };
    }

    public static LocalDateTime[] getThisMonthRange() {
        LocalDate today = LocalDate.now();
        YearMonth yearMonth = YearMonth.of(today.getYear(), today.getMonth());
        return new LocalDateTime[]{
                yearMonth.atDay(1).atStartOfDay(),
                yearMonth.atEndOfMonth().atTime(LocalTime.MAX)
        };
    }

    public static LocalDateTime[] getMonthRange(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        return new LocalDateTime[]{
                yearMonth.atDay(1).atStartOfDay(),
                yearMonth.atEndOfMonth().atTime(LocalTime.MAX)
        };
    }
}

