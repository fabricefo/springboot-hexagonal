package com.fabricefo.hexagonal.application.ports.input;

import com.fabricefo.hexagonal.domain.model.Todo;

public interface CreateTodoUseCase {
    Todo createTodo(Todo todo);    
}
