package by.it_academy.agency.services;

import by.it_academy.agency.beans.TourType;
import by.it_academy.agency.dao.TourTypeDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;

import java.util.List;

public class TourTypeService implements IService<TourType> {

    private TourTypeDAO tourTypeDAO = new TourTypeDAO();

    @Override
    public void add(TourType tourType) {

    }

    @Override
    public void update(TourType tourType) {

    }

    @Override
    public TourType getById(int id) throws ServiceException {
        try {
            return tourTypeDAO.getEntityByID(id);
        } catch (DAOException e) {
            logger.writeLog("TourTypeService getById error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<TourType> getAll() throws ServiceException {
        try {
            return tourTypeDAO.getAll();
        } catch (DAOException e) {
            logger.writeLog("TourTypeService getAll error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    public TourType getEntityByTourType(String tourType) throws ServiceException {
        try {
            return tourTypeDAO.getEntityByTourType(tourType);
        } catch (DAOException e) {
            logger.writeLog("TourTypeService getEntityByType error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }
}
