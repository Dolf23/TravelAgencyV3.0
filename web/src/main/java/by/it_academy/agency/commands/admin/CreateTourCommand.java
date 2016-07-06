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
import by.it_academy.agency.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;


public class CreateTourCommand extends AbstractCommand {
    private int fk_country;
    private int fk_tour_type;
    private int fk_transport;
    private int fk_hotel_type;
    private int fk_food_complex;
    private int cost;
    private int discount;

    @Autowired
    private ITourService tourService;
    @Autowired
    private ICountryService countryService;
    @Autowired
    private ITourTypeService tourTypeService;
    @Autowired
    private ITransportService transportService;
    @Autowired
    private IHotelTypeService hotelTypeService;
    @Autowired
    private IFoodComplexService foodComplexService;

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
        Country countryObj = countryService.getEntityByCountry(country);
        int id;
        if (countryObj == null) {
            countryObj = new Country();
            countryObj.setCountry(country);
            countryService.add(countryObj);
        }
        id = countryService.getEntityByCountry(country).getId();
        return id;
    }

    private void createTour() throws ServiceException {
        Tour tour = new Tour();
        tour.setCountry(countryService.getById(fk_country));
        tour.setTourType(tourTypeService.getById(fk_tour_type));
        tour.setTransport(transportService.getById(fk_transport));
        tour.setHotelType(hotelTypeService.getById(fk_hotel_type));
        tour.setFoodComplex(foodComplexService.getById(fk_food_complex));
        tour.setCost(cost);
        tour.setDiscount(discount);
        tourService.add(tour);
    }

}
