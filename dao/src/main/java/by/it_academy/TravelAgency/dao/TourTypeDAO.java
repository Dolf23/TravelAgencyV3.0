package by.it_academy.TravelAgency.dao;

import by.it_academy.TravelAgency.connectionpool.ConnectionPool;
import by.it_academy.TravelAgency.constants.SQLRequests;
import by.it_academy.TravelAgency.dto.TourType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.it_academy.TravelAgency.constants.ColumnNames.TOUR_TYPES_ID;
import static by.it_academy.TravelAgency.constants.ColumnNames.TOUR_TYPES_TOUR_TYPE;

public enum TourTypeDAO implements DAO<TourType> {
    INSTANCE;

    @Override
    public List<TourType> getAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ALL_TOUR_TYPES);
        ResultSet resultSet = statement.executeQuery();
        List<TourType> list = new ArrayList<>();
        while (resultSet.next()) {
            TourType tourType = new TourType();
            tourType.setId(resultSet.getInt(TOUR_TYPES_ID));
            tourType.setTourType(resultSet.getString(TOUR_TYPES_TOUR_TYPE));
            list.add(tourType);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return list;
    }

    @Override
    public void createEntity(TourType tourType) throws SQLException {

    }

    @Override
    public TourType getEntityByID(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_TOUR_TYPE_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        TourType tourType = new TourType();
        while (resultSet.next()) {
            tourType.setId(resultSet.getInt(TOUR_TYPES_ID));
            tourType.setTourType(resultSet.getString(TOUR_TYPES_TOUR_TYPE));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return tourType;
    }
}
