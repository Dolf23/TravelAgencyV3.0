package by.it_academy.agency.dao;

import by.it_academy.agency.beans.Transport;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.logger.logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class TransportDAO extends AbstractDAO<Transport> {
    private TransportDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Transport getEntityByTransport(String transport) throws DAOException {
        Transport transportOut;
        try {
            Session session = currentSession();
            Criteria criteria = session.createCriteria(Transport.class);
            criteria.add(Restrictions.eq(ColumnNames.TRANSPORTS_TRANSPORT, transport));
            transportOut = (Transport) criteria.uniqueResult();
        } catch (HibernateException e) {
            logger.writeLog("TransportDAO getEntityByTransport error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
        return transportOut;
    }
}