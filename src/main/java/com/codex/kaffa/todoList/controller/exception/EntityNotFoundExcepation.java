package com.codex.kaffa.todoList.controller.exception;

public class EntityNotFoundExcepation extends RuntimeException{

    public EntityNotFoundExcepation(String message){
        super(message);
    }
}
