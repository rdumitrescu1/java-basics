import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Duration;

public class WorkingTimeUtils {
    public static final LocalTime WORK_START = LocalTime.of(10, 0);
    public static final LocalTime WORK_END = LocalTime.of(18, 0);

    public static long getRemainingWorkHours(LocalDateTime dateTime) {
        return Duration.between(dateTime.toLocalTime(), WORK_END).toHours();
    }

    public static LocalDateTime nextWorkingDay(LocalDateTime dateTime) {
        LocalDateTime next = dateTime.plusDays(1).with(WORK_START);
        if (dateTime.getDayOfWeek() == DayOfWeek.FRIDAY) {
            next = dateTime.plusDays(3).with(WORK_START);
        }
        return next;
    }
}
