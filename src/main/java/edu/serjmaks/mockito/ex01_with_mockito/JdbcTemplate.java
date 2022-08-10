package edu.serjmaks.mockito.ex01_with_mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import edu.serjmaks.mockito.ex01_with_mockito.ConnectionFactory;
import edu.serjmaks.mockito.ex01_with_mockito.DaoException;
import edu.serjmaks.mockito.ex01_with_mockito.JdbcUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class JdbcTemplate {

    private final ConnectionFactory connectionFactory;

    public <T> List<T> findAll(String query, Mapper<T> mapper, Object... params) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            setParams(statement, params);
            resultSet = statement.executeQuery();
            return mapper.mapAll(resultSet);
        } catch (SQLException e) {
            log.error("error when select from database", e);
            throw new DaoException("error when select from database", e);
        } finally {
            JdbcUtils.close(resultSet);
            JdbcUtils.close(statement);
            JdbcUtils.close(connection);
        }
    }

    private void setParams(PreparedStatement statement, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i+1, params[i]);
        }
    }

    public <T> Optional<T> findOne(String query, Mapper<T> mapper, Object... params) {
        List<T> result = findAll(query, mapper, params);
        return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
    }
}
