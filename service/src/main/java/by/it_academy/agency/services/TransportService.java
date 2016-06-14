package by.it_academy.agency.services;

import by.it_academy.agency.connectionpool.ConnectionPool;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.dao.TransportDAO;
import by.it_academy.agency.beans.Transport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static by.it_academy.agency.constants.ColumnNames.TRANSPORTS_ID;

public class TransportService implements IService<Transport> {
    @Override
    public void add(Transport transport) throws SQLException {

    }

    @Override
    public void update(Transport transport) throws SQLException {

    }

    @Override
    public Transport getById(int id) throws SQLException {
        return TransportDAO.INSTANCE.getEntityByID(id);
    }

    @Override
    public List<Transport> getAll() throws SQLException {
        return TransportDAO.INSTANCE.getAll();
    }

    public int getIdByTransport(String transport) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ID_BY_TRANSPORT);
        statement.setString(1, transport);
        ResultSet resultSet = statement.executeQuery();

        int id;
        if (resultSet.next())
            id = resultSet.getInt(TRANSPORTS_ID);
        else
            id = 0;
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return id;
    }
}
