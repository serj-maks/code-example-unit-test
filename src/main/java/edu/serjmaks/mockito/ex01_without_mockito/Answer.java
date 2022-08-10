package edu.serjmaks.mockito.ex01_without_mockito;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

    private long id;
    private String text;
    private int weight;
}
