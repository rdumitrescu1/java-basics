package com.griddynamics.report;

import com.griddynamics.model.Student;
import com.griddynamics.service.TrainingProgramCalculator;
import com.griddynamics.util.WorkingTimeUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportGenerator {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d MMMM yyyy, EEEE, HH:mm");

    public static void generateShortReport(Student student, LocalDateTime reportDateTime) {

        LocalDateTime completionDate = TrainingProgramCalculator.calculateCompletionDate(
                student.getStartDateTime(), student.getCurriculum().getTotalDuration());

        System.out.print(student.getName() + " (" + student.getCurriculum().getProgramName() + ") - ");
        if (reportDateTime.isBefore(completionDate)) {
            Duration diff = Duration.between(reportDateTime, completionDate);
            long days = diff.toDays();
            long hours = diff.minusDays(days).toHours();
            System.out.println("Training is not finished. " + days + " d " + hours + " hours are left until the end.");
        }
        else {
            Duration diff = Duration.between(completionDate, reportDateTime);
            long days = diff.toDays();
            long hours = diff.minusDays(days).toHours();
            System.out.println("Training completed. " + days + " d " + hours + " hours have passed since the end.");
        }
    }

    public static void generateFullReport(Student student, LocalDateTime reportDateTime) {

        LocalDateTime completionDate = TrainingProgramCalculator.calculateCompletionDate(
                student.getStartDateTime(), student.getCurriculum().getTotalDuration());

        System.out.println("Student: " + student.getName());
        System.out.println("Program: " + student.getCurriculum().getProgramName());
        System.out.println("Working Hours: " + WorkingTimeUtils.WORK_START + " - " + WorkingTimeUtils.WORK_END);
        System.out.println("Total Duration: " + student.getCurriculum().getTotalDuration() + " hours");
        System.out.println("Start Date: " + student.getStartDateTime().format(FORMATTER));
        System.out.println("Completion Date: " + completionDate.format(FORMATTER));

        if (reportDateTime.isBefore(completionDate)) {
            Duration diff = Duration.between(reportDateTime, completionDate);
            long days = diff.toDays();
            long hours = diff.minusDays(days).toHours();
            System.out.println("Training is not finished. " + days + " d " + hours + " hours remain.");
        } else {
            Duration diff = Duration.between(completionDate, reportDateTime);
            long days = diff.toDays();
            long hours = diff.minusDays(days).toHours();
            System.out.println("Training completed. " + days + " d " + hours + " hours have passed.");
        }
    }
}
