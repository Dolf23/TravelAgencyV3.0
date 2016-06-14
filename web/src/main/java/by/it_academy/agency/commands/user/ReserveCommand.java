package by.it_academy.agency.commands.user;

import by.it_academy.agency.commands.AbstractCommand;
import by.it_academy.agency.constants.ConfigsConstants;
import by.it_academy.agency.constants.MessageConstants;
import by.it_academy.agency.constants.Parameters;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.managers.ConfigurationManager;
import by.it_academy.agency.managers.MessageManager;
import by.it_academy.agency.services.ActionService;
import by.it_academy.agency.services.ActionTypeService;
import by.it_academy.agency.services.TourService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class ReserveCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        try {
            String idTourString = request.getParameter(Parameters.RESERVING_TOUR);

            if (null != idTourString) {
                int idTour = Integer.parseInt(idTourString);
                TourService tourService = new TourService();
                by.it_academy.agency.beans.Tour tour = tourService.getById(idTour);

                HttpSession session = request.getSession();
                by.it_academy.agency.beans.User user = (by.it_academy.agency.beans.User) session.getAttribute(Parameters.USER);

                String actionType = request.getParameter(Parameters.COMMAND);

                reserveTour(tour, user, actionType);

                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.USER_PAGE_PATH);
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.RESERVE_TOUR));
            } else {
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.USER_PAGE_PATH);
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_CHOICE));
            }

        } catch (SQLException e) {
            logger.writeLog(e.getMessage());
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }

    private void reserveTour(by.it_academy.agency.beans.Tour tour, by.it_academy.agency.beans.User user, String actionType) throws SQLException {
        by.it_academy.agency.beans.Action action = new by.it_academy.agency.beans.Action();

        action.setFk_tour(tour.getId());
        action.setFk_user(user.getId());
        action.setFk_action(ActionTypeService.getIdByActionType(actionType));
        new ActionService().add(action);
    }
}
