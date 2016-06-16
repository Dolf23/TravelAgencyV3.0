package by.it_academy.agency.services;

import by.it_academy.agency.beans.Tour;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.dao.TourDAO;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TourService implements IService<Tour> {
    @Override
    public void add(Tour tour) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            TourDAO.INSTANCE.createEntity(tour);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            logger.writeLog(e.getMessage());
            session.getTransaction().rollback();
        }
    }

    @Override
    public void update(Tour tour) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            TourDAO.INSTANCE.updateEntity(tour);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            logger.writeLog(e.getMessage());
            session.getTransaction().rollback();
        }
    }

    @Override
    public Tour getById(int id) {
        return TourDAO.INSTANCE.getEntityByID(id);
    }

    @Override
    public List<Tour> getAll() {
        return TourDAO.INSTANCE.getAll();
    }

    public static void makeDiscount(int idTour, int amountDiscount) {
        Tour tour = TourDAO.INSTANCE.getEntityByID(idTour);
        tour.setDiscount(amountDiscount);
        new TourService().update(tour);
    }

    public static Map<Integer, String> getMapToursByRequest(int tourType, int country, int transport, int hotelType, int foodComplex) {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery(SQLRequests.GET_TOURS_BY_REQUEST);
        query.setParameter(ColumnNames.TOURS_FK_TOUR_TYPE, tourType);
        query.setParameter(ColumnNames.TOURS_FK_COUNTRY, country);
        query.setParameter(ColumnNames.TOURS_FK_TRANSPORT, transport);
        query.setParameter(ColumnNames.TOURS_FK_HOTEL_TYPE, hotelType);
        query.setParameter(ColumnNames.TOURS_FK_FOOD_COMPLEX, foodComplex);
        List<Tour> list = query.list();
        Map<Integer, String> map = new HashMap<>();

        for (Tour tour : list) {
            int id = tour.getId();
            map.put(id, convertTourToString(id));
        }
        return map;
    }

    public static String convertTourToString(int id) {
        Tour tour = TourDAO.INSTANCE.getEntityByID(id);
        String tourString =
                tour.getTourType().getTourType() + " " +
                        tour.getCountry().getCountry() + " " +
                        tour.getTransport().getTransport() + " " +
                        tour.getHotelType().getHotelType() + " " +
                        tour.getFoodComplex().getFoodComplex() + " " +
                        tour.getCost() + " " + tour.getDiscount();
        return tourString;
    }

    public Map<Integer, String> getAllToursMap() {
        List<Tour> list = getAll();
        Map<Integer, String> map = new HashMap<>();

        for (Tour tour : list) {
            int idTour = tour.getId();
            map.put(idTour, convertTourToString(idTour));
        }
        return map;
    }


}
