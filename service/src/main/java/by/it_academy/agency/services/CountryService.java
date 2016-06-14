package by.it_academy.agency.services;

import by.it_academy.agency.connectionpool.ConnectionPool;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.dao.CountryDAO;
import by.it_academy.agency.beans.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static by.it_academy.agency.constants.ColumnNames.COUNTRIES_ID;

public class CountryService implements IService<Country> {
    @Override
    public void add(Country country) throws SQLException {

    }

    @Override
    public void update(Country country) throws SQLException {

    }

    @Override
    public Country getById(int id) throws SQLException {
        return CountryDAO.INSTANCE.getEntityByID(id);
    }

    @Override
    public List<Country> getAll() throws SQLException {
        return CountryDAO.INSTANCE.getAll();
    }

    public static int getIdByCountry(String country) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ID_BY_COUNTRY);
        statement.setString(1, country);
        ResultSet resultSet = statement.executeQuery();

        int id;
        if (resultSet.next())
            id = resultSet.getInt(COUNTRIES_ID);
        else
            id = 0;
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return id;
    }
}
