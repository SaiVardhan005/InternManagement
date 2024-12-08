package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.jfsd.springboot.dto.EnrolledInternshipDetails;
import com.klef.jfsd.springboot.model.EnrolledInternship;
import com.klef.jfsd.springboot.service.EnrollmentService;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin(origins = "http://localhost:3000")
public class EnrollmentController {

	 @Autowired
	    private EnrollmentService enrollmentService;

	    @PostMapping
	    public ResponseEntity<?> enrollInternship(@RequestBody EnrollmentRequest request) {
	        if (request.getInternshipId() == null || request.getUserId() == null) {
	            return ResponseEntity.badRequest().body("Invalid request: Missing internshipId or userId");
	        }
	        
	        // Debug logs
	        System.out.println("Internship ID: " + request.getInternshipId());
	        System.out.println("User ID: " + request.getUserId());

	        try {
	            enrollmentService.enrollInternship(request.getInternshipId(), request.getUserId());
	            return ResponseEntity.ok("Successfully enrolled for the internship!");
	        } catch (RuntimeException e) {
	            // Return error message if user is already enrolled
	            return ResponseEntity.status(400).body("Error: " + e.getMessage());
	        } catch (Exception e) {
	            return ResponseEntity.status(500).body("Failed to enroll for the internship. Error: " + e.getMessage());
	        }
	    }

	    @GetMapping("/user/{userId}")
	    public ResponseEntity<?> getEnrolledInternships(@PathVariable Long userId) {
	        try {
	            List<EnrolledInternshipDetails> enrolledInternships = enrollmentService.getEnrolledInternshipsByUserId(userId);
	            return ResponseEntity.ok(enrolledInternships);
	        } catch (Exception e) {
	            return ResponseEntity.status(500).body("Failed to fetch enrolled internships. Error: " + e.getMessage());
	        }
	    }
}

class EnrollmentRequest {
    private Long internshipId;
    private Long userId;

    public Long getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(Long internshipId) {
        this.internshipId = internshipId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
