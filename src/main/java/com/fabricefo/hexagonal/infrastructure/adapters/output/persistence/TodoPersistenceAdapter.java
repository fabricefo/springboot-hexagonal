package com.fabricefo.hexagonal.infrastructure.adapters.output.persistence;

import java.util.Optional;
import java.util.List;

import lombok.RequiredArgsConstructor;

import com.fabricefo.hexagonal.application.ports.output.TodoOutputPort;
import com.fabricefo.hexagonal.domain.model.Todo;
import com.fabricefo.hexagonal.infrastructure.adapters.output.persistence.entity.TodoEntity;
import com.fabricefo.hexagonal.infrastructure.adapters.output.persistence.mapper.TodoMapper;
import com.fabricefo.hexagonal.infrastructure.adapters.output.persistence.repository.TodoRepository;

@RequiredArgsConstructor
public class TodoPersistenceAdapter implements TodoOutputPort {
    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    @Override
    public Todo saveTodo(Todo todo) {
        TodoEntity todoEntity = todoMapper.toEntity(todo);
        todoRepository.save(todoEntity);
        return todoMapper.toTodo(todoEntity);
    }

    @Override
    public Optional<Todo> getTodoById(Long id) {
        Optional<TodoEntity> todoEntity = todoRepository.findById(id);

        if(todoEntity.isEmpty()) {
            return Optional.empty();
        }

        Todo todo = todoMapper.toTodo(todoEntity.get());
        return Optional.of(todo);
    }

    @Override
    public List<Todo> getTodos() {
        List<TodoEntity> todosEntities = todoRepository.findAll();
        List<Todo> todos = todoMapper.toTodos(todosEntities);
        return todos;
    }
       
}
