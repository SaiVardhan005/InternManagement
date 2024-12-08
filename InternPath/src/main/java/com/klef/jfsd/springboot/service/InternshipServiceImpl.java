package com.klef.jfsd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Internship;
import com.klef.jfsd.springboot.repository.InternshipRepository;

import java.util.List;

@Service
public class InternshipServiceImpl implements InternshipService {

    @Autowired
    private InternshipRepository internshipRepository;

    @Override
    public List<Internship> getAllInternships() {
        return internshipRepository.findAll();
    }

    @Override
    public Internship getInternshipById(Long id) {
        return internshipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Internship not found"));
    }

    @Override
    public Internship addInternship(Internship internship) {
        return internshipRepository.save(internship);
    }
}
