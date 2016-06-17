package by.it_academy.agency.dao;

import by.it_academy.agency.beans.Tour;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

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
            Query query = session.createQuery(SQLRequests.GET_TOURS_BY_REQUEST);
            query.setParameter(ColumnNames.TOURS_FK_TOUR_TYPE, tourType);
            query.setParameter(ColumnNames.TOURS_FK_COUNTRY, country);
            query.setParameter(ColumnNames.TOURS_FK_TRANSPORT, transport);
            query.setParameter(ColumnNames.TOURS_FK_HOTEL_TYPE, hotelType);
            query.setParameter(ColumnNames.TOURS_FK_FOOD_COMPLEX, foodComplex);
            List<Tour> list = query.list();
            return list;
        } catch (HibernateException e) {
            logger.writeLog("TourDAO  getToursByRequest error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
    }
}