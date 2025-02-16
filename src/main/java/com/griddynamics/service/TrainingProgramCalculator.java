package com.griddynamics.service;

import com.griddynamics.util.WorkingTimeUtils;

import java.time.LocalDateTime;

public class TrainingProgramCalculator {
    public static LocalDateTime calculateCompletionDate(LocalDateTime startDateTime, int totalTrainingHours) {
        LocalDateTime current = startDateTime;
        int remainingHours = totalTrainingHours;

        while (remainingHours > 0) {
            long availableHours = WorkingTimeUtils.getRemainingWorkHours(current);
            if (remainingHours <= availableHours) {
                current = current.plusHours(remainingHours);
                remainingHours = 0;
            } else {
                remainingHours -= availableHours;
                current = WorkingTimeUtils.nextWorkingDay(current);
            }
        }
        return current;
    }
}
