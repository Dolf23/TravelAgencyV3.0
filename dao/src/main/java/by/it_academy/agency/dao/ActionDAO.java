package by.it_academy.agency.dao;

import by.it_academy.agency.beans.Action;
import by.it_academy.agency.beans.User;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ActionDAO extends AbstractDAO<Action> {
    public List<Action> getListUserActions(User user) throws DAOException {
        try {
            Session session = HibernateUtil.getSession();
            Criteria criteria = session.createCriteria(Action.class);
            criteria.add(Restrictions.eq(ColumnNames.ACTIONS_FK_USER + "." + ColumnNames.USERS_ID, user.getId()));
            List<Action> list = criteria.list();
            return list;
        } catch (HibernateException e) {
            logger.writeLog("ActionDAO getListUserActions error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
    }

    public Action getActionByUserAndTour(int idUser, int idTour) throws DAOException {
        try {
            Session session = HibernateUtil.getSession();
            Criteria criteria = session.createCriteria(Action.class);
            criteria.add(Restrictions.eq(ColumnNames.ACTIONS_FK_USER + "." + ColumnNames.USERS_ID, idUser));
            criteria.add(Restrictions.eq(ColumnNames.ACTIONS_FK_TOUR + "." + ColumnNames.TOURS_ID, idTour));
            Action action = (Action) criteria.uniqueResult();
            return action;
        } catch (HibernateException e) {
            logger.writeLog("ActionDAO getActionByUserAndTour error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
    }

    public void delete(Action action) throws DAOException {
        try {
            HibernateUtil.getSession().delete(action);
        } catch (HibernateException e) {
            logger.writeLog("ActionDAO delete error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
    }
}