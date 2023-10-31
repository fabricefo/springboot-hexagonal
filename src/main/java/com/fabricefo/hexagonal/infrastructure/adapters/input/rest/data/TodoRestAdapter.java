package com.fabricefo.hexagonal.infrastructure.adapters.input.rest.data;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabricefo.hexagonal.application.ports.input.CreateTodoUseCase;
import com.fabricefo.hexagonal.application.ports.input.GetTodoUseCase;
import com.fabricefo.hexagonal.domain.model.Todo;
import com.fabricefo.hexagonal.infrastructure.adapters.input.rest.data.request.TodoRequest;
import com.fabricefo.hexagonal.infrastructure.adapters.input.rest.data.response.TodoResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class TodoRestAdapter {
    
    private final CreateTodoUseCase createTodoUseCase;
    private final GetTodoUseCase getTodoUseCase;
    private final ModelMapper mapper;

    @PostMapping(value="/todos")
    public ResponseEntity<TodoResponse> createTodo(@RequestBody TodoRequest todoToCreate) {
        // Request to domain
        Todo todo = mapper.map(todoToCreate, Todo.class);
        todo = createTodoUseCase.createTodo(todo);
        // Domain to response
        return new ResponseEntity<>(mapper.map(todo, TodoResponse.class), HttpStatus.CREATED);
    }

    @GetMapping(value = "/todos/{id}")
    public ResponseEntity<TodoResponse> getTodo(@PathVariable Long id){
        Todo todo = getTodoUseCase.getTodoById(id);
        // Domain to response
        return new ResponseEntity<>(mapper.map(todo, TodoResponse.class), HttpStatus.OK);
    }
    
}
