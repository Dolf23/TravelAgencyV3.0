package by.it_academy.agency.services;

import by.it_academy.agency.beans.HotelType;
import by.it_academy.agency.dao.interfaces.IHotelTypeDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.services.interfaces.IHotelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DAOException.class)
public class HotelTypeService implements IHotelTypeService {

    private IHotelTypeDAO dao;

    @Autowired
    public HotelTypeService(IHotelTypeDAO dao) {
        this.dao = dao;
    }

    @Override
    public void add(HotelType hotelType) {

    }

    @Override
    public void update(HotelType hotelType) {

    }

    @Override
    public HotelType getById(int id) throws ServiceException {
        try {
            return dao.getEntityByID(id);
        } catch (DAOException e) {
            logger.writeLog("HotelTypeService getById error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<HotelType> getAll() throws ServiceException {
        try {
            return dao.getAll();
        } catch (DAOException e) {
            logger.writeLog("HotelTypeService getAll error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public HotelType getEntityByHotelType(String hotelType) throws ServiceException {
        try {
            return dao.getEntityByHotelType(hotelType);
        } catch (DAOException e) {
            logger.writeLog("HotelTypeService getEntityByHotelType error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }
}
