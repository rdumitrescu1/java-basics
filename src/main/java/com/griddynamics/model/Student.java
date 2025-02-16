package com.griddynamics.model;

import java.time.LocalDateTime;

public class Student {
    private String name;
    private Curriculum curriculum;
    private LocalDateTime startDateTime;

    public Student(String name, Curriculum curriculum, LocalDateTime startDateTime) {
        this.name = name;
        this.curriculum = curriculum;
        this.startDateTime = startDateTime;
    }

    public String getName() {
        return name;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }
}
