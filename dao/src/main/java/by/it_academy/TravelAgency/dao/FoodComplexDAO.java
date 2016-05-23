package by.it_academy.TravelAgency.dao;

import by.it_academy.TravelAgency.connectionpool.ConnectionPool;
import by.it_academy.TravelAgency.constants.SQLRequests;
import by.it_academy.TravelAgency.dto.FoodComplex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.it_academy.TravelAgency.constants.ColumnNames.FOOD_COMPLEXES_FOOD_COMPLEX;
import static by.it_academy.TravelAgency.constants.ColumnNames.FOOD_COMPLEXES_ID;

public enum FoodComplexDAO implements DAO<FoodComplex> {
    INSTANCE;

    @Override
    public List<FoodComplex> getAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ALL_FOOD_COMPLEXES);
        ResultSet resultSet = statement.executeQuery();
        List<FoodComplex> list = new ArrayList<>();
        while (resultSet.next()) {
            FoodComplex foodComplex = new FoodComplex();
            foodComplex.setId(resultSet.getInt(FOOD_COMPLEXES_ID));
            foodComplex.setFoodComplex(resultSet.getString(FOOD_COMPLEXES_FOOD_COMPLEX));
            list.add(foodComplex);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return list;
    }

    @Override
    public void createEntity(FoodComplex foodComplex) throws SQLException {

    }

    @Override
    public FoodComplex getEntityByID(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_FOOD_COMPLEX_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        FoodComplex foodComplex = new FoodComplex();
        while (resultSet.next()) {
            foodComplex.setId(resultSet.getInt(FOOD_COMPLEXES_ID));
            foodComplex.setFoodComplex(resultSet.getString(FOOD_COMPLEXES_FOOD_COMPLEX));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return foodComplex;
    }

    public int getIdByFoodComplex(String foodComplex) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ID_BY_FOOD_COMPLEX);
        statement.setString(1, foodComplex);
        ResultSet resultSet = statement.executeQuery();

        int id;
        if (resultSet.next())
            id = resultSet.getInt(FOOD_COMPLEXES_ID);
        else
            id = 0;
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return id;
    }
}
