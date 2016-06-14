package by.it_academy.agency.dao;

import by.it_academy.agency.beans.User;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public enum UserDAO implements DAO<User> {
    INSTANCE;

    @Override
    public List<User> getAll() {
        Session session = HibernateUtil.getSession();
        return session.createQuery(SQLRequests.GET_ALL_USERS).list();
    }

    @Override
    public void createEntity(User user) {
        Session session = HibernateUtil.getSession();
        session.save(user);
    }

    @Override
    public User getEntityByID(int id) {
        Session session = HibernateUtil.getSession();
        return (User) session.get(User.class, id);
    }
}
