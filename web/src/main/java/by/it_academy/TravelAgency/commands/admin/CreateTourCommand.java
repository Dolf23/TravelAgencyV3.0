package by.it_academy.TravelAgency.commands.admin;

import by.it_academy.TravelAgency.commands.AbstractCommand;
import by.it_academy.TravelAgency.constants.ConfigsConstants;
import by.it_academy.TravelAgency.constants.MessageConstants;
import by.it_academy.TravelAgency.constants.Parameters;
import by.it_academy.TravelAgency.dao.CountryDAO;
import by.it_academy.TravelAgency.dao.TourDAO;
import by.it_academy.TravelAgency.dto.Country;
import by.it_academy.TravelAgency.dto.Tour;
import by.it_academy.TravelAgency.logger.logger;
import by.it_academy.TravelAgency.managers.ConfigurationManager;
import by.it_academy.TravelAgency.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;


public class CreateTourCommand extends AbstractCommand {
    private static int fk_country;
    private static int fk_tour_type;
    private static int fk_transport;
    private static int fk_hotel_type;
    private static int fk_food_complex;
    private static int cost;
    private static int discount;

    @Override
    public String execute(HttpServletRequest request) {
        String page;

        try {
            String country = request.getParameter(Parameters.COUNTRY);
            if (!country.isEmpty()) {
                fk_country = getIdCountry(country);
                fk_tour_type = Integer.parseInt(request.getParameter(Parameters.TOUR_TYPE));
                fk_transport = Integer.parseInt(request.getParameter(Parameters.TRANSPORT));
                fk_hotel_type = Integer.parseInt(request.getParameter(Parameters.HOTEL_TYPE));
                fk_food_complex = Integer.parseInt(request.getParameter(Parameters.FOOD_COMPLEX));
                cost = Integer.parseInt(request.getParameter(Parameters.COST));
                discount = 0;
                createTour();
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_CREATE_TOUR_PAGE_PATH);
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
            } else {
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_CREATE_TOUR_PAGE_PATH);
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_FIELDS));
            }
        } catch (SQLException e) {
            logger.writeLog(e.getMessage());
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        } catch (NumberFormatException e) {
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_CREATE_TOUR_PAGE_PATH);
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.INVALID_NUMBER_FORMAT));
        }
        return page;
    }

    private int getIdCountry(String country) throws SQLException {
        int id = CountryDAO.INSTANCE.getIdByCountry(country);
        if (0 == id) {
            Country entity = new Country();
            entity.setCountry(country);
            CountryDAO.INSTANCE.createEntity(entity);
            id = CountryDAO.INSTANCE.getIdByCountry(country);
        }
        return id;
    }

    private void createTour() throws SQLException {
        Tour tour = new Tour();
        tour.setFk_country(fk_country);
        tour.setFk_tour_type(fk_tour_type);
        tour.setFk_transport(fk_transport);
        tour.setFk_hotel_type(fk_hotel_type);
        tour.setFk_food_complex(fk_food_complex);
        tour.setCost(cost);
        tour.setDiscount(discount);
        TourDAO.INSTANCE.createEntity(tour);
    }

}
