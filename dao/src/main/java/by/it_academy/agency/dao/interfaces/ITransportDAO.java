package by.it_academy.agency.dao.interfaces;

import by.it_academy.agency.beans.Transport;
import by.it_academy.agency.exceptions.DAOException;

public interface ITransportDAO extends DAO<Transport> {
    Transport getEntityByTransport(String transport) throws DAOException;
}
