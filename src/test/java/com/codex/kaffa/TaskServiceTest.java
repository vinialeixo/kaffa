package com.codex.kaffa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codex.kaffa.todoList.controller.dto.TaskCreateDto;
import com.codex.kaffa.todoList.controller.dto.TaskResposnseDto;
import com.codex.kaffa.todoList.controller.dto.mapper.TaskMapper;
import com.codex.kaffa.todoList.model.Task;
import com.codex.kaffa.todoList.repository.TaskRepository;
import com.codex.kaffa.todoList.service.TaskService;

import jakarta.transaction.Transactional;

@SpringBootTest
public class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService; 

    private TaskCreateDto taskCreateDto;
    private Task task;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        taskCreateDto = new TaskCreateDto();
        taskCreateDto.setTaskName("Test Task");
        taskCreateDto.setObservation("Task for testing");

        task = TaskMapper.converToTask(taskCreateDto);
        task.setCreatedOn(LocalDateTime.now());
    }

    @Test
    @Transactional
    public void testCreateTask() {
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        TaskResposnseDto responseDto = taskService.createTask(taskCreateDto);

        // Verifica se o método save foi chamado
        // verify(taskRepository).save(any(Task.class));

        // Verifica se o resultado é o esperado
        assertEquals(taskCreateDto.getTaskName(), responseDto.getTaskName());
        assertEquals(taskCreateDto.getObservation(), responseDto.getObservation());
        assertNotNull(responseDto.getCreatedOn()); 
    }
}
