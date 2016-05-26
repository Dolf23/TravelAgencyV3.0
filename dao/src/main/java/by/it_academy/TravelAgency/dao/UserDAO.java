package by.it_academy.TravelAgency.dao;

import by.it_academy.TravelAgency.connectionpool.ConnectionPool;
import by.it_academy.TravelAgency.constants.SQLRequests;
import by.it_academy.TravelAgency.dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.it_academy.TravelAgency.constants.ColumnNames.*;

public enum UserDAO implements DAO<User> {
    INSTANCE;

    @Override
    public List<User> getAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ALL_USERS);
        ResultSet resultSet = statement.executeQuery();
        List<User> list = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt(USERS_ID));
            user.setName(resultSet.getString(USERS_NAME));
            user.setSurname(resultSet.getString(USERS_SURNAME));
            user.setEmail(resultSet.getString(USERS_EMAIL));
            user.setLogin(resultSet.getString(USERS_LOGIN));
            user.setPassword(resultSet.getString(USERS_PASSWORD));
            user.setFk_Role(resultSet.getInt(USERS_FK_ROLE));
            list.add(user);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return list;
    }

    @Override
    public void createEntity(User user) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.ADD_USER);
        statement.setString(1, user.getName());
        statement.setString(2, user.getSurname());
        statement.setString(3, user.getEmail());
        statement.setString(4, user.getLogin());
        statement.setString(5, user.getPassword());
        statement.setInt(6, user.getFk_Role());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

    @Override
    public User getEntityByID(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_USER_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        User user = new User();
        while (resultSet.next()) {
            user.setId(resultSet.getInt(USERS_ID));
            user.setName(resultSet.getString(USERS_NAME));
            user.setSurname(resultSet.getString(USERS_SURNAME));
            user.setEmail(resultSet.getString(USERS_EMAIL));
            user.setLogin(resultSet.getString(USERS_LOGIN));
            user.setPassword(resultSet.getString(USERS_PASSWORD));
            user.setFk_Role(resultSet.getInt(USERS_FK_ROLE));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return user;
    }
}
