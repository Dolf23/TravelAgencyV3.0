package by.it_academy.TravelAgency.commands.admin;

import by.it_academy.TravelAgency.commands.AbstractCommand;
import by.it_academy.TravelAgency.constants.ConfigsConstants;
import by.it_academy.TravelAgency.constants.Parameters;
import by.it_academy.TravelAgency.dao.*;
import by.it_academy.TravelAgency.dto.*;
import by.it_academy.TravelAgency.logger.logger;
import by.it_academy.TravelAgency.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class GoToCreateTourCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_CREATE_TOUR_PAGE_PATH);

        try {
            List<TourType> typeTourList = TourTypeDAO.INSTANCE.getAll();
            request.setAttribute(Parameters.TOUR_TYPE_LIST, typeTourList);

            List<Transport> transportList = TransportDAO.INSTANCE.getAll();
            request.setAttribute(Parameters.TRANSPORT_LIST, transportList);

            List<HotelType> hotelList = HotelTypeDAO.INSTANCE.getAll();
            request.setAttribute(Parameters.HOTEL_TYPE_LIST, hotelList);

            List<FoodComplex> foodComplexList = FoodComplexDAO.INSTANCE.getAll();
            request.setAttribute(Parameters.FOOD_COMPLEX_LIST, foodComplexList);
        } catch (SQLException e) {
            logger.writeLog(e.getMessage());
        }
        return page;
    }
}
