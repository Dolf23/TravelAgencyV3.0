package by.it_academy.agency.services;

import by.it_academy.agency.beans.Action;
import by.it_academy.agency.beans.User;
import by.it_academy.agency.dao.ActionDAO;
import by.it_academy.agency.exceptions.DAOException;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionService implements IService<Action> {

    private ActionDAO actionDAO = new ActionDAO();

    @Override
    public void add(Action action) throws ServiceException {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            actionDAO.createEntity(action);
            session.getTransaction().commit();
        } catch (DAOException e) {
            logger.writeLog("ActionService add error:" + e.getMessage());
            session.getTransaction().rollback();
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void update(Action action) {
    }

    @Override
    public Action getById(int id) throws ServiceException {
        try {
            return actionDAO.getEntityByID(id);
        } catch (DAOException e) {
            logger.writeLog("ActionService getByAll error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Action> getAll() throws ServiceException {
        try {
            return actionDAO.getAll();
        } catch (DAOException e) {
            logger.writeLog("ActionService getAll error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    public static Map<Integer, String> getUserActions(User user) throws ServiceException {
        try {
            ActionDAO actionDAO = new ActionDAO();
            List<Action> list = actionDAO.getListUserActions(user);
            Map<Integer, String> map = new HashMap<>();

            for (Action action : list) {
                int id = action.getId();
                map.put(id, TourService.convertTourToString(id));
            }

            return map;
        } catch (DAOException e) {
            logger.writeLog("ActionService getUserActions error:" + e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    public void deleteAction(User user, int idTour) throws ServiceException {
        Session session = null;
        try {
            ActionDAO actionDAO = new ActionDAO();
            Action action = actionDAO.getActionByUserAndTour(user.getId(), idTour);
            session = HibernateUtil.getSession();
            session.beginTransaction();
            actionDAO.delete(action);
            session.getTransaction().commit();
        } catch (DAOException e) {
            logger.writeLog("ActionService deleteActions error:" + e.getMessage());
            session.getTransaction().rollback();
            throw new ServiceException(e.getMessage());
        }
    }
}