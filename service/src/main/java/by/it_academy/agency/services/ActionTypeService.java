package by.it_academy.agency.services;

import by.it_academy.agency.beans.ActionType;
import by.it_academy.agency.dao.ActionTypeDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;

import java.util.List;

public class ActionTypeService implements IService<ActionType> {
    private ActionTypeDAO actionTypeDAO = new ActionTypeDAO();

    @Override
    public void add(ActionType actionType) {

    }

    @Override
    public void update(ActionType actionType) {

    }

    @Override
    public ActionType getById(int id) throws ServiceException {
        try {
            return actionTypeDAO.getEntityByID(id);
        } catch (DAOException e) {
            logger.writeLog("Get entity bu id error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<ActionType> getAll() throws ServiceException {
        try {
            return actionTypeDAO.getAll();
        } catch (DAOException e) {
            logger.writeLog("Get all error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    public ActionType getEntityByActionType(String actionType) throws ServiceException {
        try {
            return actionTypeDAO.getEntityByActionType(actionType);
        } catch (DAOException e) {
            logger.writeLog("Get entity by action type error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }
}
