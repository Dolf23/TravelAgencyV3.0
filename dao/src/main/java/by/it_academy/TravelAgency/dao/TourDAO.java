package by.it_academy.TravelAgency.dao;

import by.it_academy.TravelAgency.connectionpool.ConnectionPool;
import by.it_academy.TravelAgency.constants.SQLRequests;
import by.it_academy.TravelAgency.dto.Tour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void setDiscountById(Tour tour) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.UPDATE_TOUR_SET_DISCOUNT);
        statement.setInt(1, tour.getDiscount());
        statement.setInt(2, tour.getId());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

    public Map<Integer, String> getMapToursByRequest(int tourType, int country, int transport, int hotelType, int foodComplex) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.GET_TOURS_BY_REQUEST);
        statement.setInt(1, tourType);
        statement.setInt(2, country);
        statement.setInt(3, transport);
        statement.setInt(4, hotelType);
        statement.setInt(5, foodComplex);
        ResultSet resultSet = statement.executeQuery();
        Map<Integer, String> map = new HashMap<>();

        while (resultSet.next()) {
            int id = resultSet.getInt(TOURS_ID);
            map.put(id, convertTourToString(id));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return map;
    }

    public String convertTourToString(int id) throws SQLException {
        Tour tour = TourDAO.INSTANCE.getEntityByID(id);
        String tourString =
                TourTypeDAO.INSTANCE.getEntityByID(tour.getFk_tour_type()).getTourType() + " " +
                        CountryDAO.INSTANCE.getEntityByID(tour.getFk_country()).getCountry() + " " +
                        TransportDAO.INSTANCE.getEntityByID(tour.getFk_transport()).getTransport() + " " +
                        HotelTypeDAO.INSTANCE.getEntityByID(tour.getFk_hotel_type()).getHotelType() + " " +
                        FoodComplexDAO.INSTANCE.getEntityByID(tour.getFk_food_complex()).getFoodComplex() + " " +
                        tour.getCost() + " " + tour.getDiscount();
        return tourString;
    }

    public Map<Integer, String> getAllToursMap() throws SQLException {
        List<Tour> list = getAll();
        Map<Integer, String> map = new HashMap<>();

        for (Tour tour : list) {
            int idTour = tour.getId();
            map.put(idTour, convertTourToString(idTour));
        }
        return map;
    }
}
