package com.codex.kaffa.todoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codex.kaffa.todoList.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

}
