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
        return session.createQuery(SQLRequests.GET_ALL_TOURS).list();
    }

    @Override
    public void createEntity(Tour tour) {
        Session session = HibernateUtil.getSession();
        session.save(tour);
    }

    @Override
    public Tour getEntityByID(int id) {
        Session session = HibernateUtil.getSession();
        return (Tour) session.get(Tour.class, id);
    }

    public void updateEntity(Tour tour) {
        Session session = HibernateUtil.getSession();
        session.update(tour);
    }
}
