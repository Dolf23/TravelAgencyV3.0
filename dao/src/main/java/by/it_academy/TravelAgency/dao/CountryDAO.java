package by.it_academy.TravelAgency.dao;

import by.it_academy.TravelAgency.connectionpool.ConnectionPool;
import by.it_academy.TravelAgency.constants.SQLRequests;
import by.it_academy.TravelAgency.dto.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.it_academy.TravelAgency.constants.ColumnNames.COUNTRIES_COUNTRY;
import static by.it_academy.TravelAgency.constants.ColumnNames.COUNTRIES_ID;

public enum CountryDAO implements DAO<Country> {
    INSTANCE;

    @Override
    public List<Country> getAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ALL_COUNTRIES);
        ResultSet resultSet = statement.executeQuery();
        List<Country> list = new ArrayList<>();
        while (resultSet.next()) {
            Country country = new Country();
            country.setId(resultSet.getInt(COUNTRIES_ID));
            country.setCountry(resultSet.getString(COUNTRIES_COUNTRY));
            list.add(country);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return list;
    }

    @Override
    public void createEntity(Country country) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.ADD_COUNTRY);
        statement.setString(1, country.getCountry());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

    @Override
    public Country getEntityByID(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_COUNTRY_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        Country country = new Country();
        while (resultSet.next()) {
            country.setId(resultSet.getInt(COUNTRIES_ID));
            country.setCountry(resultSet.getString(COUNTRIES_COUNTRY));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return country;
    }
}
