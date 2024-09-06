package com.codex.kaffa.todoList.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codex.kaffa.todoList.domain.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

}
