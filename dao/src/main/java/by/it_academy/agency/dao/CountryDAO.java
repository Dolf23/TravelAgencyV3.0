package by.it_academy.agency.dao;

import by.it_academy.agency.beans.Country;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public enum CountryDAO implements DAO<Country> {
    INSTANCE;

    @Override
    public List<Country> getAll() {
        Session session = HibernateUtil.getSession();
        List<Country> list = session.createQuery(SQLRequests.GET_ALL_COUNTRIES).list();
        return list;
    }

    @Override
    public void createEntity(Country country) {
        Session session = HibernateUtil.getSession();
        session.save(country);
    }

    @Override
    public Country getEntityByID(int id) {
        Session session = HibernateUtil.getSession();
        Country country = (Country) session.get(Country.class, id);
        return country;
    }

    public Country getEntityByCountry(String country) {
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Country.class);
        criteria.add(Restrictions.eq(ColumnNames.COUNTRIES_COUNTRY, country));
        Country countryOut = (Country) criteria.uniqueResult();
        return countryOut;
    }
}
