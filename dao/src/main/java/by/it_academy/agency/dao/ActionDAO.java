package by.it_academy.agency.dao;

import by.it_academy.agency.connectionpool.ConnectionPool;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.TravelAgency.dto.Action;
import by.it_academy.agency.constants.ColumnNames;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            action.setId(resultSet.getInt(ColumnNames.ACTIONS_ID));
            action.setFk_action(resultSet.getInt(ColumnNames.ACTIONS_FK_ACTION));
            action.setFk_user(resultSet.getInt(ColumnNames.ACTIONS_FK_USER));
            action.setFk_tour(resultSet.getInt(ColumnNames.ACTIONS_FK_TOUR));
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
            action.setId(resultSet.getInt(ColumnNames.ACTIONS_ID));
            action.setFk_action(resultSet.getInt(ColumnNames.ACTIONS_FK_ACTION));
            action.setFk_user(resultSet.getInt(ColumnNames.ACTIONS_FK_USER));
            action.setFk_tour(resultSet.getInt(ColumnNames.ACTIONS_FK_TOUR));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return action;
    }
}
