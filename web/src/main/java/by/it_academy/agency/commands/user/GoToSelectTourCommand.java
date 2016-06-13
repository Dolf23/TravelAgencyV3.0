package by.it_academy.agency.commands.user;

import by.it_academy.agency.commands.AbstractCommand;
import by.it_academy.agency.constants.ConfigsConstants;
import by.it_academy.agency.constants.Parameters;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.managers.ConfigurationManager;
import by.it_academy.agency.services.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class GoToSelectTourCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.USER_SELECT_TOUR_PAGE_PATH);

        try {
            TourTypeService tourTypeService = new TourTypeService();
            List<by.it_academy.agency.dto.TourType> typeTourList = tourTypeService.getAll();
            request.setAttribute(Parameters.TOUR_TYPE_LIST, typeTourList);

            CountryService countryService = new CountryService();
            List<by.it_academy.agency.dto.Country> countryList = countryService.getAll();
            request.setAttribute(Parameters.COUNTRY_LIST, countryList);

            TransportService transportService = new TransportService();
            List<by.it_academy.agency.dto.Transport> transportList = transportService.getAll();
            request.setAttribute(Parameters.TRANSPORT_LIST, transportList);

            HotelTypeService hotelTypeService = new HotelTypeService();
            List<by.it_academy.agency.dto.HotelType> hotelList = hotelTypeService.getAll();
            request.setAttribute(Parameters.HOTEL_TYPE_LIST, hotelList);

            FoodComplexService foodComplexService = new FoodComplexService();
            List<by.it_academy.agency.dto.FoodComplex> foodComplexList = foodComplexService.getAll();
            request.setAttribute(Parameters.FOOD_COMPLEX_LIST, foodComplexList);
        } catch (SQLException e) {
            logger.writeLog(e.getMessage());
        }
        return page;
    }
}
