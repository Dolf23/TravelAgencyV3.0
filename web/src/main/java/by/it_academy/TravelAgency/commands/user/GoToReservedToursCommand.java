package by.it_academy.TravelAgency.commands.user;

import by.it_academy.TravelAgency.commands.AbstractCommand;
import by.it_academy.TravelAgency.constants.ConfigsConstants;
import by.it_academy.TravelAgency.constants.MessageConstants;
import by.it_academy.TravelAgency.constants.Parameters;
import by.it_academy.TravelAgency.dao.ActionDAO;
import by.it_academy.TravelAgency.dto.User;
import by.it_academy.TravelAgency.logger.logger;
import by.it_academy.TravelAgency.managers.ConfigurationManager;
import by.it_academy.TravelAgency.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class GoToReservedToursCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(Parameters.USER);

            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.USER_RESERVED_TOURS_PAGE_PATH);
            request.setAttribute(Parameters.TOURS_MAP, ActionDAO.INSTANCE.getUserActions(user));
        } catch (SQLException e) {
            logger.writeLog(e.getMessage());
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }
}
