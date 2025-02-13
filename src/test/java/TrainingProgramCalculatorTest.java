import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TrainingProgramCalculatorTest {

    @Test
    void shouldCalculateCompletionDate() {
        LocalDateTime startDateTime = LocalDateTime.of(2025, 2, 10, 10, 0);
        int totalTrainingHours = 48;

        LocalDateTime completionDate = TrainingProgramCalculator.calculateCompletionDate(startDateTime, totalTrainingHours);
        LocalDateTime expectedCompletionDate = LocalDateTime.of(2025, 2, 17, 18, 0);

        assertEquals(expectedCompletionDate, completionDate);
    }

}