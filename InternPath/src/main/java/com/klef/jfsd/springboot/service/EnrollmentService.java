package com.klef.jfsd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.dto.EnrolledInternshipDetails;
import com.klef.jfsd.springboot.model.EnrolledInternship;
import com.klef.jfsd.springboot.repository.EnrolledInternshipRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrolledInternshipRepository enrolledInternshipRepository;

    public void enrollInternship(Long internshipId, Long userId) {
        if (internshipId == null || userId == null) {
            throw new IllegalArgumentException("Internship ID and User ID cannot be null");
        }

        // Check if the user has already enrolled in this internship
        if (enrolledInternshipRepository.findByUserIdAndInternshipId(userId, internshipId).isPresent()) {
            throw new RuntimeException("You are already enrolled in this internship.");
        }

        // Proceed with the enrollment
        EnrolledInternship enrollment = new EnrolledInternship();
        enrollment.setInternshipId(internshipId);
        enrollment.setUserId(userId);
        enrollment.setEnrolledDate(LocalDateTime.now());

        enrolledInternshipRepository.save(enrollment);
    }

    public List<EnrolledInternshipDetails> getEnrolledInternshipsByUserId(Long userId) {
        return enrolledInternshipRepository.findDetailedEnrollmentsByUserId(userId);
    }
}

