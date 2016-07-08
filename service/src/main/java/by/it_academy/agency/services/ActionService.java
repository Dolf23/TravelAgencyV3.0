package by.it_academy.agency.services;

import by.it_academy.agency.beans.Action;
import by.it_academy.agency.beans.Tour;
import by.it_academy.agency.beans.User;
import by.it_academy.agency.dao.interfaces.IActionDAO;
import by.it_academy.agency.dao.interfaces.IActionTypeDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.services.interfaces.IActionService;
import by.it_academy.agency.services.interfaces.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DAOException.class)
public class ActionService implements IActionService {

    private IActionDAO dao;

    @Autowired
    private ITourService tourService;
    @Autowired
    private IActionTypeDAO actionTypeDAO;

    @Autowired
    public ActionService(IActionDAO dao) {
        this.dao = dao;
    }

    @Override
    public void add(Action action) throws ServiceException {
        try {
            dao.createEntity(action);
        } catch (DAOException e) {
            logger.writeLog("ActionService add error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void update(Action action) {
    }

    @Override
    public Action getById(int id) throws ServiceException {
        try {
            return dao.getEntityByID(id);
        } catch (DAOException e) {
            logger.writeLog("ActionService getByAll error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Action> getAll() throws ServiceException {
        try {
            return dao.getAll();
        } catch (DAOException e) {
            logger.writeLog("ActionService getAll error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Map<Integer, String> getUserActions(User user) throws ServiceException {
        try {
            List<Action> list = dao.getListUserActions(user);
            Map<Integer, String> map = new HashMap<>();
            for (Action action : list) {
                int id = action.getId();
                map.put(id, tourService.convertTourToString(id));
            }

            return map;
        } catch (DAOException e) {
            logger.writeLog("ActionService getUserActions error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void deleteAction(User user, int idTour) throws ServiceException {
        try {
            Action action = dao.getActionByUserAndTour(user.getId(), idTour);
            dao.delete(action);
        } catch (DAOException e) {
            logger.writeLog("ActionService deleteActions error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void reserveTour(Tour tour, User user, String actionType) throws ServiceException {
        try {
            Action action = new Action();
            action.setTour(tour);
            action.setUser(user);
            action.setActionType(actionTypeDAO.getEntityByActionType(actionType));
            add(action);
        } catch (DAOException e) {
            logger.writeLog("ActionService reserveTour error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }
}