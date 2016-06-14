package by.it_academy.agency.dao;


import by.it_academy.agency.beans.Entity;

import java.util.List;

public interface DAO<TYPE extends Entity> {
    List<TYPE> getAll();

    void createEntity(TYPE type);

    TYPE getEntityByID(int id);
}
