package by.it_academy.TravelAgency.commands.guest;

import by.it_academy.TravelAgency.constants.ConfigsConstants;
import by.it_academy.TravelAgency.constants.MessageConstants;
import by.it_academy.TravelAgency.constants.Parameters;
import by.it_academy.TravelAgency.commands.AbstractCommand;
import by.it_academy.TravelAgency.dao.RoleDAO;
import by.it_academy.TravelAgency.dao.UserDAO;
import by.it_academy.TravelAgency.dto.User;
import by.it_academy.TravelAgency.logger.logger;
import by.it_academy.TravelAgency.managers.ConfigurationManager;
import by.it_academy.TravelAgency.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

import static by.it_academy.TravelAgency.constants.Parameters.*;

public class RegistrationCommand extends AbstractCommand {
    private static String name;
    private static String surname;
    private static String email;
    private static String login;
    private static String password;

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        name = request.getParameter(NAME);
        surname = request.getParameter(SURNAME);
        email = request.getParameter(EMAIL);
        login = request.getParameter(LOGIN);
        password = request.getParameter(PASSWORD);
        int fkRole;
        try {
            if (null != request.getParameter(ROLE))
                fkRole = RoleDAO.INSTANCE.getIdByRole(ADMIN);
            else
                fkRole = RoleDAO.INSTANCE.getIdByRole(USER);

            if (areFieldsFull()) {
                if (UserDAO.INSTANCE.isNewUser(login)) {
                    registration(fkRole);
                    page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_REGISTRATION));
                } else {
                    page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
                    request.setAttribute(Parameters.ERROR_USER_EXISTS, MessageManager.INSTANCE.getProperty(MessageConstants.USER_EXSISTS));
                }
            } else {
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_FIELDS));
            }
        } catch (SQLException e) {
            logger.writeLog(e.getMessage());
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        } catch (NumberFormatException e) {
            logger.writeLog(e.getMessage());
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.INVALID_NUMBER_FORMAT));
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
        } catch (NullPointerException e) {
            logger.writeLog(e.getMessage());
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
        }
        return page;
    }

    private boolean areFieldsFull() {
        boolean is = false;
        if (!name.isEmpty() & !surname.isEmpty() & !email.isEmpty() & !login.isEmpty() & !password.isEmpty())
            is = true;
        return is;
    }

    private void registration(int fkrole) throws SQLException {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);
        user.setFk_Role(fkrole);
        UserDAO.INSTANCE.createEntity(user);
    }

}
