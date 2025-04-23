package com.mak.ht.controller;


import com.mak.ht.model.Tasks;
import com.mak.ht.repository.TasksRepository;
import com.mak.ht.services.FileGateway;
import com.mak.ht.services.TasksService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TasksController {

    private final TasksService tasksService;
    private final FileGateway fileGateway;

    @GetMapping
    public List<Tasks> getTasks() {

        fileGateway.writeToFile( "tasks.txt", tasksService.getAllTasks().toString());
        return tasksService.getAllTasks();
    }

    @PostMapping("/add")
    public void addTask(@RequestBody Tasks task) {
        task.setStartTime(LocalDateTime.now());
        tasksService.addTask(task);
        fileGateway.writeToFile(task.getTitle() + ".txt", task.toString());
    }


    @PutMapping("/{id}")
    public void updateTask(@PathVariable Long id, @RequestBody Tasks task) {
        tasksService.updateTask(id, task);
        fileGateway.writeToFile( "tasksbyid.txt", id.toString() + "  " + task.toString());

    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        tasksService.deleteTaskById(id);
        fileGateway.writeToFile("deleted.txt", id.toString() + "   " + tasksService.getTaskById(id).toString());
    }

}
