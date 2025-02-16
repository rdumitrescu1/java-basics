package com.griddynamics.model;

import java.util.List;

public class Curriculum {
    private String programName;
    private List<Course> courses;
    private int totalDurationInHours;

    public Curriculum(String programName, List<Course> courses) {
        this.programName = programName;
        this.courses = courses;
        this.totalDurationInHours = calculateTotalDuration(courses);
    }

    private int calculateTotalDuration(List<Course> courses) {
        int sum = 0;
        for (Course course : courses) {
            sum += course.getDuration();
        }
        return sum;
    }

    public String getProgramName() {
        return programName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public int getTotalDuration() {
        return totalDurationInHours;
    }
}
