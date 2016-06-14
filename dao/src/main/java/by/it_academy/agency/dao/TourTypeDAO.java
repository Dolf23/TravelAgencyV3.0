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
        return session.createQuery(SQLRequests.GET_ALL_TOUR_TYPES).list();
    }

    @Override
    public void createEntity(TourType tourType) {

    }

    @Override
    public TourType getEntityByID(int id) {
        Session session = HibernateUtil.getSession();
        return (TourType) session.get(TourType.class, id);
    }
}
