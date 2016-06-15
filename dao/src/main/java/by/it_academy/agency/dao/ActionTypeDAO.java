package by.it_academy.agency.dao;


import by.it_academy.agency.beans.ActionType;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public enum ActionTypeDAO implements DAO<ActionType> {
    INSTANCE;

    @Override
    public List<ActionType> getAll() {
        Session session = HibernateUtil.getSession();
        List<ActionType> list = session.createQuery(SQLRequests.GET_ALL_ACTION_TYPES).list();
        HibernateUtil.releaseSession(session);
        return list;
    }

    @Override
    public void createEntity(ActionType actionType) {
    }

    @Override
    public ActionType getEntityByID(int id) {
        Session session = HibernateUtil.getSession();
        ActionType actionType = (ActionType) session.get(ActionType.class, id);
        HibernateUtil.releaseSession(session);
        return actionType;
    }

    public ActionType getEntityByValue(String actionType) {
        Session session = HibernateUtil.getSession();
        ActionType actionTypeOut = (ActionType) session.get(ActionType.class, actionType);
        HibernateUtil.releaseSession(session);
        return actionTypeOut;
    }
}
