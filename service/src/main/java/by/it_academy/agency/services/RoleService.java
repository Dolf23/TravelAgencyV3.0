package by.it_academy.agency.services;

import by.it_academy.agency.connectionpool.ConnectionPool;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.dao.RoleDAO;
import by.it_academy.agency.constants.ColumnNames;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoleService implements IService<by.it_academy.agency.dto.Role> {
    @Override
    public void add(by.it_academy.agency.dto.Role role) throws SQLException {

    }

    @Override
    public void update(by.it_academy.agency.dto.Role role) throws SQLException {

    }

    @Override
    public by.it_academy.agency.dto.Role getById(int id) throws SQLException {
        return RoleDAO.INSTANCE.getEntityByID(id);
    }

    @Override
    public List<by.it_academy.agency.dto.Role> getAll() throws SQLException {
        return RoleDAO.INSTANCE.getAll();
    }

    public static int getIdByRole(String role) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ROLE_ID_BY_ROLE);
        statement.setString(1, role);
        ResultSet resultSet = statement.executeQuery();

        int out = 0;
        while (resultSet.next()) {
            out = resultSet.getInt(ColumnNames.ROLES_ID);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return out;
    }
}
