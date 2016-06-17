package by.it_academy.agency.dao;

import by.it_academy.agency.beans.Country;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class CountryDAO extends AbstractDAO<Country> {

    public Country getEntityByCountry(String country) throws DAOException {
        Country countryOut;
        try {
            Session session = HibernateUtil.getSession();
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