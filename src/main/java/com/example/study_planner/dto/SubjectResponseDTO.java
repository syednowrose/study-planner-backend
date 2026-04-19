package com.example.study_planner.dto;

import java.time.LocalDate;

public class SubjectResponseDTO {

    private Long id;
    private String name;
    private int difficulty;
    private LocalDate examDate;
    private boolean completed;

    public SubjectResponseDTO(Long id, String name, int difficulty,
                              LocalDate examDate, boolean completed) {
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
        this.examDate = examDate;
        this.completed = completed;
    }

    // Getters only (no setters for response)

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public boolean isCompleted() {
        return completed;
    }
}
