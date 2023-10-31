package com.fabricefo.hexagonal.domain.model;

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
public class Todo {

    private Long id;

    private String title;

    private String description;

    @Override
    public String toString() {
        return "Todo [id=\" + id + \", title=\" + title + \", desc=\" + description + \"]";
    }    
}
