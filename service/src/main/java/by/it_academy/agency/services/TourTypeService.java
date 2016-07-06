package by.it_academy.agency.services;

import by.it_academy.agency.beans.TourType;
import by.it_academy.agency.dao.interfaces.ITourTypeDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.services.interfaces.ITourTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DAOException.class)
public class TourTypeService implements ITourTypeService {

    private ITourTypeDAO dao;

    @Autowired
    public TourTypeService(ITourTypeDAO dao) {
        this.dao = dao;
    }

    @Override
    public void add(TourType tourType) {

    }

    @Override
    public void update(TourType tourType) {

    }

    @Override
    public TourType getById(int id) throws ServiceException {
        try {
            return dao.getEntityByID(id);
        } catch (DAOException e) {
            logger.writeLog("TourTypeService getById error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<TourType> getAll() throws ServiceException {
        try {
            return dao.getAll();
        } catch (DAOException e) {
            logger.writeLog("TourTypeService getAll error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public TourType getEntityByTourType(String tourType) throws ServiceException {
        try {
            return dao.getEntityByTourType(tourType);
        } catch (DAOException e) {
            logger.writeLog("TourTypeService getEntityByType error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }
}
