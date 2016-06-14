package by.it_academy.agency.services;

import by.it_academy.agency.beans.Entity;

import java.sql.SQLException;
import java.util.List;

public interface IService<TYPE extends Entity> {

    void add(TYPE type) throws SQLException;

    void update(TYPE type) throws SQLException;

    TYPE getById(int id) throws SQLException;

    List<TYPE> getAll() throws SQLException;
}
