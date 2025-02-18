package com.griddynamics.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import org.junit.jupiter.api.function.Executable;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class WorkingTimeUtilsTest {
    @ParameterizedTest
    @CsvSource({
            "2025-02-10T10:00, 8",
            "2025-02-10T11:00, 7",
            "2025-02-10T15:30, 2",
            "2025-02-10T17:00, 1",
            "2025-02-10T17:59, 0"
    })
    void shouldReturnRemainingWorkHours(String dateTimeStr, long expectedRemainingHours) {
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr);
        long remainingWorkHours = WorkingTimeUtils.getRemainingWorkHours(dateTime);
        assertEquals(expectedRemainingHours, remainingWorkHours);
    }
    @Test
    void shouldReturnNextWorkingDay() {
        LocalDateTime dateTime = LocalDateTime.of(2025, 2, 14, 18, 0);
        LocalDateTime nextWorkingDay = WorkingTimeUtils.nextWorkingDay(dateTime);
        assertEquals(LocalDateTime.of(2025, 2, 17, 10, 0), nextWorkingDay);
    }
}