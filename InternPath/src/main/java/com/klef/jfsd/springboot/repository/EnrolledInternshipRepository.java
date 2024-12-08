package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.dto.EnrolledInternshipDetails;
import com.klef.jfsd.springboot.model.EnrolledInternship;
import java.util.List;
import java.util.Optional;

@Repository

public interface EnrolledInternshipRepository extends JpaRepository<EnrolledInternship, Long> {
    @Query("SELECT new com.klef.jfsd.springboot.dto.EnrolledInternshipDetails(e.id, i.id, i.title, i.company, i.location, i.description, i.startDate, i.endDate, i.stipend, e.enrolledDate) " +
           "FROM EnrolledInternship e " +
           "JOIN Internship i ON e.internshipId = i.id " +
           "WHERE e.userId = :userId")
    List<EnrolledInternshipDetails> findDetailedEnrollmentsByUserId(@Param("userId") Long userId);
    
    // Add method to check for existing enrollment
    Optional<EnrolledInternship> findByUserIdAndInternshipId(Long userId, Long internshipId);
}