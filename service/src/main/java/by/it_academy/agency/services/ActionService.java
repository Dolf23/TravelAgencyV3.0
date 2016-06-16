package by.it_academy.agency.services;

import by.it_academy.agency.beans.Action;
import by.it_academy.agency.beans.User;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.dao.ActionDAO;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionService implements IService<Action> {
    @Override
    public void add(Action action) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            ActionDAO.INSTANCE.createEntity(action);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            logger.writeLog(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            HibernateUtil.releaseSession(session);
        }
    }

    @Override
    public void update(Action action) {
    }

    @Override
    public Action getById(int id) {
        return ActionDAO.INSTANCE.getEntityByID(id);
    }

    @Override
    public List<Action> getAll() {
        return ActionDAO.INSTANCE.getAll();
    }

    public static Map<Integer, String> getUserActions(User user) throws SQLException {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery(SQLRequests.GET_ACTION_BY_USER);
        query.setParameter(ColumnNames.ACTIONS_FK_USER, user.getId());
        List<Action> list = query.list();
        Map<Integer, String> map = new HashMap<>();

        for (Action action : list) {
            int id = action.getId();
            map.put(id, TourService.convertTourToString(id));
        }

        return map;
    }

    public static void deleteAction(User user, int idAction) throws SQLException {
        /*Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.DELETE_ACTION_BY_USER_AND_TOUR);
        statement.setInt(1, user.getId());
        statement.setInt(2, idAction);
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);*/
        //TODO
    }
}
