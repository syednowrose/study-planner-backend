package com.example.study_planner.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int difficulty;

    private LocalDate examDate;

    private boolean completed;

    // 🔹 GETTERS

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

    // 🔹 SETTERS

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}