package edu.serjmaks.mockito.ex01_without_mockito;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private long id;
    private String explanation;
    private int minScore;
    private int maxScore;
}
