package by.it_academy.agency.dao;

import by.it_academy.agency.beans.Action;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public enum ActionDAO implements DAO<Action> {
    INSTANCE;

    @Override
    public List<Action> getAll() {
        Session session = HibernateUtil.getSession();
        return session.createQuery(SQLRequests.GET_ALL_ACTIONS).list();
    }

    @Override
    public void createEntity(Action action) {
        Session session = HibernateUtil.getSession();
        session.save(action);
    }

    @Override
    public Action getEntityByID(int id) {
        Session session = HibernateUtil.getSession();
        return (Action) session.get(Action.class, id);
    }
}
