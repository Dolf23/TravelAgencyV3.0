package by.it_academy.agency.services;

import by.it_academy.agency.connectionpool.ConnectionPool;
import by.it_academy.agency.constants.ColumnNames;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.dao.UserDAO;
import by.it_academy.agency.dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserService implements IService<User> {
    @Override
    public void add(User user) throws SQLException {
        UserDAO.INSTANCE.createEntity(user);
    }

    @Override
    public void update(User user) throws SQLException {

    }

    @Override
    public User getById(int id) throws SQLException {
        return UserDAO.INSTANCE.getEntityByID(id);
    }

    @Override
    public List<User> getAll() throws SQLException {
        return UserDAO.INSTANCE.getAll();
    }

    public static boolean isAuthorized(String login, String password) throws SQLException {
        boolean isLogIn = false;
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.CHECK_AUTHORIZATION);
        statement.setString(1, login);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next())
            isLogIn = true;
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return isLogIn;
    }

    public static String checkRole(String login) throws SQLException {
        String role = "";
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.CHECK_ROLE);
        statement.setString(1, login);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            PreparedStatement statementRole = connection.prepareStatement(SQLRequests.GET_ROLE_BY_ID);
            statementRole.setInt(1, resultSet.getInt(ColumnNames.USERS_FK_ROLE));
            ResultSet resultRole = statementRole.executeQuery();
            if (resultRole.next())
                role = resultRole.getString(ColumnNames.ROLES_ROLE);
        }

        ConnectionPool.INSTANCE.releaseConnection(connection);
        return role;
    }

    public static User getUserByLogin(String login) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_USER_BY_LOGIN);
        statement.setString(1, login);

        ResultSet resultSet = statement.executeQuery();

        User user = null;
        while (resultSet.next()) {
            user = new User();
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

    public static boolean isNewUser(String login) throws SQLException {
        boolean isNew = true;
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.CHECK_LOGIN);
        statement.setString(1, login);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next())
            isNew = false;
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return isNew;
    }
}
