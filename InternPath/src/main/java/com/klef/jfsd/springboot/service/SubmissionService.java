package com.klef.jfsd.springboot.service;

import com.klef.jfsd.springboot.model.Submission;
import com.klef.jfsd.springboot.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;

    public void saveSubmission(Submission submission) {
        submissionRepository.save(submission);
    }
}
