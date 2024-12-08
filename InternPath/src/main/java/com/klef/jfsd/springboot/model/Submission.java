package com.klef.jfsd.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "submissions")
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "internship_id", nullable = false)
    private Long internshipId;

    @Lob
    @Column(name = "submission_file", nullable = false)
    private byte[] submissionFile; // Updated to match "submission_file"

    @Column(name = "file_name", nullable = false)
    private String fileName;

    // Getters and Setters
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

    public byte[] getSubmissionFile() {
        return submissionFile;
    }

    public void setSubmissionFile(byte[] submissionFile) {
        this.submissionFile = submissionFile;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
