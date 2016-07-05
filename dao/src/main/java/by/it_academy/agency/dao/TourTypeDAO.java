package by.it_academy.agency.dao;

import by.it_academy.agency.beans.TourType;
import by.it_academy.agency.constants.ColumnNames;
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
public class TourTypeDAO extends AbstractDAO<TourType> {

    @Autowired
    private TourTypeDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public TourType getEntityByTourType(String tourType) throws DAOException {
        TourType tourTypeOut;
        try {
            Session session = currentSession();
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