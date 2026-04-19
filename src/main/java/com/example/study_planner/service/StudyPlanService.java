package com.example.study_planner.service;

import com.example.study_planner.dto.SubjectRequestDTO;
import com.example.study_planner.dto.SubjectResponseDTO;
import com.example.study_planner.entity.Subject;
import com.example.study_planner.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;

@Service
public class StudyPlanService {

    private final SubjectRepository subjectRepository;

    public StudyPlanService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    // 🔥 Convert Entity → DTO
    private SubjectResponseDTO mapToDTO(Subject subject) {
        return new SubjectResponseDTO(
                subject.getId(),
                subject.getName(),
                subject.getDifficulty(),
                subject.getExamDate(),
                subject.isCompleted()
        );
    }

    // ✅ ADD SUBJECT
    public SubjectResponseDTO addSubject(SubjectRequestDTO dto) {

        Subject subject = new Subject();
        subject.setName(dto.getName());
        subject.setDifficulty(dto.getDifficulty());
        subject.setExamDate(dto.getExamDate());
        subject.setCompleted(false);

        return mapToDTO(subjectRepository.save(subject));
    }

    // ✅ GET ALL
    public List<SubjectResponseDTO> getAllSubjects() {
        return subjectRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // ✅ UPDATE
    public SubjectResponseDTO updateSubject(Long id, SubjectRequestDTO dto) {

        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        subject.setName(dto.getName());
        subject.setDifficulty(dto.getDifficulty());
        subject.setExamDate(dto.getExamDate());

        return mapToDTO(subjectRepository.save(subject));
    }

    // ✅ COMPLETE
    public SubjectResponseDTO markComplete(Long id) {

        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        subject.setCompleted(true);

        return mapToDTO(subjectRepository.save(subject));
    }

    // ✅ DELETE
    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }

    // ✅ PRIORITY LOGIC
    public double calculatePriority(Subject subject) {

        long daysLeft = ChronoUnit.DAYS.between(
                LocalDate.now(),
                subject.getExamDate()
        );

        if (daysLeft <= 0) daysLeft = 1;

        return subject.getDifficulty() * (1.0 / daysLeft);
    }

    // ✅ GET PRIORITY LIST
    public List<SubjectResponseDTO> getPrioritySubjects() {

        List<Subject> subjects = subjectRepository.findAll();

        subjects.sort(
                Comparator.comparingDouble(this::calculatePriority).reversed()
        );

        return subjects.stream()
                .map(this::mapToDTO)
                .toList();
    }
}