package by.it_academy.agency.dao;

import by.it_academy.agency.beans.User;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UserDAO extends AbstractDAO<User> {


    public User getUserByLoginAndPassword(String login, String password) throws DAOException {
        try {
            Session session = HibernateUtil.getSession();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq(ColumnNames.USERS_LOGIN, login));
            criteria.add(Restrictions.eq(ColumnNames.USERS_PASSWORD, password));
            User user = (User) criteria.uniqueResult();
            return user;
        } catch (HibernateException e) {
            logger.writeLog("UserDAO getUserByLoginAndPassword error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
    }

    public User getUserByLogin(String login) throws DAOException {
        try {
            Session session = HibernateUtil.getSession();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq(ColumnNames.USERS_LOGIN, login));
            User user = (User) criteria.uniqueResult();
            return user;
        } catch (HibernateException e) {
            logger.writeLog("UserDAO getUserByLogin error:" + e.getMessage());
            throw new DAOException(e.getMessage());
        }
    }
}