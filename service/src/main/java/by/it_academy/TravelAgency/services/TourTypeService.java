package by.it_academy.TravelAgency.services;

import by.it_academy.TravelAgency.connectionpool.ConnectionPool;
import by.it_academy.TravelAgency.constants.SQLRequests;
import by.it_academy.TravelAgency.dao.TourTypeDAO;
import by.it_academy.TravelAgency.dto.TourType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static by.it_academy.TravelAgency.constants.ColumnNames.TOUR_TYPES_ID;

public class TourTypeService implements IService<TourType> {
    @Override
    public void add(TourType tourType) throws SQLException {

    }

    @Override
    public void update(TourType tourType) throws SQLException {

    }

    @Override
    public TourType getById(int id) throws SQLException {
        return TourTypeDAO.INSTANCE.getEntityByID(id);
    }

    @Override
    public List<TourType> getAll() throws SQLException {
        return TourTypeDAO.INSTANCE.getAll();
    }

    public int getIdByTourType(String tourType) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ID_BY_TOUR_TYPE);
        statement.setString(1, tourType);
        ResultSet resultSet = statement.executeQuery();

        int id;
        if (resultSet.next())
            id = resultSet.getInt(TOUR_TYPES_ID);
        else
            id = 0;
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return id;
    }
}
