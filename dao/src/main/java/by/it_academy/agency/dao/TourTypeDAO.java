package by.it_academy.agency.dao;

import by.it_academy.agency.beans.TourType;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public enum TourTypeDAO implements DAO<TourType> {
    INSTANCE;

    @Override
    public List<TourType> getAll() {
        Session session = HibernateUtil.getSession();
        List<TourType> list = session.createQuery(SQLRequests.GET_ALL_TOUR_TYPES).list();
        HibernateUtil.releaseSession(session);
        return list;
    }

    @Override
    public void createEntity(TourType tourType) {

    }

    @Override
    public TourType getEntityByID(int id) {
        Session session = HibernateUtil.getSession();
        TourType tourType = (TourType) session.get(TourType.class, id);
        HibernateUtil.releaseSession(session);
        return tourType;
    }

    public TourType getEntityByTourType(String tourType) {
        Session session = HibernateUtil.getSession();
        TourType tourTypeOut = (TourType) session.get(TourType.class, tourType);
        HibernateUtil.releaseSession(session);
        return tourTypeOut;
    }
}
