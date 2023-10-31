package com.fabricefo.hexagonal.application.ports.input;

import java.util.List;
import com.fabricefo.hexagonal.domain.model.Todo;

public interface GetTodosUseCase {
    List<Todo> getTodos();    
}
