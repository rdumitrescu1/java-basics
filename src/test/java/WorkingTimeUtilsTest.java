import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class WorkingTimeUtilsTest {
    @Test
    void shouldReturnRemainingWorkHours() {
        LocalDateTime dateTime = LocalDateTime.of(2025, 2, 10, 10, 0);
        long remainingWorkHours = WorkingTimeUtils.getRemainingWorkHours(dateTime);
        assertEquals(8, remainingWorkHours);
    }
    @Test
    void shouldReturnNextWorkingDay() {
        LocalDateTime dateTime = LocalDateTime.of(2025, 2, 10, 18, 0);
        LocalDateTime nextWorkingDay = WorkingTimeUtils.nextWorkingDay(dateTime);
        assertEquals(LocalDateTime.of(2025, 2, 11, 10, 0), nextWorkingDay);
    }

}