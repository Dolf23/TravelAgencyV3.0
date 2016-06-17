package by.it_academy.agency.dao;

import by.it_academy.agency.beans.Transport;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class TransportDAO extends AbstractDAO<Transport> {

    public Transport getEntityByTransport(String transport) throws DAOException {
        Transport transportOut;
        try {
            Session session = HibernateUtil.getSession();
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