package by.it_academy.agency.dao;

import by.it_academy.agency.beans.Transport;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public enum TransportDAO implements DAO<Transport> {
    INSTANCE;

    @Override
    public List<Transport> getAll() {
        Session session = HibernateUtil.getSession();
        return session.createQuery(SQLRequests.GET_ALL_TRANSPORTS).list();
    }

    @Override
    public void createEntity(Transport transport) {

    }

    @Override
    public Transport getEntityByID(int id) {
        Session session = HibernateUtil.getSession();
        return (Transport) session.get(Transport.class, id);
    }
}
