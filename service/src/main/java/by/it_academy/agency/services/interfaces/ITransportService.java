package by.it_academy.agency.services.interfaces;

import by.it_academy.agency.beans.Transport;
import by.it_academy.agency.exceptions.ServiceException;

public interface ITransportService extends IService<Transport> {
    Transport getEntityByTransport(String transport) throws ServiceException;
}
