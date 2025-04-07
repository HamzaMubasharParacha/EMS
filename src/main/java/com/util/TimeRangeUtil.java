package com.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeRangeUtil {

    public static LocalDateTime[] getTodayRange() {
        LocalDate today = LocalDate.now();
        return new LocalDateTime[] {
                today.atStartOfDay(),
                today.plusDays(1).atStartOfDay().minusNanos(1)
        };
    }

    public static LocalDateTime[] getThisMonthRange() {
        LocalDate today = LocalDate.now();
        LocalDate start = today.withDayOfMonth(1);
        LocalDate end = start.plusMonths(1).minusDays(1);
        return new LocalDateTime[] {
                start.atStartOfDay(),
                end.plusDays(1).atStartOfDay().minusNanos(1)
        };
    }

    public static LocalDateTime[] getMonthRange(int year, int month) {
        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.plusMonths(1).minusDays(1);
        return new LocalDateTime[] {
                start.atStartOfDay(),
                end.plusDays(1).atStartOfDay().minusNanos(1)
        };
    }
}

