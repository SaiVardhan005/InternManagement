package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.jfsd.springboot.model.Internship;


public interface InternshipRepository extends JpaRepository<Internship, Long> {
}