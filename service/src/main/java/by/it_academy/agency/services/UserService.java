package by.it_academy.agency.services;

import by.it_academy.agency.beans.User;
import by.it_academy.agency.dao.UserDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class UserService implements IService<User> {
    private UserDAO userDAO = new UserDAO();

    @Override
    public void add(User user) throws ServiceException {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            userDAO.createEntity(user);
            session.getTransaction().commit();
        } catch (DAOException e) {
            logger.writeLog("UserService add error:" + e.getMessage());
            session.getTransaction().rollback();
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User getById(int id) throws ServiceException {
        try {
            return userDAO.getEntityByID(id);
        } catch (DAOException e) {
            logger.writeLog("UserService getById error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<User> getAll() throws ServiceException {
        try {
            return userDAO.getAll();
        } catch (DAOException e) {
            logger.writeLog("UserService getAll error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    public static boolean isAuthorized(String login, String password) throws ServiceException {
        try {
            boolean isLogIn = false;
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUserByLoginAndPassword(login, password);
            if (user != null)
                isLogIn = true;
            return isLogIn;
        } catch (DAOException e) {
            logger.writeLog("UserService isAuthorized error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    public static String checkRole(String login) throws ServiceException {
        try {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUserByLogin(login);
            String roleString = user.getRole().getRole();
            return roleString;
        } catch (DAOException e) {
            logger.writeLog("UserService checkRole error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    public static User getUserByLogin(String login) throws ServiceException {
        UserDAO userDAO = new UserDAO();
        try {
            return userDAO.getUserByLogin(login);
        } catch (DAOException e) {
            logger.writeLog("UserService getUserByLogin error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    public static boolean isNewUser(String login) throws ServiceException {
        try {
            boolean isNew = true;
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUserByLogin(login);
            if (user != null)
                isNew = false;
            return isNew;
        } catch (DAOException e) {
            logger.writeLog("UserService isUserNew error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }
}
