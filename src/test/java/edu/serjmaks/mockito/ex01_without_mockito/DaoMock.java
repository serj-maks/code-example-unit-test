package edu.serjmaks.mockito.ex01_without_mockito;

import java.util.List;
import java.util.Optional;

public class DaoMock implements Dao<Poll> {

    @Override
    public List<Poll> findAll() throws DaoException {
        return List.of(
            new Poll(1L, "name", "description"),
            new Poll(2L, "name", "description"),
            new Poll(3L, "name", "description")
        );
    }

    @Override
    public Optional<Poll> findById(long id) throws DaoException {
        if (id == 1L) {
            return Optional.of(new Poll(id, "name", "description"));
        } else {
            return Optional.empty();
        }
    }
}
