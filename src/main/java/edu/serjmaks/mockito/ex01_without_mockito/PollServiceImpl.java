package edu.serjmaks.mockito.ex01_without_mockito;

import java.util.List;

import edu.serjmaks.mockito.ex01_without_mockito.Dao;
import edu.serjmaks.mockito.ex01_without_mockito.NotFoundException;
import edu.serjmaks.mockito.ex01_without_mockito.Poll;
import edu.serjmaks.mockito.ex01_without_mockito.PollService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class PollServiceImpl implements PollService {

    private final Dao<Poll> dao;

    @Override
    public List<Poll> getAll() {
        log.debug("getAll - start");

        List<Poll> polls = dao.findAll();

        log.debug("getAll - end: polls = {}", polls);
        return polls;
    }

    public Poll getById(long id) {
        log.debug("getById - start");

        Poll poll = dao.findById(id)
            .orElseThrow(() -> new NotFoundException("poll with id = " + id + " not found"));

        log.debug("getById - end: poll = {}", poll);
        return poll;
    }
}
