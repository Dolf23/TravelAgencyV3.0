package by.it_academy.agency.commands.admin;

import by.it_academy.agency.beans.Country;
import by.it_academy.agency.beans.Tour;
import by.it_academy.agency.commands.AbstractCommand;
import by.it_academy.agency.constants.ConfigsConstants;
import by.it_academy.agency.constants.MessageConstants;
import by.it_academy.agency.constants.Parameters;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.managers.ConfigurationManager;
import by.it_academy.agency.managers.MessageManager;
import by.it_academy.agency.services.*;

import javax.servlet.http.HttpServletRequest;


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
        } catch (ServiceException e) {
            logger.writeLog(e.getMessage());
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        } catch (NumberFormatException e) {
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_CREATE_TOUR_PAGE_PATH);
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.INVALID_NUMBER_FORMAT));
        }
        return page;
    }

    private int getIdCountry(String country) throws ServiceException {
        CountryService countryService = new CountryService();
        int id = countryService.getEntityByCountry(country).getId();
        if (0 == id) {
            Country entity = new by.it_academy.agency.beans.Country();
            entity.setCountry(country);
            new CountryService().add(entity);
            id = countryService.getEntityByCountry(country).getId();
        }
        return id;
    }

    private void createTour() throws ServiceException {
        Tour tour = new Tour();
        CountryService countryService = new CountryService();
        tour.setCountry(countryService.getById(fk_country));
        TourTypeService tourTypeService = new TourTypeService();
        tour.setTourType(tourTypeService.getById(fk_tour_type));
        TransportService transportService = new TransportService();
        tour.setTransport(transportService.getById(fk_transport));
        HotelTypeService hotelTypeService = new HotelTypeService();
        tour.setHotelType(hotelTypeService.getById(fk_hotel_type));
        FoodComplexService foodComplexService = new FoodComplexService();
        tour.setFoodComplex(foodComplexService.getById(fk_food_complex));
        tour.setCost(cost);
        tour.setDiscount(discount);
        new TourService().add(tour);
    }

}
