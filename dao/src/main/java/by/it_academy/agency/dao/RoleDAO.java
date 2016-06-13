package by.it_academy.agency.dao;

import by.it_academy.agency.connectionpool.ConnectionPool;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.TravelAgency.dto.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.it_academy.agency.constants.ColumnNames.ROLES_ID;
import static by.it_academy.agency.constants.ColumnNames.ROLES_ROLE;

public enum RoleDAO implements DAO<Role> {
    INSTANCE;

    @Override
    public List<Role> getAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ALL_ROLES);
        ResultSet resultSet = statement.executeQuery();
        List<Role> list = new ArrayList<>();
        while (resultSet.next()) {
            Role role = new Role();
            role.setId(resultSet.getInt(ROLES_ID));
            role.setRole(resultSet.getString(ROLES_ROLE));
            list.add(role);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return list;
    }

    @Override
    public void createEntity(Role role) throws SQLException {

    }

    @Override
    public Role getEntityByID(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ROLE_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        Role role = new Role();
        while (resultSet.next()) {
            role.setId(resultSet.getInt(ROLES_ID));
            role.setRole(resultSet.getString(ROLES_ROLE));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return role;
    }
}
