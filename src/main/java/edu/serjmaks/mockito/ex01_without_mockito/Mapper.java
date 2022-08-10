package edu.serjmaks.mockito.ex01_without_mockito;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Mapper<T> {

    default List<T> mapAll(ResultSet resultSet) throws SQLException {
        List<T> result = new ArrayList<>();
        while (resultSet.next()) {
            T entity = map(resultSet);
            result.add(entity);
        }
        return result;
    }

    T map(ResultSet resultSet) throws SQLException;
}
