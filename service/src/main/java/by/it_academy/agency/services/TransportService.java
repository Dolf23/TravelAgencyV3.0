package by.it_academy.agency.services;

import by.it_academy.agency.beans.Transport;
import by.it_academy.agency.dao.TransportDAO;
import java.util.List;

public class TransportService implements IService<Transport> {
    @Override
    public void add(Transport transport) {

    }

    @Override
    public void update(Transport transport) {

    }

    @Override
    public Transport getById(int id) {
        return TransportDAO.INSTANCE.getEntityByID(id);
    }

    @Override
    public List<Transport> getAll() {
        return TransportDAO.INSTANCE.getAll();
    }

    public Transport getIdByTransport(String transport) {
        return TransportDAO.INSTANCE.getEntityByTransport(transport);
    }
}
