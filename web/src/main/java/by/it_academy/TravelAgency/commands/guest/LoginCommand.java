package by.it_academy.TravelAgency.commands.guest;

import by.it_academy.TravelAgency.constants.ConfigsConstants;
import by.it_academy.TravelAgency.constants.MessageConstants;
import by.it_academy.TravelAgency.constants.Parameters;
import by.it_academy.TravelAgency.commands.Command;
import by.it_academy.TravelAgency.dao.UserDAO;
import by.it_academy.TravelAgency.dto.User;
import by.it_academy.TravelAgency.logger.logger;
import by.it_academy.TravelAgency.managers.ConfigurationManager;
import by.it_academy.TravelAgency.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(Parameters.LOGIN);
        String password = request.getParameter(Parameters.PASSWORD);
        String page = null;

        try {
            if (UserDAO.INSTANCE.isAuthorized(login, password)) {
                HttpSession session = request.getSession();
                User user = UserDAO.INSTANCE.getUserByLogin(login);
                String role = UserDAO.INSTANCE.checkRole(login);
                session.setAttribute(Parameters.USER_ROLE, role);
                session.setAttribute(Parameters.USER, user);
                if (role.equals(Parameters.ADMIN))
                    page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_PAGE_PATH);
                else
                    page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.USER_PAGE_PATH);

            } else {
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
                request.setAttribute(Parameters.ERROR_LOGIN_OR_PASSWORD, MessageManager.INSTANCE.getProperty(MessageConstants.WRONG_LOGIN_OR_PASSWORD));
            }
        } catch (SQLException e) {
            logger.writeLog(e.getMessage());
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }
}
