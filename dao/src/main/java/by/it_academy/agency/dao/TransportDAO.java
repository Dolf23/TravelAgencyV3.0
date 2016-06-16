package by.it_academy.agency.dao;

import by.it_academy.agency.beans.Transport;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public enum TransportDAO implements DAO<Transport> {
    INSTANCE;

    @Override
    public List<Transport> getAll() {
        Session session = HibernateUtil.getSession();
        List<Transport> list = session.createQuery(SQLRequests.GET_ALL_TRANSPORTS).list();
        return list;
    }

    @Override
    public void createEntity(Transport transport) {

    }

    @Override
    public Transport getEntityByID(int id) {
        Session session = HibernateUtil.getSession();
        Transport transport = (Transport) session.get(Transport.class, id);
        return transport;
    }

    public Transport getEntityByTransport(String transport) {
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(Transport.class);
        criteria.add(Restrictions.eq(ColumnNames.TRANSPORTS_TRANSPORT, transport));
        Transport transportOut = (Transport) criteria.uniqueResult();
        return transportOut;
    }
}
