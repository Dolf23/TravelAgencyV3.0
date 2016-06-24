package by.it_academy.agency.dao;

import by.it_academy.agency.beans.Tour;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class TourDAO extends AbstractDAO<Tour> {

    public void updateEntity(Tour tour) throws DAOException {
        try {
            Session session = HibernateUtil.getSession();
            session.update(tour);
        } catch (HibernateException e) {
            logger.writeLog("TourDAO  updateEntity error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
    }

    public List<Tour> getToursByRequest(int tourType, int country, int transport, int hotelType, int foodComplex) throws DAOException {
        try {
            Session session = HibernateUtil.getSession();
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
            Session session = HibernateUtil.getSession();
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
}