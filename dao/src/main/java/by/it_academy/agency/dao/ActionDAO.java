package by.it_academy.agency.dao;

import by.it_academy.agency.beans.Action;
import by.it_academy.agency.beans.User;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class ActionDAO extends AbstractDAO<Action> {
    public List<Action> getListUserActions(User user) throws DAOException {
        try {
            Session session = HibernateUtil.getSession();
            Query query = session.createQuery(SQLRequests.GET_ACTION_BY_USER);
            query.setParameter(ColumnNames.ACTIONS_FK_USER, user.getId());
            List<Action> list = query.list();
            return list;
        } catch (HibernateException e) {
            logger.writeLog("ActionDAO getListUserActions error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
    }
}