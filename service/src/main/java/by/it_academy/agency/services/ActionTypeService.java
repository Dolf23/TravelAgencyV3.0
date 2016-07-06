package by.it_academy.agency.services;

import by.it_academy.agency.beans.ActionType;
import by.it_academy.agency.dao.interfaces.IActionTypeDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.services.interfaces.IActionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DAOException.class)
public class ActionTypeService implements IActionTypeService {

    private IActionTypeDAO dao;

    @Autowired
    public ActionTypeService(IActionTypeDAO dao) {
        this.dao = dao;
    }

    @Override
    public void add(ActionType actionType) {

    }

    @Override
    public void update(ActionType actionType) {

    }

    @Override
    public ActionType getById(int id) throws ServiceException {
        try {
            return dao.getEntityByID(id);
        } catch (DAOException e) {
            logger.writeLog("Get entity bu id error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<ActionType> getAll() throws ServiceException {
        try {
            return dao.getAll();
        } catch (DAOException e) {
            logger.writeLog("Get all error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public ActionType getEntityByActionType(String actionType) throws ServiceException {
        try {
            return dao.getEntityByActionType(actionType);
        } catch (DAOException e) {
            logger.writeLog("Get entity by action type error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }
}
