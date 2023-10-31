package com.fabricefo.hexagonal.application.ports.input;

import com.fabricefo.hexagonal.domain.model.Todo;

public interface GetTodoUseCase {
    Todo getTodoById(Long id);
}
