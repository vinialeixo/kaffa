package com.codex.kaffa.todoList.controller.dto;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class TaskResposnseDto {
    private String taskName;
    private String observation;
    private LocalDateTime createdOn;
    private Long id;
    private LocalDateTime updateOn;
}
