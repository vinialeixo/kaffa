package com.codex.kaffa.todoList.controller.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.codex.kaffa.todoList.controller.dto.TaskCreateDto;
import com.codex.kaffa.todoList.controller.dto.TaskResposnseDto;
import com.codex.kaffa.todoList.domain.model.Task;

public class TaskMapper {

    public static Task converToTask(TaskCreateDto taskDto){
        return new ModelMapper().map(taskDto, Task.class);
    }

    public static TaskResposnseDto converToDto(Task task){
        return new ModelMapper().map(task, TaskResposnseDto.class);
    }
    public static List<TaskResposnseDto> converToDtoList(List<Task> tasks){
        return tasks.stream().map(task ->converToDto(task)).collect(Collectors.toList());
    }
}
