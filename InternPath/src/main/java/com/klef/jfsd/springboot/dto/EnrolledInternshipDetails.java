package com.klef.jfsd.springboot.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class EnrolledInternshipDetails {
    private Long enrollmentId;
    private Long internshipId;
    private String title;
    private String company;
    private String location;
    private String description;
    private Date startDate;
    private Date endDate;
    private String stipend;
    private LocalDateTime enrolledDate;

    public EnrolledInternshipDetails(Long enrollmentId, Long internshipId, String title, String company, String location,
                                     String description, Date startDate, Date endDate, String stipend, LocalDateTime enrolledDate) {
        this.enrollmentId = enrollmentId;
        this.internshipId = internshipId;
        this.title = title;
        this.company = company;
        this.location = location;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.stipend = stipend;
        this.enrolledDate = enrolledDate;
    }

    // Getters and setters
    public Long getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(Long enrollmentId) { this.enrollmentId = enrollmentId; }
    public Long getInternshipId() { return internshipId; }
    public void setInternshipId(Long internshipId) { this.internshipId = internshipId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
    public String getStipend() { return stipend; }
    public void setStipend(String stipend) { this.stipend = stipend; }
    public LocalDateTime getEnrolledDate() { return enrolledDate; }
    public void setEnrolledDate(LocalDateTime enrolledDate) { this.enrolledDate = enrolledDate; }
}
