package com.fabricefo.hexagonal.infrastructure.adapters.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fabricefo.hexagonal.domain.service.TodoService;
import com.fabricefo.hexagonal.infrastructure.adapters.output.persistence.TodoPersistenceAdapter;
import com.fabricefo.hexagonal.infrastructure.adapters.output.persistence.mapper.TodoMapper;
import com.fabricefo.hexagonal.infrastructure.adapters.output.persistence.repository.TodoRepository;

@Configuration
public class BeanConfiguration {
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public TodoMapper todoMapper() {
        return new TodoMapper();
    }

    @Bean
    public TodoPersistenceAdapter todoPersistenceAdapter(TodoRepository todoRepository, TodoMapper todoMapper) {
        return new TodoPersistenceAdapter(todoRepository, todoMapper);
    }

    @Bean
    public TodoService todoService(TodoPersistenceAdapter todoPersistenceAdapter) {
        return new TodoService(todoPersistenceAdapter);
    }
}
