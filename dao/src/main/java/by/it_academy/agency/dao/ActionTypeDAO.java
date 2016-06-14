package by.it_academy.agency.dao;


import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.beans.ActionType;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public enum ActionTypeDAO implements DAO<ActionType> {
    INSTANCE;

    @Override
    public List<ActionType> getAll() {
        Session session = HibernateUtil.getSession();
        return session.createQuery(SQLRequests.GET_ALL_ACTION_TYPES).list();
    }

    @Override
    public void createEntity(ActionType actionType) {
    }

    @Override
    public ActionType getEntityByID(int id) {
        Session session = HibernateUtil.getSession();
        ActionType actionType = (ActionType) session.get(ActionType.class, id);
        return actionType;
    }
}
