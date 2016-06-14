package by.it_academy.agency.dao;

import by.it_academy.agency.beans.Country;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public enum CountryDAO implements DAO<Country> {
    INSTANCE;

    @Override
    public List<Country> getAll() {
        Session session = HibernateUtil.getSession();
        return session.createQuery(SQLRequests.GET_ALL_COUNTRIES).list();
    }

    @Override
    public void createEntity(Country country) {
        Session session = HibernateUtil.getSession();
        session.save(country);
    }

    @Override
    public Country getEntityByID(int id) {
        Session session = HibernateUtil.getSession();
        return (Country) session.get(Country.class, id);
    }
}
