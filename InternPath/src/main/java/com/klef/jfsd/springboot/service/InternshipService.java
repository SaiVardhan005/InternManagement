package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Internship;

public interface InternshipService {
    List<Internship> getAllInternships();
    Internship getInternshipById(Long id);
    Internship addInternship(Internship internship);
    
    
    
}