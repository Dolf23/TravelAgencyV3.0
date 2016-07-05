package by.it_academy.agency.dao;

import by.it_academy.agency.beans.Tour;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.dao.interfaces.ITourDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.logger.logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TourDAO extends AbstractDAO<Tour> implements ITourDAO {

    @Autowired
    private TourDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void updateEntity(Tour tour) throws DAOException {
        try {
            Session session = currentSession();
            session.update(tour);
        } catch (HibernateException e) {
            logger.writeLog("TourDAO  updateEntity error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
    }

    public List<Tour> getToursByRequest(int tourType, int country, int transport, int hotelType, int foodComplex) throws DAOException {
        try {
            Session session = currentSession();
            Criteria criteria = session.createCriteria(Tour.class);
            criteria.add(Restrictions.eq(ColumnNames.TOURS_FK_TOUR_TYPE + "." + ColumnNames.TOUR_TYPES_ID, tourType));
            criteria.add(Restrictions.eq(ColumnNames.TOURS_FK_COUNTRY + "." + ColumnNames.COUNTRIES_ID, country));
            criteria.add(Restrictions.eq(ColumnNames.TOURS_FK_TRANSPORT + "." + ColumnNames.TRANSPORTS_ID, transport));
            criteria.add(Restrictions.eq(ColumnNames.TOURS_FK_HOTEL_TYPE + "." + ColumnNames.HOTEL_TYPES_ID, hotelType));
            criteria.add(Restrictions.eq(ColumnNames.TOURS_FK_FOOD_COMPLEX + "." + ColumnNames.FOOD_COMPLEXES_ID, foodComplex));
            List<Tour> list = criteria.list();
            return list;
        } catch (HibernateException e) {
            logger.writeLog("TourDAO  getToursByRequest error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
    }

    public List<Tour> getToursWithLimit(int start, int size) throws DAOException {
        try {
            Session session = currentSession();
            Criteria criteria = session.createCriteria(Tour.class);
            criteria.setFirstResult(start);
            criteria.setMaxResults(size);
            List<Tour> list = criteria.list();
            return list;
        } catch (HibernateException e) {
            logger.writeLog("TourDAO  getToursWithLimit error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
    }

    public int getCountTours() throws DAOException {
        try {
            Session session = currentSession();
            Criteria criteria = session.createCriteria(Tour.class);
            criteria.setProjection(Projections.countDistinct(ColumnNames.TOURS_ID));
            long count = (long) criteria.uniqueResult();
            return (int) count;
        } catch (HibernateException e) {
            logger.writeLog("TourDAO  getCountTours:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
    }
}