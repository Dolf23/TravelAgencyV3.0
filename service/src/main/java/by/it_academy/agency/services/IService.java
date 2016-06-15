package by.it_academy.agency.services;

import by.it_academy.agency.beans.Entity;

import java.util.List;

public interface IService<TYPE extends Entity> {

    void add(TYPE type);

    void update(TYPE type);

    TYPE getById(int id);

    List<TYPE> getAll();
}
