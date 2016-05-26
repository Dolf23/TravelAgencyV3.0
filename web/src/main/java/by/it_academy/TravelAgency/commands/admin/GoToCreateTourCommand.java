package by.it_academy.TravelAgency.commands.admin;

import by.it_academy.TravelAgency.commands.AbstractCommand;
import by.it_academy.TravelAgency.constants.ConfigsConstants;
import by.it_academy.TravelAgency.constants.Parameters;
import by.it_academy.TravelAgency.dto.FoodComplex;
import by.it_academy.TravelAgency.dto.HotelType;
import by.it_academy.TravelAgency.dto.TourType;
import by.it_academy.TravelAgency.dto.Transport;
import by.it_academy.TravelAgency.logger.logger;
import by.it_academy.TravelAgency.managers.ConfigurationManager;
import by.it_academy.TravelAgency.services.FoodComplexService;
import by.it_academy.TravelAgency.services.HotelTypeService;
import by.it_academy.TravelAgency.services.TourTypeService;
import by.it_academy.TravelAgency.services.TransportService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class GoToCreateTourCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_CREATE_TOUR_PAGE_PATH);

        try {
            TourTypeService tourTypeService = new TourTypeService();
            List<TourType> typeTourList = tourTypeService.getAll();
            request.setAttribute(Parameters.TOUR_TYPE_LIST, typeTourList);

            TransportService transportService = new TransportService();
            List<Transport> transportList = transportService.getAll();
            request.setAttribute(Parameters.TRANSPORT_LIST, transportList);

            HotelTypeService hotelTypeService = new HotelTypeService();
            List<HotelType> hotelList = hotelTypeService.getAll();
            request.setAttribute(Parameters.HOTEL_TYPE_LIST, hotelList);

            FoodComplexService foodComplexService = new FoodComplexService();
            List<FoodComplex> foodComplexList = foodComplexService.getAll();
            request.setAttribute(Parameters.FOOD_COMPLEX_LIST, foodComplexList);
        } catch (SQLException e) {
            logger.writeLog(e.getMessage());
        }
        return page;
    }
}
