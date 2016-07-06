package by.it_academy.agency.services;

import by.it_academy.agency.beans.Country;
import by.it_academy.agency.dao.interfaces.ICountryDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.services.interfaces.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DAOException.class)
public class CountryService implements ICountryService {

    private ICountryDAO dao;

    @Autowired
    public CountryService(ICountryDAO dao) {
        this.dao = dao;
    }

    @Override
    public void add(Country country) throws ServiceException {
        try {
            dao.createEntity(country);
        } catch (DAOException e) {
            logger.writeLog("Add country error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void update(Country country) {

    }

    @Override
    public Country getById(int id) throws ServiceException {
        try {
            return dao.getEntityByID(id);
        } catch (DAOException e) {
            logger.writeLog("Get country by id error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Country> getAll() throws ServiceException {
        try {
            return dao.getAll();
        } catch (DAOException e) {
            logger.writeLog("Get all countries:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Country getEntityByCountry(String country) throws ServiceException {
        try {
            return dao.getEntityByCountry(country);
        } catch (DAOException e) {
            logger.writeLog("Get entity by country error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }
}
