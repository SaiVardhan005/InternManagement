package com.klef.jfsd.springboot.controller;

import com.klef.jfsd.springboot.dto.TaskDTO;
import com.klef.jfsd.springboot.model.Task;
import com.klef.jfsd.springboot.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:3000")

public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody TaskDTO taskDTO) {
        return taskService.createTask(taskDTO); // Call the service to save the task
    }
    @GetMapping("/internship/{internshipId}")
    public List<Task> getTasksByInternshipId(@PathVariable("internshipId") Long internshipId) {
        System.out.println("Fetching tasks for Internship ID: " + internshipId);

        if (internshipId == null || internshipId <= 0) {
            throw new IllegalArgumentException("Invalid internship ID");
        }

        // Return the full list of tasks for the internship
        return taskService.getTasksByInternshipId(internshipId);
    }


}

