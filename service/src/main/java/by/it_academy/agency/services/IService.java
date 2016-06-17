package by.it_academy.agency.services;

import by.it_academy.agency.beans.Entity;
import by.it_academy.agency.exceptions.ServiceException;

import java.util.List;

public interface IService<TYPE extends Entity> {

    void add(TYPE type) throws ServiceException;

    void update(TYPE type) throws ServiceException;

    TYPE getById(int id) throws ServiceException;

    List<TYPE> getAll() throws ServiceException;
}
