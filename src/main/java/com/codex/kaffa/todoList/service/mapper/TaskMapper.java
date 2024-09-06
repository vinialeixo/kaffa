package com.codex.kaffa.todoList.service.mapper;

import org.modelmapper.ModelMapper;

import com.codex.kaffa.todoList.controller.dto.TaskCreateDto;
import com.codex.kaffa.todoList.domain.model.Task;

public class TaskMapper {

    public static Task toUser(TaskCreateDto createDto) {
        return new ModelMapper().map(createDto, Task.class);
    }
}
