package by.it_academy.agency.services;

import by.it_academy.agency.connectionpool.ConnectionPool;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.dao.FoodComplexDAO;
import by.it_academy.agency.beans.FoodComplex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static by.it_academy.agency.constants.ColumnNames.FOOD_COMPLEXES_ID;

public class FoodComplexService implements IService<FoodComplex> {
    @Override
    public void add(FoodComplex foodComplex) throws SQLException {

    }

    @Override
    public void update(FoodComplex foodComplex) throws SQLException {

    }

    @Override
    public FoodComplex getById(int id) throws SQLException {
        return FoodComplexDAO.INSTANCE.getEntityByID(id);
    }

    @Override
    public List<FoodComplex> getAll() throws SQLException {
        return FoodComplexDAO.INSTANCE.getAll();
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
