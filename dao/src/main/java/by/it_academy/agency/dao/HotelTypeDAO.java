package by.it_academy.agency.dao;

import by.it_academy.agency.beans.HotelType;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.logger.logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class HotelTypeDAO extends AbstractDAO<HotelType> {
    private HotelTypeDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public HotelType getEntityByHotelType(String hotelType) throws DAOException {
        HotelType hotelTypeOut;
        try {
            Session session = currentSession();
            Criteria criteria = session.createCriteria(HotelType.class);
            criteria.add(Restrictions.eq(ColumnNames.HOTEL_TYPES_HOTEL_TYPE, hotelType));
            hotelTypeOut = (HotelType) criteria.uniqueResult();
        } catch (HibernateException e) {
            logger.writeLog("HotelTypeDAO getEntityByHotelType error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
        return hotelTypeOut;
    }
}