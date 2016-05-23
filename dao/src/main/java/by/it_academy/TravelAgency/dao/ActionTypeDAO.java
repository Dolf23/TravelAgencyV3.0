package by.it_academy.TravelAgency.dao;

import by.it_academy.TravelAgency.connectionpool.ConnectionPool;
import by.it_academy.TravelAgency.constants.ColumnNames;
import by.it_academy.TravelAgency.constants.SQLRequests;
import by.it_academy.TravelAgency.dto.ActionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public enum ActionTypeDAO implements DAO<ActionType> {
    INSTANCE;

    @Override
    public List<ActionType> getAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ALL_ACTION_TYPES);
        ResultSet resultSet = statement.executeQuery();
        List<ActionType> list = new ArrayList<>();
        while (resultSet.next()) {
            ActionType actionType = new ActionType();
            actionType.setId(resultSet.getInt(ColumnNames.ACTION_TYPES_ID));
            actionType.setActionType(resultSet.getString(ColumnNames.ACTION_TYPES_ACTION_TYPE));
            list.add(actionType);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return list;
    }

    @Override
    public void createEntity(ActionType actionType) throws SQLException {
    }

    @Override
    public ActionType getEntityByID(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ACTION_TYPE_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        ActionType actionType = new ActionType();
        while (resultSet.next()) {
            actionType.setId(id);
            actionType.setActionType(resultSet.getString(ColumnNames.ACTION_TYPES_ACTION_TYPE));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return actionType;
    }

    public int getIdByActionType(String actionType) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ID_BY_ACTION_TYPE);
        statement.setString(1, actionType);
        ResultSet resultSet = statement.executeQuery();

        int id;
        if (resultSet.next())
            id = resultSet.getInt(ColumnNames.ACTION_TYPES_ID);
        else
            id = 0;
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return id;
    }
}
