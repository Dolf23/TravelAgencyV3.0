package by.it_academy.agency.services;

import by.it_academy.agency.beans.User;
import by.it_academy.agency.dao.interfaces.IUserDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DAOException.class)
public class UserService implements IUserService {

    private IUserDAO dao;

    @Autowired
    public UserService(IUserDAO dao) {
        this.dao = dao;
    }

    @Override
    public void add(User user) throws ServiceException {
        try {
            dao.createEntity(user);
        } catch (DAOException e) {
            logger.writeLog("UserService add error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User getById(int id) throws ServiceException {
        try {
            return dao.getEntityByID(id);
        } catch (DAOException e) {
            logger.writeLog("UserService getById error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<User> getAll() throws ServiceException {
        try {
            return dao.getAll();
        } catch (DAOException e) {
            logger.writeLog("UserService getAll error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean isAuthorized(String login, String password) throws ServiceException {
        try {
            boolean isLogIn = false;
            User user = dao.getUserByLoginAndPassword(login, password);
            if (user != null)
                isLogIn = true;
            return isLogIn;
        } catch (DAOException e) {
            logger.writeLog("UserService isAuthorized error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public String checkRole(String login) throws ServiceException {
        try {
            User user = dao.getUserByLogin(login);
            String roleString = user.getRole().getRole();
            return roleString;
        } catch (DAOException e) {
            logger.writeLog("UserService checkRole error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public User getUserByLogin(String login) throws ServiceException {
        try {
            return dao.getUserByLogin(login);
        } catch (DAOException e) {
            logger.writeLog("UserService getUserByLogin error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean isNewUser(String login) throws ServiceException {
        try {
            boolean isNew = true;
            User user = dao.getUserByLogin(login);
            if (user != null)
                isNew = false;
            return isNew;
        } catch (DAOException e) {
            logger.writeLog("UserService isUserNew error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }
}
