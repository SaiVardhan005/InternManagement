package com.klef.jfsd.springboot.dto;

public class TaskDTO {

    private String url; // URL for the task
    private String question; // The description or question for the task
    private Long internshipId; // The ID of the associated internship

    // Getters and setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(Long internshipId) {
        this.internshipId = internshipId;
    }
}
