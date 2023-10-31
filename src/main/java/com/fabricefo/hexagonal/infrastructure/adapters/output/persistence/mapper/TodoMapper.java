package com.fabricefo.hexagonal.infrastructure.adapters.output.persistence.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.fabricefo.hexagonal.domain.model.Todo;
import com.fabricefo.hexagonal.infrastructure.adapters.output.persistence.entity.TodoEntity;

import java.util.ArrayList;
import java.util.List;

public class TodoMapper {
    
    @Autowired
    private ModelMapper mapper;

    public Todo toTodo(TodoEntity entity) {
        return mapper.map(entity, Todo.class);
    }

    public TodoEntity toEntity(Todo todo) {
        return mapper.map(todo, TodoEntity.class);
    }

    public List<Todo> toTodos(List<TodoEntity> todosEntities) {
        List<Todo> todos = new ArrayList<>();

        todosEntities.forEach(todo -> 
            todos.add(mapper.map(todo, Todo.class)));

        return todos;
    }
}
