package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.Task;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Fetch all tasks by internship ID, including all fields (eager fetch)
    @Query("SELECT t FROM Task t WHERE t.internship.id = :internshipId")
    List<Task> findByInternshipId(@Param("internshipId") Long internshipId);
}



