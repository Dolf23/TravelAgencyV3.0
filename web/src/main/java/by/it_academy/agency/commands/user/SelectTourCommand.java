package by.it_academy.agency.commands.user;

import by.it_academy.agency.commands.AbstractCommand;
import by.it_academy.agency.constants.ConfigsConstants;
import by.it_academy.agency.constants.MessageConstants;
import by.it_academy.agency.constants.Parameters;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.managers.ConfigurationManager;
import by.it_academy.agency.managers.MessageManager;
import by.it_academy.agency.services.TourService;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Map;

public class SelectTourCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        int fk_tourType = Integer.parseInt(request.getParameter(Parameters.TOUR_TYPE));
        int fk_country = Integer.parseInt(request.getParameter(Parameters.COUNTRY));
        int fk_transport = Integer.parseInt(request.getParameter(Parameters.TRANSPORT));
        int fk_hotelType = Integer.parseInt(request.getParameter(Parameters.HOTEL_TYPE));
        int fk_foodComplex = Integer.parseInt(request.getParameter(Parameters.FOOD_COMPLEX));

        try {
            Map<Integer, String> map = TourService.getMapToursByRequest(fk_tourType, fk_country, fk_transport, fk_hotelType, fk_foodComplex);
            if (!map.isEmpty()) {
                request.setAttribute(Parameters.TOURS_MAP, map);
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.USER_RESERVE_PAGE_PATH);

            } else {
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.USER_SELECT_TOUR_PAGE_PATH);
                request.setAttribute(Parameters.ERROR_TOUR_LIST_IS_EMPTY, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_TOURS_LIST));
            }
        } catch (Exception e) {
            logger.writeLog(e.getMessage());
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }
}
