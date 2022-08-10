package edu.serjmaks.mockito.ex01_with_mockito;

import java.util.List;

import edu.serjmaks.mockito.ex01_with_mockito.Poll;

public interface PollService {

    List<Poll> getAll();

    Poll getById(long id);
}
