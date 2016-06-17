package by.it_academy.agency.commands.admin;

import by.it_academy.agency.commands.AbstractCommand;
import by.it_academy.agency.constants.ConfigsConstants;
import by.it_academy.agency.constants.Parameters;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.managers.ConfigurationManager;
import by.it_academy.agency.services.FoodComplexService;
import by.it_academy.agency.services.HotelTypeService;
import by.it_academy.agency.services.TourTypeService;
import by.it_academy.agency.services.TransportService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoToCreateTourCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_CREATE_TOUR_PAGE_PATH);

        try {
            TourTypeService tourTypeService = new TourTypeService();
            List<by.it_academy.agency.beans.TourType> typeTourList = tourTypeService.getAll();
            request.setAttribute(Parameters.TOUR_TYPE_LIST, typeTourList);

            TransportService transportService = new TransportService();
            List<by.it_academy.agency.beans.Transport> transportList = transportService.getAll();
            request.setAttribute(Parameters.TRANSPORT_LIST, transportList);

            HotelTypeService hotelTypeService = new HotelTypeService();
            List<by.it_academy.agency.beans.HotelType> hotelList = hotelTypeService.getAll();
            request.setAttribute(Parameters.HOTEL_TYPE_LIST, hotelList);

            FoodComplexService foodComplexService = new FoodComplexService();
            List<by.it_academy.agency.beans.FoodComplex> foodComplexList = foodComplexService.getAll();
            request.setAttribute(Parameters.FOOD_COMPLEX_LIST, foodComplexList);
        } catch (ServiceException e) {
            logger.writeLog(e.getMessage());
        }
        return page;
    }
}