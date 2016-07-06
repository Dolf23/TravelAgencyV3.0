package by.it_academy.agency.services.interfaces;

import by.it_academy.agency.beans.User;
import by.it_academy.agency.exceptions.ServiceException;

public interface IUserService extends IService<User> {
    boolean isAuthorized(String login, String password) throws ServiceException;

    String checkRole(String login) throws ServiceException;

    User getUserByLogin(String login) throws ServiceException;

    boolean isNewUser(String login) throws ServiceException;
}
