package by.it_academy.agency.dao.interfaces;

import by.it_academy.agency.beans.Country;
import by.it_academy.agency.exceptions.DAOException;

public interface ICountryDAO extends DAO<Country> {
    Country getEntityByCountry(String country) throws DAOException;
}
