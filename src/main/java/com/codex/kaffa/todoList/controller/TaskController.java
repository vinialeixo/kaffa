package com.codex.kaffa.todoList.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codex.kaffa.todoList.controller.dto.TaskCreateDto;
import com.codex.kaffa.todoList.controller.dto.TaskResposnseDto;
import com.codex.kaffa.todoList.service.TaskService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RequiredArgsConstructor
@RestController
@RequestMapping("task")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("")
    public ResponseEntity<TaskResposnseDto> createTask(@RequestBody TaskCreateDto body) {
        TaskResposnseDto task = taskService.createTask(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResposnseDto> getTaskById(@PathVariable Long id) {
        TaskResposnseDto task = taskService.getTaskById(id);

        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResposnseDto> putMethodName(@PathVariable Long id, @RequestBody TaskCreateDto body) {
        TaskResposnseDto task = taskService.updateTask(body,id);

        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @GetMapping("")
    public ResponseEntity<List<TaskResposnseDto>> getAllTasks() {
        List<TaskResposnseDto> tasks = taskService.getAllTasks();
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    

}
