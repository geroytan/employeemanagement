package com.example.employee_management.controller;

import com.example.employee_management.model.Project;
import com.example.employee_management.repo.ProjectRepo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")

public class ProjectController {

    private final ProjectRepo projectRepository;

    public ProjectController(ProjectRepo projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(projectRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        return ResponseEntity.ok(projectRepository.save(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project updatedProject) {
        try {
            return projectRepository.findById(id).map(project -> {
                project.setName(updatedProject.getName());
                project.setEmployees(updatedProject.getEmployees());
                return ResponseEntity.ok(projectRepository.save(project));
            }).orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        try {
            if (projectRepository.existsById(id)) {
                projectRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

}
