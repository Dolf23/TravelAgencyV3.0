package by.it_academy.agency.services;

import by.it_academy.agency.beans.Country;
import by.it_academy.agency.dao.CountryDAO;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CountryService implements IService<Country> {
    @Override
    public void add(Country country) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            CountryDAO.INSTANCE.createEntity(country);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            logger.writeLog(e.getMessage());
            session.getTransaction().rollback();
        }
    }

    @Override
    public void update(Country country) {

    }

    @Override
    public Country getById(int id) {
        return CountryDAO.INSTANCE.getEntityByID(id);
    }

    @Override
    public List<Country> getAll() {
        return CountryDAO.INSTANCE.getAll();
    }

    public Country getIdByCountry(String country) {
        return CountryDAO.INSTANCE.getEntityByCountry(country);
    }
}
