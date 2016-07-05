package by.it_academy.agency.dao;

import by.it_academy.agency.beans.Country;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.dao.interfaces.ICountryDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.logger.logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDAO extends AbstractDAO<Country> implements ICountryDAO {

    @Autowired
    private CountryDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Country getEntityByCountry(String country) throws DAOException {
        Country countryOut;
        try {
            Session session = currentSession();
            Criteria criteria = session.createCriteria(Country.class);
            criteria.add(Restrictions.eq(ColumnNames.COUNTRIES_COUNTRY, country));
            countryOut = (Country) criteria.uniqueResult();
        } catch (HibernateException e) {
            logger.writeLog("Get entity by country error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
        return countryOut;
    }
}