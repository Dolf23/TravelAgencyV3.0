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
        List<Transport> list = session.createQuery(SQLRequests.GET_ALL_TRANSPORTS).list();
        HibernateUtil.releaseSession(session);
        return list;
    }

    @Override
    public void createEntity(Transport transport) {

    }

    @Override
    public Transport getEntityByID(int id) {
        Session session = HibernateUtil.getSession();
        Transport transport = (Transport) session.get(Transport.class, id);
        HibernateUtil.releaseSession(session);
        return transport;
    }

    public Transport getEntityByTransport(String transport) {
        Session session = HibernateUtil.getSession();
        Transport transportOut = (Transport) session.get(Transport.class, transport);
        HibernateUtil.releaseSession(session);
        return transportOut;
    }
}
