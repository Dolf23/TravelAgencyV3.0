package by.it_academy.agency.dao;

import by.it_academy.agency.connectionpool.ConnectionPool;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.TravelAgency.dto.HotelType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.it_academy.agency.constants.ColumnNames.HOTEL_TYPES_HOTEL_TYPE;
import static by.it_academy.agency.constants.ColumnNames.HOTEL_TYPES_ID;

public enum HotelTypeDAO implements DAO<HotelType> {
    INSTANCE;

    @Override
    public List<HotelType> getAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ALL_HOTEL_TYPES);
        ResultSet resultSet = statement.executeQuery();
        List<HotelType> list = new ArrayList<>();
        while (resultSet.next()) {
            HotelType hotelType = new HotelType();
            hotelType.setId(resultSet.getInt(HOTEL_TYPES_ID));
            hotelType.setHotelType(resultSet.getString(HOTEL_TYPES_HOTEL_TYPE));
            list.add(hotelType);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return list;
    }

    @Override
    public void createEntity(HotelType hotelType) throws SQLException {

    }

    @Override
    public HotelType getEntityByID(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_HOTEL_TYPE_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        HotelType hotelType = new HotelType();
        while (resultSet.next()) {
            hotelType.setId(resultSet.getInt(HOTEL_TYPES_ID));
            hotelType.setHotelType(resultSet.getString(HOTEL_TYPES_HOTEL_TYPE));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return hotelType;
    }
}
