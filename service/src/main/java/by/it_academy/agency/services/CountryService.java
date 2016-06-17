package by.it_academy.agency.services;

import by.it_academy.agency.beans.Country;
import by.it_academy.agency.dao.CountryDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CountryService implements IService<Country> {
    private CountryDAO countryDAO = new CountryDAO();

    @Override
    public void add(Country country) throws ServiceException {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            countryDAO.createEntity(country);
            session.getTransaction().commit();
        } catch (DAOException e) {
            logger.writeLog("Add country error:" + e.getMessage());
            session.getTransaction().rollback();
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void update(Country country) {

    }

    @Override
    public Country getById(int id) throws ServiceException {
        try {
            return countryDAO.getEntityByID(id);
        } catch (DAOException e) {
            logger.writeLog("Get country by id error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Country> getAll() throws ServiceException {
        try {
            return countryDAO.getAll();
        } catch (DAOException e) {
            logger.writeLog("Get all countries:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    public Country getEntityByCountry(String country) throws ServiceException {
        try {
            return countryDAO.getEntityByCountry(country);
        } catch (DAOException e) {
            logger.writeLog("Get entity by country error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }
}
