package by.it_academy.agency.dao;


import by.it_academy.agency.exceptions.DAOException;

import java.util.List;

public interface DAO<TYPE> {
    List<TYPE> getAll() throws DAOException;

    void createEntity(TYPE type) throws DAOException;

    TYPE getEntityByID(int id) throws DAOException;
}