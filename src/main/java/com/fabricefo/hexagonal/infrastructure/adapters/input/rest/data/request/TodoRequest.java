package com.fabricefo.hexagonal.infrastructure.adapters.input.rest.data.request;

import jakarta.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoRequest {
    
    @NotEmpty(message="Title may not be empty")
    private String title;

    @NotEmpty(message="Description may not be empty")
    private String description;
}
