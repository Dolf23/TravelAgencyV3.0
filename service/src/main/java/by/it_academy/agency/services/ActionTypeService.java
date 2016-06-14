package by.it_academy.agency.services;

import by.it_academy.agency.connectionpool.ConnectionPool;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.dao.ActionTypeDAO;
import by.it_academy.agency.beans.ActionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ActionTypeService implements IService<ActionType> {
    @Override
    public void add(ActionType actionType) throws SQLException {

    }

    @Override
    public void update(ActionType actionType) throws SQLException {

    }

    @Override
    public ActionType getById(int id) throws SQLException {
        return ActionTypeDAO.INSTANCE.getEntityByID(id);
    }

    @Override
    public List<ActionType> getAll() throws SQLException {
        return ActionTypeDAO.INSTANCE.getAll();
    }

    public static int getIdByActionType(String actionType) throws SQLException {
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
