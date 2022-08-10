package edu.serjmaks.mockito.ex01_without_mockito;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import edu.serjmaks.mockito.ex01_without_mockito.Dao;
import edu.serjmaks.mockito.ex01_without_mockito.DaoException;
import edu.serjmaks.mockito.ex01_without_mockito.JdbcTemplate;
import edu.serjmaks.mockito.ex01_without_mockito.Poll;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PollDaoImpl implements Dao<Poll> {

    private static final String SELECT_ALL = "SELECT * FROM poll";
    private static final String SELECT_BY_ID = SELECT_ALL + " WHERE id=?";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Poll> findAll() throws DaoException {
        return jdbcTemplate.findAll(SELECT_ALL, this::map);
    }

    @Override
    public Optional<Poll> findById(long id) {
        return jdbcTemplate.findOne(SELECT_BY_ID, this::map, id);
    }

    private Poll map(ResultSet resultSet) throws SQLException {
        return new Poll(
            resultSet.getLong("id"),
            resultSet.getString("name"),
            resultSet.getString("description")
        );
    }
}
