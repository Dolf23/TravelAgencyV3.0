package by.it_academy.agency.services;

import by.it_academy.agency.connectionpool.ConnectionPool;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.dao.ActionDAO;
import by.it_academy.agency.dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionService implements IService<by.it_academy.agency.dto.Action> {
    @Override
    public void add(by.it_academy.agency.dto.Action action) throws SQLException {
        ActionDAO.INSTANCE.createEntity(action);
    }

    @Override
    public void update(by.it_academy.agency.dto.Action action) throws SQLException {
    }

    @Override
    public by.it_academy.agency.dto.Action getById(int id) throws SQLException {
        return ActionDAO.INSTANCE.getEntityByID(id);
    }

    @Override
    public List<by.it_academy.agency.dto.Action> getAll() throws SQLException {
        return ActionDAO.INSTANCE.getAll();
    }

    public static Map<Integer, String> getUserActions(User user) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ACTION_BY_USER);
        statement.setInt(1, user.getId());
        ResultSet resultSet = statement.executeQuery();

        Map<Integer, String> map = new HashMap<>();
        while (resultSet.next()) {
            int id = resultSet.getInt(ColumnNames.ACTIONS_FK_TOUR);
            map.put(id, TourService.convertTourToString(id));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return map;
    }

    public static void deleteAction(User user, int idAction) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.DELETE_ACTION_BY_USER_AND_TOUR);
        statement.setInt(1, user.getId());
        statement.setInt(2, idAction);
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }
}
