package com.klef.jfsd.springboot.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "enrolled_internships")
public class EnrolledInternship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getInternshipId() {
		return internshipId;
	}

	public void setInternshipId(Long internshipId) {
		this.internshipId = internshipId;
	}

	public LocalDateTime getEnrolledDate() {
		return enrolledDate;
	}

	public void setEnrolledDate(LocalDateTime enrolledDate) {
		this.enrolledDate = enrolledDate;
	}

	@Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "internship_id", nullable = false)
    private Long internshipId;

    @Column(name = "enrolled_date", nullable = false)
    private LocalDateTime enrolledDate;

    // Getters and setters
}
