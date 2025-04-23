package com.mak.ht.services;

import com.mak.ht.model.Tasks;
import com.mak.ht.repository.TasksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TasksService {

    private final TasksRepository tasksRepository;


    public List<Tasks> getAllTasks() {
        return tasksRepository.findAll();
    }

    public Optional<Tasks> getTaskById(Long id) {
        return tasksRepository.findById(id);
    }

    public void addTask(Tasks task) {

        tasksRepository.save(task);
    }


    public Tasks updateTask(Long id, Tasks taskChange) {
        Optional<Tasks> taskOptional = tasksRepository.findById(id);
        if (taskOptional.isPresent()) {
            Tasks task = taskOptional.get();
            task.setTitle(taskChange.getTitle());
            task.setDescription(taskChange.getDescription());
            tasksRepository.save(task);
            task.setId(taskChange.getId());
            task.setStatus(taskChange.getStatus());
            return task;
        }
        else {
            throw new IllegalArgumentException("Task not found");
        }
    }



    public void deleteTaskById(Long id) {
        tasksRepository.deleteById(id);
    }


}
