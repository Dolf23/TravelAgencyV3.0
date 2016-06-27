package by.it_academy.agency.services;

import by.it_academy.agency.beans.Tour;
import by.it_academy.agency.dao.TourDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TourService implements IService<Tour> {

    private TourDAO tourDAO = new TourDAO();

    @Override
    public void add(Tour tour) throws ServiceException {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            tourDAO.createEntity(tour);
            session.getTransaction().commit();
        } catch (DAOException e) {
            logger.writeLog("TourService add error:" + e.getMessage());
            session.getTransaction().rollback();
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void update(Tour tour) throws ServiceException {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            tourDAO.updateEntity(tour);
            session.getTransaction().commit();
        } catch (DAOException e) {
            logger.writeLog("TourService update error:" + e.getMessage());
            session.getTransaction().rollback();
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Tour getById(int id) throws ServiceException {
        try {
            return tourDAO.getEntityByID(id);
        } catch (DAOException e) {
            logger.writeLog("TourService getById error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Tour> getAll() throws ServiceException {
        try {
            return tourDAO.getAll();
        } catch (DAOException e) {
            logger.writeLog("TourService getAll error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    public void makeDiscount(int idTour, int amountDiscount) throws ServiceException {
        try {
            Tour tour = tourDAO.getEntityByID(idTour);
            tour.setDiscount(amountDiscount);
            update(tour);
        } catch (DAOException e) {
            logger.writeLog("TourService makeDiscount error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    public static Map<Integer, String> getMapToursByRequest(int tourType, int country, int transport, int hotelType, int foodComplex) throws ServiceException {
        try {
            TourDAO tourDAO = new TourDAO();
            List<Tour> list = tourDAO.getToursByRequest(tourType, country, transport, hotelType, foodComplex);

            Map<Integer, String> map = new HashMap<>();

            for (Tour tour : list) {
                int id = tour.getId();
                map.put(id, convertTourToString(id));
            }
            return map;
        } catch (DAOException e) {
            logger.writeLog("TourService getMapToursByRequest error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    public static String convertTourToString(int id) throws ServiceException {
        try {
            TourDAO tourDAO = new TourDAO();
            Tour tour = tourDAO.getEntityByID(id);
            String tourString =
                    tour.getTourType().getTourType() + " " +
                            tour.getCountry().getCountry() + " " +
                            tour.getTransport().getTransport() + " " +
                            tour.getHotelType().getHotelType() + " " +
                            tour.getFoodComplex().getFoodComplex() + " " +
                            tour.getCost() + " " + tour.getDiscount();
            return tourString;
        } catch (DAOException e) {
            logger.writeLog("TourService convertTourToString error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    public Map<Integer, String> getToursMapLimit(int startPage, int sizePage) throws ServiceException {
        try {
            List<Tour> list = tourDAO.getToursWithLimit(startPage, sizePage);
            Map<Integer, String> map = new HashMap<>();
            for (Tour tour : list) {
                int idTour = tour.getId();
                map.put(idTour, convertTourToString(idTour));
            }
            return map;
        } catch (DAOException e) {
            logger.writeLog("TourService getToursMapLimit error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    public int getCountTours() throws ServiceException {
        try {
            return tourDAO.getCountTours();
        } catch (DAOException e) {
            logger.writeLog("TourService getCountTours error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }
}