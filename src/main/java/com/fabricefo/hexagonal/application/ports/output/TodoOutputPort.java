package com.fabricefo.hexagonal.application.ports.output;

import java.util.Optional;
import com.fabricefo.hexagonal.domain.model.Todo;

public interface TodoOutputPort {
    
    Todo saveTodo(Todo todo);

    Optional<Todo> getTodoById(Long id);

}
