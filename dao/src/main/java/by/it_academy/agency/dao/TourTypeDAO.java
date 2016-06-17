package by.it_academy.agency.dao;

import by.it_academy.agency.beans.TourType;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class TourTypeDAO extends AbstractDAO<TourType> {

    public TourType getEntityByTourType(String tourType) throws DAOException {
        TourType tourTypeOut;
        try {
            Session session = HibernateUtil.getSession();
            Criteria criteria = session.createCriteria(TourType.class);
            criteria.add(Restrictions.eq(ColumnNames.TOUR_TYPES_TOUR_TYPE, tourType));
            tourTypeOut = (TourType) criteria.uniqueResult();
        } catch (HibernateException e) {
            logger.writeLog("TourTypeDAO getEntityByTourType error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
        return tourTypeOut;
    }
}