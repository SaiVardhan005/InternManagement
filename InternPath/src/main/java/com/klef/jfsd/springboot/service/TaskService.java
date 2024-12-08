package com.klef.jfsd.springboot.service;

import com.klef.jfsd.springboot.dto.TaskDTO;
import com.klef.jfsd.springboot.model.Internship;
import com.klef.jfsd.springboot.model.Task;
import com.klef.jfsd.springboot.repository.InternshipRepository;
import com.klef.jfsd.springboot.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private InternshipRepository internshipRepository;

    // Create a new task and link it to an internship
    public Task createTask(TaskDTO taskDTO) {
        // Find the associated internship
        Internship internship = internshipRepository.findById(taskDTO.getInternshipId())
                .orElseThrow(() -> new RuntimeException("Internship not found"));

        // Create and set up the task
        Task task = new Task();
        task.setUrl(taskDTO.getUrl());
        task.setQuestion(taskDTO.getQuestion());
        task.setInternship(internship); // Set the relationship

        // Add the task to the internship's list of tasks
        internship.getTasks().add(task);

        // Save the updated internship (cascading will handle saving the task)
        internshipRepository.save(internship);
        System.out.println("Updated Internship: " + internship);


        return task; // Return the task for confirmation
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Fetch all tasks for a specific internship
   

    // Optional: Fetch internship with tasks explicitly loaded
    public Internship fetchInternshipWithTasks(Long internshipId) {
        Internship internship = internshipRepository.findById(internshipId)
                .orElseThrow(() -> new RuntimeException("Internship not found"));

        // Explicitly initialize tasks if lazy loading is enabled
        internship.getTasks().size(); // Triggers Hibernate to load tasks
        return internship;
    }
    public List<Task> getTasksByInternshipId(Long internshipId) {
        System.out.println("Service called for Internship ID: " + internshipId);

        if (!internshipRepository.existsById(internshipId)) {
            throw new IllegalArgumentException("Internship not found for ID: " + internshipId);
        }

        // Fetch all tasks for the given internship ID
        List<Task> tasks = taskRepository.findByInternshipId(internshipId);
        tasks.forEach(task -> System.out.println("Fetched Task: ID=" + task.getId() +
                ", Question=" + task.getQuestion() +
                ", URL=" + task.getUrl()));
        return tasks;
    }

}
