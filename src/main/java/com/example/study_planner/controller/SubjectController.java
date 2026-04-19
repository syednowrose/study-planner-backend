package com.example.study_planner.controller;

import com.example.study_planner.dto.SubjectRequestDTO;
import com.example.study_planner.dto.SubjectResponseDTO;
import com.example.study_planner.service.StudyPlanService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
@CrossOrigin
public class SubjectController {

    private final StudyPlanService studyPlanService;

    // Constructor Injection
    public SubjectController(StudyPlanService studyPlanService) {
        this.studyPlanService = studyPlanService;
    }

    // ✅ Add Subject
    @PostMapping
    public SubjectResponseDTO addSubject(
            @Valid @RequestBody SubjectRequestDTO dto) {
        return studyPlanService.addSubject(dto);
    }

    // ✅ Get All Subjects
    @GetMapping
    public List<SubjectResponseDTO> getAllSubjects() {
        return studyPlanService.getAllSubjects();
    }

    // ✅ Get Priority Subjects
    @GetMapping("/priority")
    public List<SubjectResponseDTO> getPrioritySubjects() {
        return studyPlanService.getPrioritySubjects();
    }

    // ✅ Update Subject
    @PutMapping("/{id}")
    public SubjectResponseDTO updateSubject(
            @PathVariable Long id,
            @Valid @RequestBody SubjectRequestDTO dto) {
        return studyPlanService.updateSubject(id, dto);
    }

    // ✅ Mark as Completed
    @PutMapping("/{id}/complete")
    public SubjectResponseDTO markComplete(@PathVariable Long id) {
        return studyPlanService.markComplete(id);
    }

    // ✅ Delete Subject
    @DeleteMapping("/{id}")
    public String deleteSubject(@PathVariable Long id) {
        studyPlanService.deleteSubject(id);
        return "Deleted successfully";
    }
}