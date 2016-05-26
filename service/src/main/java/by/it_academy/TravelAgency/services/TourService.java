package by.it_academy.TravelAgency.services;

import by.it_academy.TravelAgency.connectionpool.ConnectionPool;
import by.it_academy.TravelAgency.constants.SQLRequests;
import by.it_academy.TravelAgency.dao.*;
import by.it_academy.TravelAgency.dto.Tour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.it_academy.TravelAgency.constants.ColumnNames.TOURS_ID;

public class TourService implements IService<Tour> {
    @Override
    public void add(Tour tour) throws SQLException {
        TourDAO.INSTANCE.createEntity(tour);
    }

    @Override
    public void update(Tour tour) throws SQLException {
        TourDAO.INSTANCE.updateEntity(tour);
    }

    @Override
    public Tour getById(int id) throws SQLException {
        return TourDAO.INSTANCE.getEntityByID(id);
    }

    @Override
    public List<Tour> getAll() throws SQLException {
        return TourDAO.INSTANCE.getAll();
    }

    public static void makeDiscount(int idTour, int amountDiscount) throws SQLException {
        Tour tour = TourDAO.INSTANCE.getEntityByID(idTour);
        tour.setDiscount(amountDiscount);
        new TourService().update(tour);
    }

    public static Map<Integer, String> getMapToursByRequest(int tourType, int country, int transport, int hotelType, int foodComplex) throws SQLException {
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

    public static String convertTourToString(int id) throws SQLException {
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
