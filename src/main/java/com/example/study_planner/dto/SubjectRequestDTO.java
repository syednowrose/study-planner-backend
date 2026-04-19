package com.example.study_planner.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class SubjectRequestDTO {

    @NotBlank(message = "Subject name cannot be empty")
    private String name;

    @Min(value = 1, message = "Difficulty must be at least 1")
    @Max(value = 5, message = "Difficulty cannot be more than 5")
    private int difficulty;

    @Future(message = "Exam date must be in the future")
    private LocalDate examDate;

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }
}