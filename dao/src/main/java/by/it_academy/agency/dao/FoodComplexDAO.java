package by.it_academy.agency.dao;

import by.it_academy.agency.connectionpool.ConnectionPool;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.TravelAgency.dto.FoodComplex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.it_academy.agency.constants.ColumnNames.FOOD_COMPLEXES_FOOD_COMPLEX;
import static by.it_academy.agency.constants.ColumnNames.FOOD_COMPLEXES_ID;

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
}
