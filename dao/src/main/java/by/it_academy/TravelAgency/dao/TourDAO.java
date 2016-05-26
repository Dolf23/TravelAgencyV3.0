package by.it_academy.TravelAgency.dao;

import by.it_academy.TravelAgency.connectionpool.ConnectionPool;
import by.it_academy.TravelAgency.constants.SQLRequests;
import by.it_academy.TravelAgency.dto.Tour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.it_academy.TravelAgency.constants.ColumnNames.*;

public enum TourDAO implements DAO<Tour> {
    INSTANCE;

    @Override
    public List<Tour> getAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_ALL_TOURS);
        ResultSet resultSet = statement.executeQuery();
        List<Tour> list = new ArrayList<>();

        while (resultSet.next()) {
            Tour tour = new Tour();
            tour.setId(resultSet.getInt(TOURS_ID));
            tour.setFk_country(resultSet.getInt(TOURS_FK_COUNTRY));
            tour.setFk_tour_type(resultSet.getInt(TOURS_FK_TOUR_TYPE));
            tour.setFk_transport(resultSet.getInt(TOURS_FK_TRANSPORT));
            tour.setFk_hotel_type(resultSet.getInt(TOURS_FK_HOTEL_TYPE));
            tour.setFk_food_complex(resultSet.getInt(TOURS_FK_FOOD_COMPLEX));
            tour.setCost(resultSet.getInt(TOURS_COST));
            tour.setDiscount(resultSet.getInt(TOURS_DISCOUNT));
            list.add(tour);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return list;
    }

    @Override
    public void createEntity(Tour tour) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.ADD_TOUR);
        statement.setInt(1, tour.getFk_country());
        statement.setInt(2, tour.getFk_tour_type());
        statement.setInt(3, tour.getFk_transport());
        statement.setInt(4, tour.getFk_hotel_type());
        statement.setInt(5, tour.getFk_food_complex());
        statement.setInt(6, tour.getCost());
        statement.setInt(7, tour.getDiscount());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

    @Override
    public Tour getEntityByID(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_TOUR_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        Tour tour = new Tour();
        while (resultSet.next()) {
            tour.setId(resultSet.getInt(TOURS_ID));
            tour.setFk_country(resultSet.getInt(TOURS_FK_COUNTRY));
            tour.setFk_tour_type(resultSet.getInt(TOURS_FK_TOUR_TYPE));
            tour.setFk_transport(resultSet.getInt(TOURS_FK_TRANSPORT));
            tour.setFk_hotel_type(resultSet.getInt(TOURS_FK_HOTEL_TYPE));
            tour.setFk_food_complex(resultSet.getInt(TOURS_FK_FOOD_COMPLEX));
            tour.setCost(resultSet.getInt(TOURS_COST));
            tour.setDiscount(resultSet.getInt(TOURS_DISCOUNT));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return tour;
    }

    public void updateEntity(Tour tour) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.UPDATE_TOUR_SET_DISCOUNT);
        statement.setInt(1, tour.getDiscount());
        statement.setInt(2, tour.getId());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }
}
