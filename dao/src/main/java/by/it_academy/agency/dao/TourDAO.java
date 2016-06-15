package by.it_academy.agency.dao;

import by.it_academy.agency.beans.Tour;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public enum TourDAO implements DAO<Tour> {
    INSTANCE;

    @Override
    public List<Tour> getAll() {
        Session session = HibernateUtil.getSession();
        List<Tour> list = session.createQuery(SQLRequests.GET_ALL_TOURS).list();
        HibernateUtil.releaseSession(session);
        return list;
    }

    @Override
    public void createEntity(Tour tour) {
        Session session = HibernateUtil.getSession();
        session.save(tour);
    }

    @Override
    public Tour getEntityByID(int id) {
        Session session = HibernateUtil.getSession();
        Tour tour = (Tour) session.get(Tour.class, id);
        HibernateUtil.releaseSession(session);
        return tour;
    }

    public void updateEntity(Tour tour) {
        Session session = HibernateUtil.getSession();
        session.update(tour);
    }
}
