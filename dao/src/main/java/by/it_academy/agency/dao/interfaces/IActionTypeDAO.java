package by.it_academy.agency.dao.interfaces;

import by.it_academy.agency.beans.ActionType;
import by.it_academy.agency.exceptions.DAOException;

public interface IActionTypeDAO extends DAO<ActionType> {
    ActionType getEntityByActionType(String actionType) throws DAOException;
}
