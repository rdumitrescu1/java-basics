package com.griddynamics.app;

import com.griddynamics.model.Course;
import com.griddynamics.model.Curriculum;
import com.griddynamics.model.Student;
import com.griddynamics.report.ReportGenerator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LocalDateTime reportDateTime = LocalDateTime.of(2025, 2, 18, 15, 0);

        int reportType = 0;

//        Scanner scanner = new Scanner(System.in);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy, HH:mm");
//        System.out.println("Enter report date/time (e.g., '17 February 2025, 15:00'):");
//        String dateInput = scanner.nextLine();
//        LocalDateTime reportDateTimeInput;
//        reportDateTimeInput = LocalDateTime.parse(dateInput, formatter);
//
//        System.out.println("Enter report type (0 for short report, any other number for full report):");
//        int reportTypeInput = Integer.parseInt(scanner.nextLine());

        Course javaCourse = new Course("Java", 16);
        Course jdbcCourse = new Course("JDBC", 24);
        Course springCourse = new Course("Spring", 16);
        Curriculum javaCurriculum = new Curriculum("Java Developer",
                List.of(javaCourse, jdbcCourse, springCourse));
        Student student1 = new Student("Ivanov Ivan", javaCurriculum,
                LocalDateTime.of(2025, 2, 10, 10, 0));

        Course testDesign = new Course("Test design", 10);
        Course pageObject = new Course("Page Object", 16);
        Course selenium = new Course("Selenium", 16);
        Curriculum aqeCurriculum = new Curriculum("AQE",
                List.of(testDesign, pageObject, selenium));
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
