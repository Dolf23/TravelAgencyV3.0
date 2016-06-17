package by.it_academy.agency.dao;

import by.it_academy.agency.beans.ActionType;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ActionTypeDAO extends AbstractDAO<ActionType> {

    public ActionType getEntityByActionType(String actionType) throws DAOException {
        ActionType actionTypeOut;
        try {
            Session session = HibernateUtil.getSession();
            Criteria criteria = session.createCriteria(ActionType.class);
            criteria.add(Restrictions.eq(ColumnNames.ACTION_TYPES_ACTION_TYPE, actionType));
            actionTypeOut = (ActionType) criteria.uniqueResult();
        } catch (HibernateException e) {
            logger.writeLog("Get entity by action type error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
        return actionTypeOut;
    }
}