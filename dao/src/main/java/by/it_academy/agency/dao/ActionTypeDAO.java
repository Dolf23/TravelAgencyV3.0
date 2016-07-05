package by.it_academy.agency.dao;

import by.it_academy.agency.beans.ActionType;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.dao.interfaces.IActionTypeDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.logger.logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ActionTypeDAO extends AbstractDAO<ActionType> implements IActionTypeDAO {

    @Autowired
    private ActionTypeDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ActionType getEntityByActionType(String actionType) throws DAOException {
        ActionType actionTypeOut;
        try {
            Session session = currentSession();
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