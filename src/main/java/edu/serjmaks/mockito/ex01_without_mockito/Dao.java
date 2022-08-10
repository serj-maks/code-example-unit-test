package edu.serjmaks.mockito.ex01_without_mockito;

import java.util.List;
import java.util.Optional;

import edu.serjmaks.mockito.ex01_without_mockito.DaoException;

public interface Dao<T> {

    List<T> findAll() throws DaoException;

    Optional<T> findById(long id) throws DaoException;
}
