package by.it_academy.TravelAgency.services;

import by.it_academy.TravelAgency.connectionpool.ConnectionPool;
import by.it_academy.TravelAgency.constants.SQLRequests;
import by.it_academy.TravelAgency.dao.RoleDAO;
import by.it_academy.TravelAgency.dto.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static by.it_academy.TravelAgency.constants.ColumnNames.ROLES_ID;

public class RoleService implements IService<Role> {
    @Override
    public void add(Role role) throws SQLException {

    }

    @Override
    public void update(Role role) throws SQLException {

    }

    @Override
    public Role getById(int id) throws SQLException {
        return RoleDAO.INSTANCE.getEntityByID(id);
    }

    @Override
    public List<Role> getAll() throws SQLException {
        return RoleDAO.INSTANCE.getAll();
    }

    public static int getIdByRole(String role) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ROLE_ID_BY_ROLE);
        statement.setString(1, role);
        ResultSet resultSet = statement.executeQuery();

        int out = 0;
        while (resultSet.next()) {
            out = resultSet.getInt(ROLES_ID);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return out;
    }
}
