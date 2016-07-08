package by.it_academy.agency.services;

import by.it_academy.agency.beans.Tour;
import by.it_academy.agency.dao.interfaces.*;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.services.interfaces.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DAOException.class)
public class TourService implements ITourService {

    private ITourDAO dao;

    @Autowired
    private ICountryDAO countryDAO;
    @Autowired
    private ITourTypeDAO tourTypeDAO;
    @Autowired
    private ITransportDAO transportDAO;
    @Autowired
    private IHotelTypeDAO hotelTypeDAO;
    @Autowired
    private IFoodComplexDAO foodComplexDAO;

    @Autowired
    public TourService(ITourDAO dao) {
        this.dao = dao;
    }

    @Override
    public void add(Tour tour) throws ServiceException {
        try {
            dao.createEntity(tour);
        } catch (DAOException e) {
            logger.writeLog("TourService add error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void update(Tour tour) throws ServiceException {
        try {
            dao.updateEntity(tour);
        } catch (DAOException e) {
            logger.writeLog("TourService update error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Tour getById(int id) throws ServiceException {
        try {
            return dao.getEntityByID(id);
        } catch (DAOException e) {
            logger.writeLog("TourService getById error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Tour> getAll() throws ServiceException {
        try {
            return dao.getAll();
        } catch (DAOException e) {
            logger.writeLog("TourService getAll error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void makeDiscount(int idTour, int amountDiscount) throws ServiceException {
        try {
            Tour tour = dao.getEntityByID(idTour);
            tour.setDiscount(amountDiscount);
            update(tour);
        } catch (DAOException e) {
            logger.writeLog("TourService makeDiscount error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Map<Integer, String> getMapToursByRequest(int tourType, int country, int transport, int hotelType, int foodComplex) throws ServiceException {
        try {
            List<Tour> list = dao.getToursByRequest(tourType, country, transport, hotelType, foodComplex);

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

    @Override
    public String convertTourToString(int id) throws ServiceException {
        try {
            Tour tour = dao.getEntityByID(id);
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

    @Override
    public Map<Integer, String> getToursMapLimit(int startRecord, int sizePage) throws ServiceException {
        try {
            List<Tour> list = dao.getToursWithLimit(startRecord, sizePage);
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

    @Override
    public int getCountTours() throws ServiceException {
        try {
            return dao.getCountTours();
        } catch (DAOException e) {
            logger.writeLog("TourService getCountTours error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void createTour(int fk_country, int fk_tour_type, int fk_transport, int fk_hotel_type, int fk_food_complex, int cost) throws ServiceException {
        try {
            Tour tour = new Tour();
            tour.setCountry(countryDAO.getEntityByID(fk_country));
            tour.setTourType(tourTypeDAO.getEntityByID(fk_tour_type));
            tour.setTransport(transportDAO.getEntityByID(fk_transport));
            tour.setHotelType(hotelTypeDAO.getEntityByID(fk_hotel_type));
            tour.setFoodComplex(foodComplexDAO.getEntityByID(fk_food_complex));
            tour.setCost(cost);
            tour.setDiscount(0);
            add(tour);
        } catch (DAOException e) {
            logger.writeLog("TourService createTour error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }
}