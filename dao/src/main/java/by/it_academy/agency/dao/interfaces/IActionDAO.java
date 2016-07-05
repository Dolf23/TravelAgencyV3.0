package by.it_academy.agency.dao.interfaces;

import by.it_academy.agency.beans.Action;
import by.it_academy.agency.beans.User;
import by.it_academy.agency.exceptions.DAOException;

import java.util.List;

public interface IActionDAO extends DAO<Action> {
    List<Action> getListUserActions(User user) throws DAOException;

    Action getActionByUserAndTour(int idUser, int idTour) throws DAOException;

    void delete(Action action) throws DAOException;
}
