package edu.serjmaks.mockito.ex01_with_mockito;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Poll {

    private long id;
    private String name;
    private String description;
    private List<Question> questions;
    private List<Result> results;

    public Poll(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
