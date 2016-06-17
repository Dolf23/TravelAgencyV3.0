package by.it_academy.agency.services;

import by.it_academy.agency.beans.HotelType;
import by.it_academy.agency.dao.HotelTypeDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;

import java.util.List;

public class HotelTypeService implements IService<HotelType> {

    private HotelTypeDAO hotelTypeDAO = new HotelTypeDAO();

    @Override
    public void add(HotelType hotelType) {

    }

    @Override
    public void update(HotelType hotelType) {

    }

    @Override
    public HotelType getById(int id) throws ServiceException {
        try {
            return hotelTypeDAO.getEntityByID(id);
        } catch (DAOException e) {
            logger.writeLog("HotelTypeService getById error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<HotelType> getAll() throws ServiceException {
        try {
            return hotelTypeDAO.getAll();
        } catch (DAOException e) {
            logger.writeLog("HotelTypeService getAll error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    public HotelType getEntityByHotelType(String hotelType) throws ServiceException {
        try {
            return hotelTypeDAO.getEntityByHotelType(hotelType);
        } catch (DAOException e) {
            logger.writeLog("HotelTypeService getEntityByHotelType error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }
}
