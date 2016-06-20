package by.it_academy.agency.commands.guest;

import by.it_academy.agency.beans.User;
import by.it_academy.agency.commands.AbstractCommand;
import by.it_academy.agency.constants.ConfigsConstants;
import by.it_academy.agency.constants.MessageConstants;
import by.it_academy.agency.constants.Parameters;
import by.it_academy.agency.exceptions.ServiceException;
import by.it_academy.agency.logger.logger;
import by.it_academy.agency.managers.ConfigurationManager;
import by.it_academy.agency.managers.MessageManager;
import by.it_academy.agency.services.RoleService;
import by.it_academy.agency.services.UserService;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand extends AbstractCommand {
    private static String name;
    private static String surname;
    private static String email;
    private static String login;
    private static String password;

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        name = request.getParameter(Parameters.NAME);
        surname = request.getParameter(Parameters.SURNAME);
        email = request.getParameter(Parameters.EMAIL);
        login = request.getParameter(Parameters.LOGIN);
        password = request.getParameter(Parameters.PASSWORD);
        int fkRole;
        try {
            RoleService roleService = new RoleService();
            if (null != request.getParameter(Parameters.ROLE))
                fkRole = roleService.getEntityByRole(Parameters.ADMIN).getId();
            else
                fkRole = roleService.getEntityByRole(Parameters.USER).getId();

            if (areFieldsFull()) {
                if (UserService.isNewUser(login)) {
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
        } catch (ServiceException e) {
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

    private void registration(int roleId) throws ServiceException {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);
        RoleService roleService = new RoleService();
        user.setRole(roleService.getById(roleId));
        new UserService().add(user);
    }

}