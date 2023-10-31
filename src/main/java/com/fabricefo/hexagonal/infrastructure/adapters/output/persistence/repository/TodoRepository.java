package com.fabricefo.hexagonal.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fabricefo.hexagonal.infrastructure.adapters.output.persistence.entity.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    
}
