package by.it_academy.TravelAgency.dao;

import by.it_academy.TravelAgency.connectionpool.ConnectionPool;
import by.it_academy.TravelAgency.constants.ColumnNames;
import by.it_academy.TravelAgency.constants.SQLRequests;
import by.it_academy.TravelAgency.dto.Action;
import by.it_academy.TravelAgency.dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.it_academy.TravelAgency.constants.ColumnNames.*;

public enum ActionDAO implements DAO<Action> {
    INSTANCE;

    @Override
    public List<Action> getAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ALL_ACTIONS);
        ResultSet resultSet = statement.executeQuery();

        List<Action> list = new ArrayList<>();
        while (resultSet.next()) {
            Action action = new Action();
            action.setId(resultSet.getInt(ACTIONS_ID));
            action.setFk_action(resultSet.getInt(ACTIONS_FK_ACTION));
            action.setFk_user(resultSet.getInt(ACTIONS_FK_USER));
            action.setFk_tour(resultSet.getInt(ACTIONS_FK_TOUR));
            list.add(action);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return list;
    }

    @Override
    public void createEntity(Action action) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.ADD_ACTION);
        statement.setInt(1, action.getFk_action());
        statement.setInt(2, action.getFk_user());
        statement.setInt(3, action.getFk_tour());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

    @Override
    public Action getEntityByID(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ACTION_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        Action action = new Action();
        while (resultSet.next()) {
            action.setId(resultSet.getInt(ACTIONS_ID));
            action.setFk_action(resultSet.getInt(ACTIONS_FK_ACTION));
            action.setFk_user(resultSet.getInt(ACTIONS_FK_USER));
            action.setFk_tour(resultSet.getInt(ACTIONS_FK_TOUR));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return action;
    }

    public Map<Integer, String> getUserActions(User user) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ACTION_BY_USER);
        statement.setInt(1, user.getId());
        ResultSet resultSet = statement.executeQuery();

        Map<Integer, String> map = new HashMap<>();
        while (resultSet.next()) {
            int id = resultSet.getInt(ColumnNames.ACTIONS_FK_TOUR);
            map.put(id, TourDAO.INSTANCE.convertTourToString(id));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return map;
    }

    public void deleteAction(User user, int idAction) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.DELETE_ACTION_BY_USER_AND_TOUR);
        statement.setInt(1, user.getId());
        statement.setInt(2, idAction);
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }
}
