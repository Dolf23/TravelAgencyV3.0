package by.it_academy.agency.services.interfaces;

import by.it_academy.agency.beans.Country;
import by.it_academy.agency.exceptions.ServiceException;

public interface ICountryService extends IService<Country> {
    Country getEntityByCountry(String country) throws ServiceException;
}
