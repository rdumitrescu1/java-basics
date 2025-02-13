import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        LocalDateTime reportDateTime = LocalDateTime.of(2025, 2, 17, 15, 0);;
        int reportType = 0;

        Course javaCourse = new Course("Java", 16);
        Course jdbcCourse = new Course("JDBC", 24);
        Course springCourse = new Course("Spring", 16);
        Curriculum javaCurriculum = new Curriculum("Java Developer",
                Arrays.asList(javaCourse, jdbcCourse, springCourse));
        Student student1 = new Student("Ivanov Ivan", javaCurriculum,
                LocalDateTime.of(2025, 2, 10, 10, 0));

        Course testDesign = new Course("Test design", 10);
        Course pageObject = new Course("Page Object", 16);
        Course selenium = new Course("Selenium", 16);
        Curriculum aqeCurriculum = new Curriculum("AQE",
                Arrays.asList(testDesign, pageObject, selenium));
        Student student2 = new Student("Sidorov Ivan", aqeCurriculum,
                LocalDateTime.of(2025, 2, 10, 10, 0));

        if (reportType == 0) {
            System.out.println("Short Report (Generated on: " +
                    reportDateTime.format(DateTimeFormatter.ofPattern("d MMMM yyyy, EEEE, HH:mm")) + "):");
            ReportGenerator.generateShortReport(student1, reportDateTime);
            ReportGenerator.generateShortReport(student2, reportDateTime);
        } else {
            System.out.println("Full Report (Generated on: " +
                    reportDateTime.format(DateTimeFormatter.ofPattern("d MMMM yyyy, EEEE, HH:mm")) + "):");
            ReportGenerator.generateFullReport(student1, reportDateTime);
            System.out.println();
            ReportGenerator.generateFullReport(student2, reportDateTime);
        }
    }
}
