package by.it_academy.TravelAgency.services;

import by.it_academy.TravelAgency.connectionpool.ConnectionPool;
import by.it_academy.TravelAgency.constants.SQLRequests;
import by.it_academy.TravelAgency.dao.HotelTypeDAO;
import by.it_academy.TravelAgency.dto.HotelType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static by.it_academy.TravelAgency.constants.ColumnNames.HOTEL_TYPES_ID;

public class HotelTypeService implements IService<HotelType> {
    @Override
    public void add(HotelType hotelType) throws SQLException {

    }

    @Override
    public void update(HotelType hotelType) throws SQLException {

    }

    @Override
    public HotelType getById(int id) throws SQLException {
        return HotelTypeDAO.INSTANCE.getEntityByID(id);
    }

    @Override
    public List<HotelType> getAll() throws SQLException {
        return HotelTypeDAO.INSTANCE.getAll();
    }

    public int getIdByHotelType(String hotelType) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ID_BY_HOTEL);
        statement.setString(1, hotelType);
        ResultSet resultSet = statement.executeQuery();

        int id;
        if (resultSet.next())
            id = resultSet.getInt(HOTEL_TYPES_ID);
        else
            id = 0;
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return id;
    }
}
