package by.it_academy.agency.services;

import by.it_academy.agency.beans.Transport;
import by.it_academy.agency.dao.TransportDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;

import java.util.List;

public class TransportService implements IService<Transport> {

    private TransportDAO transportDAO = new TransportDAO();

    @Override
    public void add(Transport transport) {

    }

    @Override
    public void update(Transport transport) {

    }

    @Override
    public Transport getById(int id) throws ServiceException {
        try {
            return transportDAO.getEntityByID(id);
        } catch (DAOException e) {
            logger.writeLog("TransportService getById error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Transport> getAll() throws ServiceException {
        try {
            return transportDAO.getAll();
        } catch (DAOException e) {
            logger.writeLog("TransportService getAll error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    public Transport getEntityByTransport(String transport) throws ServiceException {
        try {
            return transportDAO.getEntityByTransport(transport);
        } catch (DAOException e) {
            logger.writeLog("TransportService getEntityByTransport error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }
}
