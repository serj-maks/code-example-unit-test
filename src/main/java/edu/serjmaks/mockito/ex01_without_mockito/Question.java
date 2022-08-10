package edu.serjmaks.mockito.ex01_without_mockito;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    private long id;
    private String text;
    private List<Answer> answers;

    public Question(long id, String text) {
        this.id = id;
        this.text = text;
    }
}
