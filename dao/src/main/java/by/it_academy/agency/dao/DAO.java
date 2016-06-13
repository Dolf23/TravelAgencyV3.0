package by.it_academy.agency.dao;

import by.it_academy.TravelAgency.dto.Entity;

import java.sql.SQLException;
import java.util.List;

public interface DAO<TYPE extends Entity> {
    List<TYPE> getAll() throws SQLException;

    public void createEntity(TYPE type) throws SQLException;

    public TYPE getEntityByID(int id) throws SQLException;
}
