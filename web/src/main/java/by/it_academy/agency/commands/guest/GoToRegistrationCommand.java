package by.it_academy.agency.commands.guest;

import by.it_academy.agency.commands.AbstractCommand;
import by.it_academy.agency.constants.ConfigsConstants;
import by.it_academy.agency.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class GoToRegistrationCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
        return page;
    }
}