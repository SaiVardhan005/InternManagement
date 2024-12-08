package com.klef.jfsd.springboot.controller;


import com.klef.jfsd.springboot.dto.InternshipDTO;
import com.klef.jfsd.springboot.exception.ResourceNotFoundException;
import com.klef.jfsd.springboot.model.Internship;
import com.klef.jfsd.springboot.model.Task;
import com.klef.jfsd.springboot.service.InternshipService;
import com.klef.jfsd.springboot.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/internships")
@CrossOrigin(origins = "http://localhost:3000")
public class InternshipController {

    @Autowired
    private InternshipService internshipService;

    // Get all internships - using DTO
    @GetMapping
    public List<InternshipDTO> getAllInternships() {
        List<Internship> internships = internshipService.getAllInternships();
        List<InternshipDTO> internshipDTOs = internships.stream()
                .map(internship -> new InternshipDTO(internship.getId(), internship.getTitle())) // map to DTO
                .collect(Collectors.toList());
        return internshipDTOs;
    }

    // Add a new internship
    @PostMapping
    public Internship addInternship(@RequestBody Internship internship) {
        return internshipService.addInternship(internship);
    }

    // Get internship details by ID
    @GetMapping("/{id}")
    public ResponseEntity<Internship> getInternshipById(@PathVariable Long id) {
        Internship internship = internshipService.getInternshipById(id);
        if (internship != null) {
            // Ensure tasks are loaded
            internship.getTasks().size(); // This forces Hibernate to load tasks
            return ResponseEntity.ok(internship);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}