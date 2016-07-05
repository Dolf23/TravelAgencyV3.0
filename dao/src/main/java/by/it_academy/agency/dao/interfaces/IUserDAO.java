package by.it_academy.agency.dao.interfaces;

import by.it_academy.agency.beans.User;
import by.it_academy.agency.exceptions.DAOException;

public interface IUserDAO extends DAO<User> {
    User getUserByLoginAndPassword(String login, String password) throws DAOException;

    User getUserByLogin(String login) throws DAOException;
}
