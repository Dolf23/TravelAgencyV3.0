package by.it_academy.agency.services;

import by.it_academy.agency.connectionpool.ConnectionPool;
import by.it_academy.agency.constants.SQLRequests;
import by.it_academy.agency.dao.HotelTypeDAO;
import by.it_academy.agency.constants.ColumnNames;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HotelTypeService implements IService<by.it_academy.agency.dto.HotelType> {
    @Override
    public void add(by.it_academy.agency.dto.HotelType hotelType) throws SQLException {

    }

    @Override
    public void update(by.it_academy.agency.dto.HotelType hotelType) throws SQLException {

    }

    @Override
    public by.it_academy.agency.dto.HotelType getById(int id) throws SQLException {
        return HotelTypeDAO.INSTANCE.getEntityByID(id);
    }

    @Override
    public List<by.it_academy.agency.dto.HotelType> getAll() throws SQLException {
        return HotelTypeDAO.INSTANCE.getAll();
    }

    public int getIdByHotelType(String hotelType) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ID_BY_HOTEL);
        statement.setString(1, hotelType);
        ResultSet resultSet = statement.executeQuery();

        int id;
        if (resultSet.next())
            id = resultSet.getInt(ColumnNames.HOTEL_TYPES_ID);
        else
            id = 0;
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return id;
    }
}
