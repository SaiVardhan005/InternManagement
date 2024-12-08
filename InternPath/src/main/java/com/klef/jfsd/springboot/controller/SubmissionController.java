package com.klef.jfsd.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;

import com.klef.jfsd.springboot.model.Submission;
import com.klef.jfsd.springboot.repository.SubmissionRepository;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {

    @Autowired
    private SubmissionRepository submissionRepository;

    @PostMapping
    public ResponseEntity<?> submitTask(
        @RequestParam("file") MultipartFile file,
        @RequestParam("internshipId") Long internshipId,
        @RequestParam("userId") Long userId) {
        
        try {
            Submission submission = new Submission();
            submission.setUserId(userId); // Set user ID
            submission.setInternshipId(internshipId); // Set internship ID
            submission.setFileName(file.getOriginalFilename()); // Set file name
            submission.setSubmissionFile(file.getBytes()); // Set file content
            
            // Save the submission to the database
            submissionRepository.save(submission);
            
            return ResponseEntity.ok("Task submitted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error submitting task: " + e.getMessage());
        }
    }
}
