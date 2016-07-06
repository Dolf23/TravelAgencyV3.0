package by.it_academy.agency.services;

import by.it_academy.agency.beans.Transport;
import by.it_academy.agency.dao.interfaces.ITransportDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.services.interfaces.ITransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DAOException.class)
public class TransportService implements ITransportService {

    private ITransportDAO dao;

    @Autowired
    public TransportService(ITransportDAO dao) {
        this.dao = dao;
    }

    @Override
    public void add(Transport transport) {

    }

    @Override
    public void update(Transport transport) {

    }

    @Override
    public Transport getById(int id) throws ServiceException {
        try {
            return dao.getEntityByID(id);
        } catch (DAOException e) {
            logger.writeLog("TransportService getById error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Transport> getAll() throws ServiceException {
        try {
            return dao.getAll();
        } catch (DAOException e) {
            logger.writeLog("TransportService getAll error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Transport getEntityByTransport(String transport) throws ServiceException {
        try {
            return dao.getEntityByTransport(transport);
        } catch (DAOException e) {
            logger.writeLog("TransportService getEntityByTransport error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }
}
