package com.griddynamics.service;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;

class TrainingProgramCalculatorTest {

    @Test
    void shouldCalculateCompletionDate() {
        LocalDateTime startDateTime = LocalDateTime.of(2025, 2, 10, 10, 0);
        int totalTrainingHours = 48;
        TrainingProgramCalculator trainingProgramCalculator = new TrainingProgramCalculator();
        LocalDateTime completionDate = trainingProgramCalculator.calculateCompletionDate(startDateTime, totalTrainingHours);
        LocalDateTime expectedCompletionDate = LocalDateTime.of(2025, 2, 17, 18, 0);

        assertEquals(expectedCompletionDate, completionDate);
    }
    @Test
    void shouldThrowIllegalArgumentException_when_NegativeTotalTrainingHours() {
        LocalDateTime startDateTime = LocalDateTime.of(2025, 2, 15, 10, 0);
        int totalTrainingHours = -4;
        TrainingProgramCalculator trainingProgramCalculator = new TrainingProgramCalculator();
        Executable executable = () -> trainingProgramCalculator.calculateCompletionDate(startDateTime, totalTrainingHours);
        assertThrows(IllegalArgumentException.class, executable);
    }

}