package by.it_academy.TravelAgency.filters;

import by.it_academy.TravelAgency.constants.Parameters;
import by.it_academy.TravelAgency.dao.*;
import by.it_academy.TravelAgency.dto.*;
import by.it_academy.TravelAgency.logger.logger;

import javax.servlet.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ListsEntityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            List<TourType> typeTourList = TourTypeDAO.INSTANCE.getAll();
            servletRequest.setAttribute(Parameters.TOUR_TYPE_LIST, typeTourList);

            List<Country> countryList = CountryDAO.INSTANCE.getAll();
            servletRequest.setAttribute(Parameters.COUNTRY_LIST, countryList);

            List<Transport> transportList = TransportDAO.INSTANCE.getAll();
            servletRequest.setAttribute(Parameters.TRANSPORT_LIST, transportList);

            List<HotelType> hotelList = HotelTypeDAO.INSTANCE.getAll();
            servletRequest.setAttribute(Parameters.HOTEL_TYPE_LIST, hotelList);

            List<FoodComplex> foodComplexList = FoodComplexDAO.INSTANCE.getAll();
            servletRequest.setAttribute(Parameters.FOOD_COMPLEX_LIST, foodComplexList);
        } catch (SQLException e) {
            logger.writeLog(e.getMessage());
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
