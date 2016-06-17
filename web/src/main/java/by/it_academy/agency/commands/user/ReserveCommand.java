package by.it_academy.agency.commands.user;

import by.it_academy.agency.beans.Action;
import by.it_academy.agency.beans.Tour;
import by.it_academy.agency.beans.User;
import by.it_academy.agency.commands.AbstractCommand;
import by.it_academy.agency.constants.ConfigsConstants;
import by.it_academy.agency.constants.MessageConstants;
import by.it_academy.agency.constants.Parameters;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.managers.ConfigurationManager;
import by.it_academy.agency.managers.MessageManager;
import by.it_academy.agency.services.ActionService;
import by.it_academy.agency.services.ActionTypeService;
import by.it_academy.agency.services.TourService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ReserveCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        try {
            String idTourString = request.getParameter(Parameters.RESERVING_TOUR);

            if (null != idTourString) {
                int idTour = Integer.parseInt(idTourString);
                TourService tourService = new TourService();
                Tour tour = tourService.getById(idTour);

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

        } catch (ServiceException e) {
            logger.writeLog(e.getMessage());
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }

    private void reserveTour(Tour tour, User user, String actionType) throws ServiceException {
        Action action = new Action();

        action.setTour(tour);
        action.setUser(user);
        ActionTypeService actionTypeService = new ActionTypeService();
        action.setActionType(actionTypeService.getEntityByActionType(actionType));
        new ActionService().add(action);
    }
}