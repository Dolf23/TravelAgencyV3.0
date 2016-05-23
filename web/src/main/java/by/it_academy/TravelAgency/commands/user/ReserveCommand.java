package by.it_academy.TravelAgency.commands.user;

import by.it_academy.TravelAgency.commands.AbstractCommand;
import by.it_academy.TravelAgency.constants.ConfigsConstants;
import by.it_academy.TravelAgency.constants.MessageConstants;
import by.it_academy.TravelAgency.constants.Parameters;
import by.it_academy.TravelAgency.dao.ActionDAO;
import by.it_academy.TravelAgency.dao.ActionTypeDAO;
import by.it_academy.TravelAgency.dao.TourDAO;
import by.it_academy.TravelAgency.dto.Action;
import by.it_academy.TravelAgency.dto.Tour;
import by.it_academy.TravelAgency.dto.User;
import by.it_academy.TravelAgency.logger.logger;
import by.it_academy.TravelAgency.managers.ConfigurationManager;
import by.it_academy.TravelAgency.managers.MessageManager;

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
                Tour tour = TourDAO.INSTANCE.getEntityByID(idTour);

                HttpSession session = request.getSession();
                User user = (User) session.getAttribute(Parameters.USER);

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

    private void reserveTour(Tour tour, User user, String actionType) throws SQLException {
        Action action = new Action();

        action.setFk_tour(tour.getId());
        action.setFk_user(user.getId());
        action.setFk_action(ActionTypeDAO.INSTANCE.getIdByActionType(actionType));
        ActionDAO.INSTANCE.createEntity(action);
    }
}
