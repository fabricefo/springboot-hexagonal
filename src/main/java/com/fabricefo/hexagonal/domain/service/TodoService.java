package com.fabricefo.hexagonal.domain.service;

import java.util.List;

import com.fabricefo.hexagonal.application.ports.input.CreateTodoUseCase;
import com.fabricefo.hexagonal.application.ports.input.GetTodoUseCase;
import com.fabricefo.hexagonal.application.ports.input.GetTodosUseCase;
import com.fabricefo.hexagonal.application.ports.output.TodoOutputPort;
import com.fabricefo.hexagonal.domain.exception.TodoNotFoundException;
import com.fabricefo.hexagonal.domain.model.Todo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TodoService implements CreateTodoUseCase, GetTodoUseCase, GetTodosUseCase {
    
    private final TodoOutputPort todoOutputPort;

    @Override
    public Todo getTodoById(Long id) {
        return todoOutputPort.getTodoById(id)
                            .orElseThrow(() -> new TodoNotFoundException("Aucune Todo trouvée avec ID: " + id));
    }

    @Override
    public Todo createTodo(Todo todo) {
        return todoOutputPort.saveTodo(todo);
    }

    @Override
    public List<Todo> getTodos() {
        return todoOutputPort.getTodos();
    }


}
