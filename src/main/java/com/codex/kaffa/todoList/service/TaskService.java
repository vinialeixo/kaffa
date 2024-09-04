package com.codex.kaffa.todoList.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codex.kaffa.todoList.controller.dto.TaskCreateDto;
import com.codex.kaffa.todoList.controller.dto.TaskResposnseDto;
import com.codex.kaffa.todoList.controller.dto.mapper.TaskMapper;
import com.codex.kaffa.todoList.controller.exception.EntityNotFoundExcepation;
import com.codex.kaffa.todoList.model.Task;
import com.codex.kaffa.todoList.repository.TaskRepository;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    

    private Task getTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundExcepation(String.format("User id=%s not found", id)));
        return task;
    }

    @Transactional
    public TaskResposnseDto createTask(TaskCreateDto body) {
        Task task = TaskMapper.converToTask(body);
        task.setCreatedOn(LocalDateTime.now());

        taskRepository.save(task);
        return TaskMapper.converToDto(task);
    }

    @Transactional(readOnly = true)
    public TaskResposnseDto getTaskById(Long id) {
        Task task = getTask(id);

        return TaskMapper.converToDto(task);
    }

    @Transactional
    public TaskResposnseDto updateTask(TaskCreateDto body, Long id) {
        Task task = getTask(id);
        if (body.getTaskName() != null) {
            task.setTaskName(body.getTaskName());
        }
        if (body.getObservation() != null) {
            task.setObservation(body.getObservation());
        }
        task.setUpdateOn(LocalDateTime.now());

        taskRepository.save(task);
        return TaskMapper.converToDto(task);
    }

    @Transactional(readOnly = true)
    public List<TaskResposnseDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();

        return TaskMapper.converToDtoList(tasks);
    }

}
